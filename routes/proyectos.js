"use strict";

var express = require('express');
var router = express.Router();
var daoProyectos = require('../integration/daoProyectos');

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

module.exports = router;
