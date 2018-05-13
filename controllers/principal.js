
"use strict";
var express = require('express');
var router = express.Router();
var daoProyectos = require('../integration/daoProyectos');
var moment = require('moment');
var _ = require('underscore');
var config = require('../config');
var bodyParser = require("body-parser");
var multer = require("multer");
var path = require("path");
var fs = require("fs");
var upload = multer({ dest: "uploads/" });
var exec = require('child_process').exec, child;
var lineReader = require('line-reader');

var DIR_PROYECTO_JAVA='./generadorMutantesJAVA'
var DIR_TESTSPOMS=DIR_PROYECTO_JAVA+'/testsPoms'                // Directorio que contiene todos los ficheros de configuracion por tests (Acumulado)
var DIR_TESTSPOMS_UNIQUE=DIR_PROYECTO_JAVA+'/testsPomsUnique'   // Directorio que contiene todos los ficheros de configuracion por tests (Unico)
var FILE_RESULTADOS=DIR_PROYECTO_JAVA+'/resultados.txt'         // Fichero que contiene los resultados de los test
var DIR_REPORTS=DIR_PROYECTO_JAVA+'/target/pit-reports'         // Directorio que contiene los resultados de los mutantes
var FILE_POM=DIR_PROYECTO_JAVA+'/pom.xml '                      // Fichero de configuracion de maven para ejecutar PIT
var FILE_RESULTADO=DIR_PROYECTO_JAVA+'/resultado.txt'           // Fichero que contiene los resultados de aplicar los mutantes
var FILE_MUTANTES=DIR_PROYECTO_JAVA+'/mutantes.txt'             // Fichero que contiene los mutantes generados
var NAME_CLASSES_ZIP='Classes.zip'                              // Nombre del fichero comprimido de las clases originales
var NAME_TESTS_ZIP='Tests.zip'                                  // Nombre del fichero comprimido de los tests originales

function forEachAll(data, each, finish, sync) {
    var n = -1, result = [];
    var next = sync ?
        function () {
            if (++n < data.length) { each(data[n], result, next); }
            else if (finish)       { finish(result); }
        } :
        (function () {
            function completed() {
                if (++n <= data.length && finish) { finish(result); }
            }
            for (var i = 0; i < data.length; i++) { each(data[i], result, completed); }
            return completed;
        }());
    next();
}

function asyncSqrt(value, callback) {
    console.log('START execution with value =', value);
    setTimeout(function() {
        callback(value, value * value);
    }, 0 | Math.random() * 100);
}

router.post("/procesar_file_Classes",upload.single("Classes"), function(req, res) {
    var urlFichero;
    if (req.file) {
        urlFichero = path.join("proyectos", NAME_CLASSES_ZIP);
        var fichDestino = path.join("public", urlFichero);
        fs.createReadStream(req.file.path).pipe(fs.createWriteStream(fichDestino));
        res.json({exito: true , msg: "Fichero enviado con éxito."});
    } else {
      res.json({exito: false,  msg: "No se ha podido enviar el fichero."});
    }
});

router.post("/procesar_file_Tests",upload.single("Tests"), function(req, res) {
    var urlFichero;
    if (req.file) {
        urlFichero = path.join("proyectos", NAME_TESTS_ZIP);
        var fichDestino = path.join("public", urlFichero);
        fs.createReadStream(req.file.path).pipe(fs.createWriteStream(fichDestino));
        res.json({exito: true , msg: "Fichero enviado con éxito."});
    }else {
      res.json({exito: false, msg: "No se ha podido enviar el fichero."});
    }
});

router.get("/ejecutarOLD/:nombreProyecto/:listaMutantes", function(req, res, next) {
  var nombreProyecto = req.params.nombreProyecto;
  var listaMutantes = req.params.listaMutantes;

  preprocesar(listaMutantes, function (err) {
    if (err) {
      res.json({exito: false, msg:"Error al preprocesar los ficheros."});
    } else {
      child = exec("sh ejecutarTests.sh",
      // Pasamos los parámetros error, stdout la salida
      // que mostrara el comando
        function (error, stdout, stderr) {
          // controlamos el error
          if (error !== null) {
            console.log('exec error: ' + error);
              res.json({exito: false, stderr: stderr});
          } else {

            daoProyectos.insertProyecto(nombreProyecto, function(err, datos) {
              // Muestra error si hay un error en la BD
              if (err) {
                next(err);
              } else {
                // si no se ha podido insertar
                if (!datos.exito) {
                  res.json({exito: false, msg:datos.msg});
                }else {
                  // Guardamos los resultados en la  BD
                  saveResultOnDataBase(datos.insertId, function(err) {
                    if (err) {
                      res.json({exito: false, msg:"No se ha podido guardar los resultados en la BD."});
                    }else {
                      res.json({exito: true, msg:"Resultados guardados en la BD con éxito."});
                    }
                  });
                }
              }
            });
          }
      });
   }
 });
});

