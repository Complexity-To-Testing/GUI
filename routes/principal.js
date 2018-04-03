
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

router.post("/procesar_file_Classes",upload.single("Classes"), function(req, res) {
    var urlFichero;
    if (req.file) {
        urlFichero = path.join("proyectos", "Classes.zip");
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
        urlFichero = path.join("proyectos", "Tests.zip");
        var fichDestino = path.join("public", urlFichero);
        fs.createReadStream(req.file.path).pipe(fs.createWriteStream(fichDestino));
        res.json({exito: true , msg: "Fichero enviado con éxito."});
    }else {
      res.json({exito: false, msg: "No se ha podido enviar el fichero."});
    }
});

router.get("/ejecutar/:nombreProyecto", function(req, res) {
  var nombreProyecto = req.params.nombreProyecto;

  preprocesar(function (err) {
    if (err) {
      res.json({exito: false, msg:"Error al preprocesar los ficheros."});
    } else {
      child = exec("cat ejecutarTests.sh",
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
                console.log(datos);
                // si no se ha podido insertar
                if (datos.msg) {
                  res.json({exito: false, msg:datos.msg});
                }else {
                  // Guardamos los resultados en la  BD
                  saveResultOnDataBase(datos.insertId, function(err) {
                    if (err) {
                      res.json({exito: false, msg:"Error al guardar los resultados en la BD."});
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

function preprocesar(callback) {
  child = exec("sh preprocesar.sh",
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

// Procesar resultado.txt
function saveResultOnDataBase(idProyecto, callback){

  var listaResultTest = fs.readFileSync('./proyectoJAVA/resultados.txt').toString().trim().split(/\r?\n/);
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
