'use strict'
var daoProyectos = require('./integration/daoProyectos');
var exec = require('child_process').exec, child;
var lineReader = require('line-reader');
var cors = require('cors');
var express = require('express'),
	app = express(),
	http = require('http').createServer(app),
	io = require('socket.io')(http),
	port = process.env.PORT || 5555,
	publicDir = express.static(`${__dirname}/public`)

	var principal = require('./controllers/principal');
	var proyectos = require('./controllers/proyectos');

	app.use(cors());
	app.options('*', cors());

	app.use('/', principal);
	app.use('/proyectos', proyectos);

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

app
	.use(publicDir)
	.get('/', (req, res) => {
		res.sendFile(`${publicDir}/index.html`)
	})

http.listen(port, () => {
	console.log('Iniciando Express y Socket.IO en localhost:%d', port)
})

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

io.on('connection', (socket) => {

	function ejecutarPrograma(datosProyecto, conjuntoPruebas) {
		preprocesar(datosProyecto.listaMutantes, function (err) {
				if (err) {
					io.emit('mostrar error', "Error al preprocesar los ficheros.");
				} else {
					io.emit('mostrar proceso', "Guardando el proyecto en la  BD...");
					daoProyectos.insertProyecto(datosProyecto.nombreProyecto, function(err, resultInsertProyecto) {
						// Muestra error si hay un error en la BD
						if (err) {
							io.emit('mostrar error', "Error al insertar el proyecto en la BD.");
						} else {

							// si no se ha podido insertar
							if (!resultInsertProyecto.exito) {
								io.emit('mostrar error', "Error al insertar el proyecto.");
							}else {

								// Leemos los ficheros de configuracion
								ejecutarComandoLinux( "ls " + DIR_TESTSPOMS, function(err, result_ls) {
									if (err) {
										io.emit('mostrar error', "Error al leer con ls la carpeta testsPoms.");
									} else {
										var arrayTestFilePom = result_ls.trim().split("\n");
										var cont = arrayTestFilePom.length;

										// Para cada fichero de configuracion lo copiamos el fichero de configuracion en el proyecto java y lo ejecutamos
										forEachAll(arrayTestFilePom,
											function(testFilePom, allresult, nextTest) {
													asyncSqrt(testFilePom, function(testFilePom, result) {

															io.emit('mostrar proceso', "Ejecutando el test "+testFilePom+"...");
															var comando = "sh ejecutarTest.sh " + testFilePom;
															ejecutarComandoLinux( comando, function(err, result_et) {
															if (err) {
																	io.emit('mostrar error', "Error al ejecutar " + comando);
															} else {

																var comando =  "cat " + FILE_RESULTADO;
																ejecutarComandoLinux( comando, function(err, result_cr) {
																	if (err) {
																		io.emit('mostrar error', "Error al ejecutar " + comando);
																	} else {
																		var arrayResult = result_cr.trim().split(" ");
																		var datosTest = {}

																		datosTest.idProyecto = resultInsertProyecto.insertId;
																		datosTest.nombreTest = arrayResult[0];
																		datosTest.numMutants = Number(arrayResult[1]);
																		datosTest.killed = Number(arrayResult[2]);
																		datosTest.percent = Number(arrayResult[3]);
																		datosTest.time = Number(arrayResult[4]);

																		console.log(arrayResult.length);
																		if (arrayResult.length < 4) {
																				io.emit('mostrar error', "Error no se han generado mutantes para el test "+testFilePom+"con el programa PIT ");
																				//
																				var comando = "pwd; cat logMutantes.txt | grep java"
																				ejecutarComandoLinux( comando, function(err, resulComando) {
																					 if (err) {
																							 io.emit('mostrar error', "Error al ejecutar " + comando);
																					 } else {
																						 io.emit('mostrar contenido error', resulComando);

																					 }
																						nextTest();
																				});


																		} else {
																			daoProyectos.insertTestProyecto(datosTest, function (err, resultInsertTest) {
																				if (err) {
																					io.emit('mostrar error', "Error al insertar el Test en la BD");
																				} else {

																					if (!resultInsertTest.exito) {
																							io.emit('mostrar error', "Error al insertar el Test en la BD");
																					} else {
																							io.emit('test guardado', datosTest.idProyecto, conjuntoPruebas);
																					}
																					nextTest();
																				}
																			});
																		}
																	}
																});
															}
														});
													});
											},
											function(allresult) {
												if (conjuntoPruebas === null) {
													io.emit('mostrar finalizado', "proyecto " + datosProyecto.nombreProyecto);
													console.log('COMPLETED');
													console.log(allresult);
												} else {
													console.log("<< siguiente prueba");
													io.emit('ejecutar-siguiente-prueba', conjuntoPruebas);
												}
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

	socket.on('listado proyectos', function () {
		daoProyectos.getProyectos(function(err, proyectos) {
			// Muestra error si hay un error en la BD
			if (err) {
				proyectos = [];
			} else {
				// Si no hay proyectos
				if (proyectos == null) {
					proyectos = [];
				}
			}
			io.emit('mostrar proyectos', proyectos)
		});
	})

	socket.on('obtenerEstadisticasPorIdProyecto', function (idProyecto) {
		if (!isNaN(idProyecto)) {
	    // Obtiene las getEstadisticas
	    daoProyectos.getEstadisticastPorIdProyecto(idProyecto, function(err, estadisticas) {
	      // Muestra error si hay un error en la BD
	      if (err) {
	       	estadisticas = [];
	      } else {
	        // Si no hay estadisticas
	        if (estadisticas == null) {
	          estadisticas = [];
	        }
	      }
				io.emit('mostrar estadisticas', estadisticas);
	    });
	  } else {
	     io.emit('mostrar estadisticas', []);
	  }
	})

	socket.on('generarPrograma', function (datosPrograma) {

		var nombreProyecto = datosPrograma.nombreProyecto;
		var listaMutantes = datosPrograma.listaMutantes;
		var parametros = "" + datosPrograma.numeroAnidacionesIf + " "
													+  datosPrograma.numeroAnidacionesWhile + " "
													+  datosPrograma.numeroIteracionesWhile + " "
													+  datosPrograma.numeroAnidacionesFor + " "
													+  datosPrograma.numeroIteracionesFor + " "
													+  datosPrograma.numeroCondicionesLogicas + " "
													+  datosPrograma.numeroExpresionesLogicas + " "
													+  datosPrograma.numeroExpresionesAritmeticas + " "
													+  datosPrograma.listaInputsComprobacion + " "
													+  datosPrograma.numeroExpresionesSeguidas + " "
													+  datosPrograma.numeroFuncion + " "
													+  datosPrograma.decicionInputs + " "
													+  datosPrograma.size_tests + " "
													+  datosPrograma.ifsAniCuerpoBucle + " "
													+  datosPrograma.aleatorio + " "
													+  datosPrograma.ini + " "
													+  datosPrograma.fin + " ";

		if (nombreProyecto === "") {
	     io.emit('mostrar error', "Nombre del proyecto vacio");
	  }else {
			ejecutarComandoLinux( "sh generadorPrograma.sh " + parametros, function(err, resultGen) {
        if (err) {
					io.emit('mostrar error', "Error al ejecutar script generadorPrograma.sh");
        } else {
					ejecutarPrograma(datosPrograma, null) ;
        }
      });
		}
	})

	socket.on('ejecutarProyecto', function (datosProyecto) {

		var nombreProyecto = datosProyecto.nombreProyecto;
		var listaMutantes = datosProyecto.listaMutantes;

		if (nombreProyecto === "") {
	     io.emit('mostrar error', "Nombre del proyecto vacio");
	  }else {
				io.emit('mostrar proceso', "Iniciando preprocesado...");
        ejecutarPrograma(datosProyecto, null) ;
		}
	})
	socket.on('ejecutar-conjunto-pruebas', function (conjuntoPruebas) {
		console.log("<-- Comienzo de la ejecucion");
		console.log(conjuntoPruebas.datosPrograma.nombreProyecto);
		var datosPrograma = conjuntoPruebas.datosPrograma;
		var parametros = "" + datosPrograma.numeroAnidacionesIf + " "
													+  datosPrograma.numeroAnidacionesWhile + " "
													+  datosPrograma.numeroIteracionesWhile + " "
													+  datosPrograma.numeroAnidacionesFor + " "
													+  datosPrograma.numeroIteracionesFor + " "
													+  datosPrograma.numeroCondicionesLogicas + " "
													+  datosPrograma.numeroExpresionesLogicas + " "
													+  datosPrograma.numeroExpresionesAritmeticas + " "
													+  datosPrograma.listaInputsComprobacion + " "
													+  datosPrograma.numeroExpresionesSeguidas + " "
													+  datosPrograma.numeroFuncion + " "
													+  datosPrograma.decicionInputs + " "
													+  datosPrograma.size_tests + " "
													+  datosPrograma.ifsAniCuerpoBucle + " "
													+  datosPrograma.aleatorio + " "
													+  datosPrograma.ini + " "
													+  datosPrograma.fin + " ";
		if (datosPrograma.nombreProyecto === "") {
			 io.emit('mostrar error', "Nombre del proyecto vacio");
		}else {
			ejecutarComandoLinux( "sh generadorPrograma.sh " + parametros, function(err, resultGen) {
				if (err) {
					io.emit('mostrar error', "Error al ejecutar script generadorPrograma.sh");
				} else {
					ejecutarPrograma(datosPrograma, conjuntoPruebas) ;
				}
			});
		}
	});

	socket.on('disconnect', () => {
		console.log('Ha salido un usuario del Chat')
		socket.broadcast.emit('bye bye', {message : 'Ha salido un usuario del Chat'})
	})
})