router.get("/ejecutar/:nombreProyecto",function(req, res, next) {
    var nombreProyecto = req.params.nombreProyecto;
    var listaMutantes = "0 1 2 3";

    if (nombreProyecto === "") {
      res.json({exito: false, msg: "Parametros vacios."});
    } else {
      preprocesar(listaMutantes, function (err) {
        if (err) {
          res.json({exito: false, msg:"Error al preprocesar los ficheros."});
        } else {
          daoProyectos.insertProyecto(nombreProyecto, function(err, resultInsertProyecto) {
            // Muestra error si hay un error en la BD
            if (err) {
              next(err);
            } else {
              // si no se ha podido insertar
              if (!resultInsertProyecto.exito) {
                res.json({exito: false, msg: resultInsertProyecto.msg});
              }else {

                // Leemos los ficheros de configuracion
                ejecutarComandoLinux( "ls " + DIR_TESTSPOMS, function(err, result_ls) {
                  if (err) {
                    res.json({exito: false, msg: result_ls});
                  } else {
                    var arrayTestFilePom = result_ls.trim().split("\n");
                    var cont = arrayTestFilePom.length;

                    // Para cada fichero de configuracion lo copiamos el fichero de configuracion en el proyecto java y lo ejecutamos
                    forEachAll(arrayTestFilePom,
                      function(testFilePom, allresult, next) {
                          asyncSqrt(testFilePom, function(testFilePom, result) {
                              var comando = "sh ejecutarTest.sh " + testFilePom;
                              ejecutarComandoLinux( comando, function(err, result_et) {
                              if (err) {
                                res.json({exito: false, msg: result_et});
                              } else {
                                console.log("(<--Ejecutando test: " + testFilePom);
                                var comando =  "cat " + FILE_RESULTADO;
                                ejecutarComandoLinux( comando, function(err, result_cr) {
                                  if (err) {
                                    res.json({exito: false, msg: result_cr});
                                  } else {
                                    var arrayResult = result_cr.trim().split(" ");
                                    var datosTest = {}

                                    datosTest.idProyecto = resultInsertProyecto.insertId;
                                    datosTest.nombreTest = arrayResult[0];
                                    datosTest.numMutants = Number(arrayResult[1]);
                                    datosTest.killed = Number(arrayResult[2]);
                                    datosTest.percent = Number(arrayResult[3]);
                                    datosTest.time = Number(arrayResult[4]);

                                    daoProyectos.insertTestProyecto(datosTest, function (err, resultInsertTest) {
                                      if (err) {
                                        next(err);
                                      } else {

                                        if (!resultInsertTest.exito) {
                                          res.json({exito: false, msg: resultInsertProyecto.msg});
                                        } else {

                                          var comando =  "cat " + FILE_MUTANTES ;
                                          // Recorremos los mutantes de la clase
                                          ejecutarComandoLinux( comando, function(err, result_cclass) {
                                            if (err) {
                                              res.json({exito: false, msg: result_cclass});
                                            } else {
                                              var arrayMutantesClase = result_cclass.trim().split("\n");
                                              var contMutante = arrayMutantesClase.length;

                                              arrayMutantesClase.forEach(function(mutante){
                                                var arrayMutante = mutante.split(",");
                                                var datos = {}
                                                datos.idProyecto = resultInsertProyecto.insertId;
                                                datos.idTest = resultInsertTest.insertId;
                                                datos.clase = arrayMutante[0];
                                                datos.mutante =  arrayMutante[1];
                                                datos.killed =  arrayMutante[2];

                                                daoProyectos.insertClasseTestProyecto(datos, function (err, result) {
                                                  if (err) {
                                                    next(err);
                                                  } else {
                                                    contMutante --;

                                                    if (contMutante == 0) {
                                                      cont--;
                                                      allresult.push({value: testFilePom, result: result});
                                                      next();
                                                    }

                                                    // Si ha terminado de ejecutar
                                                    if (cont == 0 && contMutante == 0) {
                                                      res.json({exito: true, msg:result});
                                                    }
                                                  }
                                                });
                                              });
                                            }
                                          });
                                        }
                                      }
                                    });
                                  }
                                });
                              }
                            });

                          });

                      },
                      function(allresult) {
                          console.log('COMPLETED');
                          console.log(allresult);
                      },
                      true
                  );

                  }
                });
              }
            }
          });
        }
      });
    }
});

