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
router.get("/getEstadisticas/:idProyecto", function(req, res, next) {
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

// GET /proyectos/getSumMutantesKilled/:idProyecto Devuelve la suma de los mutantes por tipos en un proyecto killed
router.get("/getSumMutantesKilled/:idProyecto", function(req, res, next) {
  var idProyecto =  Number(req.params.idProyecto);

  if (!isNaN(idProyecto)) {
    // Obtiene los campeonatos
    daoProyectos.getSumMutantesPorIdProyectoKilled(idProyecto, function(err, mutantes) {

      // Muestra error si hay un error en la BD
      if (err) {
        next(err);
      } else {

        // Si no hay proyectos
        if (mutantes == null) {
          res.json([]);
        }else {
          res.json(mutantes);
        }
      }
    });
  } else {
    res.json( {error: true, msg: "ERROR: hay un parametro incorrecto, asegurese de que sea un numero entero"});
  }
});

// GET /proyectos/getTests/:idProyecto Devuelve los tests de un proyecto
router.get("/getTests/:idProyecto", function(req, res, next) {
  var idProyecto =  Number(req.params.idProyecto);

  if (!isNaN(idProyecto)) {
    // Obtiene las getEstadisticas
    daoProyectos.getTestsPorIdProyecto(idProyecto, function(err, tests) {

      // Muestra error si hay un error en la BD
      if (err) {
        next(err);
      } else {

        // Si no hay tests
        if (tests == null) {
          res.json([]);
        }else {
          res.json(tests);
        }
      }
    });
  } else {
      res.json( {error: true, msg: "ERROR: hay un parametro incorrecto, asegurese de que sea un numero entero"});
  }
});

// GET /proyectos/getSumMutantesKilledPorTest/:idTest Devuelve la suma de los mutates killed por test
router.get("/getSumMutantesKilledPorTest/:idTest", function(req, res, next) {
  var idTest =  Number(req.params.idTest);

  if (!isNaN(idTest)) {
    // Obtiene las getEstadisticas
    daoProyectos.getSumMutantesKilledPorIdTest(idTest, function(err, tests) {

      // Muestra error si hay un error en la BD
      if (err) {
        next(err);
      } else {

        // Si no hay tests
        if (tests == null) {
          res.json([]);
        }else {
          res.json(tests);
        }
      }
    });
  } else {
      res.json( {error: true, msg: "ERROR: hay un parametro incorrecto, asegurese de que sea un numero entero"});
  }
});
module.exports = router;
