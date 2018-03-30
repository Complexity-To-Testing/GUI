"use strict";

var express = require('express');
var router = express.Router();
var daoProyectos = require('../integration/daoProyectos');

// GET /proyectos/
router.get("/", function(req, res) {
  // Obtiene los campeonatos
  daoProyectos.getProyectos(function(err, proyectos) {

    // Muestra error si hay un error en la BD
    if (err) {
      next(err);
    } else {

      // Si no hay proyectos
      if (proyectos == null) {
        res.json([]);
      }else {
        res.json(proyectos);
      }
    }
  });
});

// GET /proyectos/getEstadisticas/:idProyecto
router.get("/getEstadisticas/:idProyecto", function(req, res) {
  var idProyecto =  Number(req.params.idProyecto);

  if (!isNaN(idProyecto)) {
    // Obtiene las getEstadisticas
    daoProyectos.getEstadisticastPorIdProyecto(idProyecto, function(err, estadisticas) {

      // Muestra error si hay un error en la BD
      if (err) {
        next(err);
      } else {

        // Si no hay estadisticas
        if (estadisticas == null) {
          res.json([]);
        }else {
          res.json(estadisticas);
        }
      }
    });
  } else {
      res.json( {error: true, msg: "ERROR: hay un parametro incorrecto, asegurese de que sea un numero entero"});
  }
});

module.exports = router;
