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

    var sql = "INSERT INTO `mutante_test_proyecto`( `idProyecto`, `idTest`, `clase`, `mutante`, `killed`) VALUES (?,?,?,?,?)";

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

function getSumMutantesPorIdProyectoKilled(idProyecto, callback) {
  pool.getConnection(function(err, connection) {

    var sql = "SELECT count(killed) as killed, mutante FROM `mutante_test_proyecto` WHERE idProyecto = ? and killed = 'KILLED' GROUP by mutante "

    // Ejecutamos la consulta SQL
    connection.query(sql,[idProyecto], function(err, result) {
      connection.release();
      if (err) {
        callback(err);
      } else {
        if (result.length === 0) {
          callback(null, null);
        } else {
          callback(null, result);
        }
      }
    });
  });
}

function getTestsPorIdProyecto(idProyecto, callback) {
  pool.getConnection(function(err, connection) {

    var sql = "SELECT * FROM `test_proyecto` WHERE idProyecto = ? "

    // Ejecutamos la consulta SQL
    connection.query(sql,[idProyecto], function(err, result) {
      connection.release();
      if (err) {
        callback(err);
      } else {
        if (result.length === 0) {
          callback(null, null);
        } else {
          callback(null, result);
        }
      }
    });
  });
}

function getSumMutantesKilledPorIdTest(idTest, callback) {
  pool.getConnection(function(err, connection) {

    var sql = "SELECT count(killed) as killed, mutante FROM `mutante_test_proyecto` WHERE idTest = ? and killed = 'KILLED' GROUP by mutante"

    // Ejecutamos la consulta SQL
    connection.query(sql,[idTest], function(err, result) {
      connection.release();
      if (err) {
        callback(err);
      } else {
        if (result.length === 0) {
          callback(null, null);
        } else {
          callback(null, result);
        }
      }
    });
  });
}

function getResultadoProyectosPorPrueba(nombrePrueba, callback) {
  pool.getConnection(function(err, connection) {

    var sql = "SELECT * FROM `test_proyecto` JOIN proyectos ON (proyectos.id = test_proyecto.idProyecto ) WHERE proyectos.name  LIKE  ?  "

    // Ejecutamos la consulta SQL
    connection.query(sql,['%'+nombrePrueba +'%'], function(err, result) {
      connection.release();
      if (err) {
        callback(err);
      } else {
        console.log(nombrePrueba);
        console.log(result);
        if (result.length === 0) {
          callback(null, null);
        } else {
          console.log(nombrePrueba);
          console.log(result);
          callback(null, result);
        }
      }
    });
  });
}
// SELECT count(killed), mutante as killed FROM `mutante_test_proyecto` WHERE idProyecto = 1 GROUP by mutante
module.exports = {
  insertProyecto: insertProyecto,
  getProyectos: getProyectos,
  insertTestProyecto: insertTestProyecto,
  getEstadisticastPorIdProyecto: getEstadisticastPorIdProyecto,
  insertClasseTestProyecto: insertClasseTestProyecto,
  getSumMutantesPorIdProyectoKilled: getSumMutantesPorIdProyectoKilled,
  getTestsPorIdProyecto: getTestsPorIdProyecto,
  getSumMutantesKilledPorIdTest: getSumMutantesKilledPorIdTest,
  getResultadoProyectosPorPrueba: getResultadoProyectosPorPrueba
};