router.post("/generarProgramaV7/:nombreProyecto",function(req, res, next) {
  var nombreProyecto = req.params.nombreProyecto;
  var listaMutantes = req.body.listaMutantes;
  console.log("<--");
  console.log(req.body);
  // var inputs = "1,2,3,4,5,6,7,8,9,10,11,12,13,"
  var inputs = req.body.listaInputsComprobacion;
  //  var pathPrograma = "./"
  //  var nombrePrograma = "Programa"
  //  var nombreTest = "Test"
  var parametros = "" + req.body.numeroAnidacionesIf + " "
                        +  req.body.numeroAnidacionesWhile + " "
                        +  req.body.numeroIteracionesWhile + " "
                        +  req.body.numeroAnidacionesFor + " "
                        +  req.body.numeroIteracionesFor + " "
                        +  req.body.numeroCondicionesLogicas + " "
                        +  req.body.numeroExpresionesLogicas + " "
                        +  req.body.numeroExpresionesAritmeticas + " "
                        +  inputs + " "
                        +  req.body.numeroExpresionesSeguidas + " "
                        +  req.body.numeroFuncion + " "
                        +  req.body.decicionInputs + " "
                        +  req.body.profundidadInicial + " "
                        +  req.body.profundidadFinal + " ";
                          //      +  pathPrograma + " "
                          //      +  nombreTest + " "
                          //      +  nombrePrograma + " "

    //res.json({exito: true, msg: "<--- ."});
    //return;
    if (nombreProyecto === "") {
      res.json({exito: false, msg: "Parametros vacios."});
    } else {
      ejecutarComandoLinux( "sh generadorPrograma.sh " + parametros, function(err, resultGen) {
        if (err) {
          res.json({exito: false, msg: "Error al ejecutar script generadorPrograma.sh"});
        } else {
          preprocesar(listaMutantes, function (err) {
            if (err) {
              res.json({exito: false, msg:"Error al preprocesar los ficheros."});
            } else {
              daoProyectos.insertProyecto(nombreProyecto, function(err, resultInsertProyecto) {
                // Muestra error si hay un error en la BD
                if (err) {
                  next(err);
                } else {

                  // si no se ha podido insertar
                  if (!resultInsertProyecto.exito) {
                    res.json({exito: false, msg: resultInsertProyecto.msg});
                  }else {

                    // Leemos los ficheros de configuracion
                    ejecutarComandoLinux( "ls " + DIR_TESTSPOMS, function(err, result_ls) {
                      if (err) {
                        res.json({exito: false, msg: "Error al ejecutar ls "+ DIR_TESTSPOMS});
                      } else {
                        var arrayTestFilePom = result_ls.trim().split("\n");
                        var cont = arrayTestFilePom.length;

                        // Para cada fichero de configuracion lo copiamos el fichero de configuracion en el proyecto java y lo ejecutamos
                        arrayTestFilePom.forEach(function(testFilePom){

                          var comando = "sh ejecutarTest.sh " + testFilePom;
                          ejecutarComandoLinux( comando, function(err, result_et) {
                            if (err) {
                              res.json({exito: false, msg: "Error al ejecutar script ejecutarTest.sh"});
                            } else {

                              var comando =  "cat " + FILE_RESULTADO;
                              ejecutarComandoLinux( comando, function(err, result_cr) {
                                if (err) {
                                  res.json({exito: false, msg: "Error al ejecutar cat " + FILE_RESULTADO });
                                } else {
                                  var arrayResult = result_cr.trim().split(" ");
                                  var datosTest = {}
                                  datosTest.idProyecto = resultInsertProyecto.insertId;
                                  datosTest.nombreTest = arrayResult[0];
                                  datosTest.numMutants = Number(arrayResult[1]);
                                  datosTest.killed = Number(arrayResult[2]);
                                  datosTest.percent = Number(arrayResult[3]);
                                  datosTest.time = Number(arrayResult[4]);

                                  if (!isNaN(datosTest.numMutants) && !isNaN(datosTest.killed) && !isNaN(datosTest.percent)&& !isNaN(datosTest.time)) {
                                    daoProyectos.insertTestProyecto(datosTest, function (err, resultInsertTest) {
                                      if (err) {
                                        next(err);
                                      } else {

                                        if (!resultInsertTest.exito) {
                                          res.json({exito: false, msg: resultInsertProyecto.msg});
                                        } else {

                                          var comando =  "cat " + FILE_MUTANTES ;
                                          ejecutarComandoLinux( comando, function(err, result_cclass) {
                                            if (err) {
                                              res.json({exito: false, msg: "Error al ejecutar cat " + FILE_MUTANTES});
                                            } else {
                                              var arrayMutantesClase = result_cclass.trim().split("\n");
                                              var contMutante = arrayMutantesClase.length;

                                              arrayMutantesClase.forEach(function(mutante){
                                                var arrayMutante = mutante.split(",");
                                                var datos = {}
                                                datos.idProyecto = resultInsertProyecto.insertId;
                                                datos.idTest = resultInsertTest.insertId;
                                                datos.clase = arrayMutante[0];
                                                datos.mutante =  arrayMutante[1];
                                                datos.killed =  arrayMutante[2];

                                                daoProyectos.insertClasseTestProyecto(datos, function (err, result) {
                                                  if (err) {
                                                    next(err);
                                                  } else {
                                                    contMutante --;

                                                    if (contMutante == 0) {
                                                      cont--;
                                                    }

                                                    // Si ha terminado de ejecutar
                                                    if (cont == 0) {
                                                      res.json({exito: true, msg:result});
                                                    }
                                                  }
                                                });
                                              });
                                            }
                                          });
                                        }
                                      }
                                    });
                                  } else {
                                    res.json({exito: false, msg: "Error el proyecto no ha generado mutantes"});
                                  }
                                }
                              });
                            }
                          });
                        });
                      }
                    });
                  }
                }
              });
            }
          });
        }
      });
    }
});

