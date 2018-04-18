"use strict";
var db = require('../db');
var pool  = db.getPool();

function insertProyecto(nombreProyecto, callback) {
  /* u: datos de un usuario que se va a guardar */

  pool.getConnection(function(err, connection) {

    var sql = "INSERT INTO `proyectos`( `name`) VALUES (?)";

    // Ejecutamos la consulta SQL
    connection.query(sql, [nombreProyecto], function(err, result) {
      connection.release();
      if (err) {
        callback(null, null);
      } else {
        // Si la consulta dio como resultado cero filas, devolvemos null.
        // En caso contrario, devolvemos el primer elemento del resultado.
        if (result.length === 0) {
          callback(null, {exito: false, "msg": "Error al insertar el proyecto."});
        } else {
          callback(null, {exito: true, "insertId": result.insertId } );
        }
      }
    });
  });
}
//SELECT SUM(idProyecto) as numTest, SUM(time) as totalTime, numMutants,  AVG(killed) as avg_killed, AVG(percent) as avg_percent FROM `test_proyecto` WHERE  idProyecto = 1

function getProyectos( callback) {
  pool.getConnection(function(err, connection) {

    var sql = "SELECT test_proyecto.idProyecto, proyectos.name, COUNT(test_proyecto.idProyecto) as numTest, ROUND(SUM(test_proyecto.time),2) as totalTime, test_proyecto.numMutants, ROUND(AVG(test_proyecto.killed),2) as avg_killed, ROUND(AVG(test_proyecto.percent),2) as avg_percent FROM `test_proyecto` join proyectos on (proyectos.id = test_proyecto.idProyecto) GROUP by idProyecto "

    // Ejecutamos la consulta SQL
    connection.query(sql, function(err, result) {
      connection.release();
      if (err) {
        callback(err);
      } else {
        // Si la consulta dio como resultado cero filas, devolvemos null.
        // En caso contrario, devolvemos el primer elemento del resultado.
        if (result.length === 0) {
          callback(null, null);
        } else {
          callback(null, result);
        }
      }
    });
  });
}

function insertTestProyecto(datos, callback) {
  /* u: datos de un usuario que se va a guardar */

  pool.getConnection(function(err, connection) {

    var sql = "INSERT INTO `test_proyecto`(`idProyecto`, `nombreTest`, `killed`, `numMutants`, `time`, `percent`) VALUES (?,?,?,?,?,?)";

    // Ejecutamos la consulta SQL
    connection.query(sql, [datos.idProyecto, datos.nombreTest, datos.killed, datos.numMutants, datos.time,datos.percent], function(err, result) {
      connection.release();
      if (err) {
        callback(err);
      } else {
        // Si la consulta dio como resultado cero filas, devolvemos null.
        // En caso contrario, devolvemos el primer elemento del resultado.
        if (result.length === 0) {
          callback(null, {exito:false, "msg": "Error al insertar un test del proyecto"});
        } else {
          callback(null, {exito: true, "insertId": result.insertId } );
        }
      }
    });
  });
}
function insertClasseTestProyecto(datos, callback) {
  /* u: datos de un usuario que se va a guardar */

  pool.getConnection(function(err, connection) {

    var sql = "INSERT INTO `proyecto_clase_test`( `idProyecto`, `idTest`, `clase`, `mutante`, `killed`) VALUES (?,?,?,?,?)";

    // Ejecutamos la consulta SQL
    connection.query(sql, [datos.idProyecto, datos.idTest, datos.clase, datos.mutante, datos.killed], function(err, result) {
      connection.release();
      if (err) {
        callback(err);
      } else {
        // Si la consulta dio como resultado cero filas, devolvemos null.
        // En caso contrario, devolvemos el primer elemento del resultado.
        if (result.length === 0) {
          callback(null, {exito:false, "msg": "Error al insertar una clase del test de un proyecto."});
        } else {
          callback(null, {exito: true, "insertId": result.insertId } );
        }
      }
    });
  });
}

function getEstadisticastPorIdProyecto(idProyecto, callback) {
  pool.getConnection(function(err, connection) {

    var sql = "SELECT  `idProyecto`, `nombreTest`, `killed`, `numMutants`, `time`, `percent` FROM `test_proyecto` WHERE idProyecto = ? ORDER BY killed ASC"

    // Ejecutamos la consulta SQL
    connection.query(sql, [idProyecto],function(err, result) {
      connection.release();
      if (err) {
        callback(err);
      } else {
        // Si la consulta dio como resultado cero filas, devolvemos null.
        // En caso contrario, devolvemos el primer elemento del resultado.
        if (result.length === 0) {
          callback(null, null);
        } else {
          callback(null, result);
        }
      }
    });
  });
}

module.exports = {
  insertProyecto: insertProyecto,
  getProyectos: getProyectos,
  insertTestProyecto: insertTestProyecto,
  getEstadisticastPorIdProyecto: getEstadisticastPorIdProyecto,
  insertClasseTestProyecto: insertClasseTestProyecto
};
