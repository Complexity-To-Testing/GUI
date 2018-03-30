"use strict";
var db = require('../db');
var pool  = db.getPool();

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
          callback(null, {"msg": "Error"});
        } else {
          callback(null, {"insertId": result.insertId } );
        }
      }
    });
  });
}

module.exports = {
  insertTestProyecto: insertTestProyecto
};