router.post("/generarPrograma/:nombreProyecto",function(req, res, next) {
  var nombreProyecto = req.params.nombreProyecto;
  var listaMutantes = req.body.listaMutantes;

  // var inputs = "1,2,3,4,5,6,7,8,9,10,11,12,13,"
  var inputs = req.body.listaInputsComprobacion;
  //  var pathPrograma = "./"
  //  var nombrePrograma = "Programa"
  //  var nombreTest = "Test"
  var parametros = "" + req.body.numeroAnidacionesIf + " "
                        +  req.body.numeroAnidacionesWhile + " "
                        +  req.body.numeroIteracionesWhile + " "
                        +  req.body.numeroAnidacionesFor + " "
                        +  req.body.numeroIteracionesFor + " "
                        +  req.body.numeroCondicionesLogicas + " "
                        +  req.body.numeroExpresionesLogicas + " "
                        +  req.body.numeroExpresionesAritmeticas + " "
                        +  inputs + " "
                        +  req.body.numeroExpresionesSeguidas + " "
                        +  req.body.numeroFuncion + " "
                        +  req.body.decicionInputs + " "
                        +  req.body.size_tests + " ";
                          //      +  pathPrograma + " "
                          //      +  nombreTest + " "
                          //      +  nombrePrograma + " "

    //res.json({exito: true, msg: "<--- ."});
    //return;
    if (nombreProyecto === "") {
      res.json({exito: false, msg: "Parametros vacios."});
    } else {
      ejecutarComandoLinux( "sh generadorPrograma.sh " + parametros, function(err, resultGen) {
        if (err) {
          res.json({exito: false, msg: "Error al ejecutar script generadorPrograma.sh"});
        } else {
          preprocesar(listaMutantes, function (err) {
            if (err) {
              res.json({exito: false, msg:"Error al preprocesar los ficheros."});
            } else {
              daoProyectos.insertProyecto(nombreProyecto, function(err, resultInsertProyecto) {
                // Muestra error si hay un error en la BD
                if (err) {
                  next(err);
                } else {

                  // si no se ha podido insertar
                  if (!resultInsertProyecto.exito) {
                    res.json({exito: false, msg: resultInsertProyecto.msg});
                  }else {

                    // Leemos los ficheros de configuracion
                    ejecutarComandoLinux( "ls " + DIR_TESTSPOMS, function(err, result_ls) {
                      if (err) {
                        res.json({exito: false, msg: result_ls});
                      } else {
                        var arrayTestFilePom = result_ls.trim().split("\n");
                        var cont = arrayTestFilePom.length;

                        // Para cada fichero de configuracion lo copiamos el fichero de configuracion en el proyecto java y lo ejecutamos
                        forEachAll(arrayTestFilePom,
                          function(testFilePom, allresult, next) {
                              asyncSqrt(testFilePom, function(testFilePom, result) {
                                  var comando = "sh ejecutarTest.sh " + testFilePom;
                                  ejecutarComandoLinux( comando, function(err, result_et) {
                                  if (err) {
                                    res.json({exito: false, msg: result_et});
                                  } else {
                                    console.log("(<--Ejecutando test: " + testFilePom);
                                    var comando =  "cat " + FILE_RESULTADO;
                                    ejecutarComandoLinux( comando, function(err, result_cr) {
                                      if (err) {
                                        res.json({exito: false, msg: result_cr});
                                      } else {
                                        var arrayResult = result_cr.trim().split(" ");
                                        var datosTest = {}

                                        datosTest.idProyecto = resultInsertProyecto.insertId;
                                        datosTest.nombreTest = arrayResult[0];
                                        datosTest.numMutants = Number(arrayResult[1]);
                                        datosTest.killed = Number(arrayResult[2]);
                                        datosTest.percent = Number(arrayResult[3]);
                                        datosTest.time = Number(arrayResult[4]);

                                        daoProyectos.insertTestProyecto(datosTest, function (err, resultInsertTest) {
                                          if (err) {
                                            next(err);
                                          } else {

                                            if (!resultInsertTest.exito) {
                                              res.json({exito: false, msg: resultInsertProyecto.msg});
                                            } else {

                                              var comando =  "cat " + FILE_MUTANTES ;
                                              // Recorremos los mutantes de la clase
                                              ejecutarComandoLinux( comando, function(err, result_cclass) {
                                                if (err) {
                                                  res.json({exito: false, msg: result_cclass});
                                                } else {
                                                  var arrayMutantesClase = result_cclass.trim().split("\n");
                                                  var contMutante = arrayMutantesClase.length;

                                                  arrayMutantesClase.forEach(function(mutante){
                                                    var arrayMutante = mutante.split(",");
                                                    var datos = {}
                                                    datos.idProyecto = resultInsertProyecto.insertId;
                                                    datos.idTest = resultInsertTest.insertId;
                                                    datos.clase = arrayMutante[0];
                                                    datos.mutante =  arrayMutante[1];
                                                    datos.killed =  arrayMutante[2];

                                                    daoProyectos.insertClasseTestProyecto(datos, function (err, result) {
                                                      if (err) {
                                                        next(err);
                                                      } else {
                                                        contMutante --;

                                                        if (contMutante == 0) {
                                                          cont--;
                                                          allresult.push({value: testFilePom, result: result});
                                                          next();
                                                        }

                                                        // Si ha terminado de ejecutar
                                                        if (cont == 0 && contMutante == 0) {
                                                          res.json({exito: true, msg:result});
                                                        }
                                                      }
                                                    });
                                                  });
                                                }
                                              });
                                            }
                                          }
                                        });
                                      }
                                    });
                                  }
                                });

                              });

                          },
                          function(allresult) {
                              console.log('COMPLETED');
                              console.log(allresult);
                          },
                          true
                      );

                      }
                    });
                  }
                }
              });
            }
          });
        }
      });
    }
});

/*
  listaMutantes: ejemplo.  "0 1 2 3 4"
*/
function preprocesar(listaMutantes, callback) {
  child = exec("sh preprocesar.sh '" + listaMutantes+"'",
  // Pasamos los parámetros error, stdout la salida
  // que mostrara el comando
    function (error, stdout, stderr) {
      // controlamos el error
      if (error !== null) {
          console.log('exec error: ' + error);
          callback(true);
      } else {
          callback(false);
      }
  });
};

function ejecutarComandoLinux(comando, callback) {
  child = exec(comando,
    function (error, stdout, stderr) {
      // controlamos el error
      if (error !== null) {
          console.log('exec error: ' + error);
          callback(true,stderr);
      } else {
          callback(false, stdout);
      }
  });
};

// Procesar resultado.txt
function saveResultOnDataBase(idProyecto, callback){

  var listaResultTest = fs.readFileSync('./generadorMutantesJAVA/resultados.txt').toString().trim().split(/\r?\n/);
  var cont = listaResultTest.length;

  listaResultTest.forEach(function(line){
    var array = line.trim().split(" ");
    //console.log(array);
    var datos = {}
    datos.idProyecto = idProyecto;
    datos.nombreTest = array[0];
    datos.numMutants = Number(array[1]);
    datos.killed = Number(array[2]);
    datos.percent = Number(array[3]);
    datos.time = Number(array[4]);

    daoProyectos.insertTestProyecto(datos, function (err, result) {
      if (err) {
        callback(true);
      } else {
        cont--;
        if (cont == 0) {
          callback(false);
        }
      }
    });
  });

};
module.exports = router;
