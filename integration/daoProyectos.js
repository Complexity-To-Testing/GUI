"use strict";
var db = require('../db');
var pool  = db.getPool();

function insertProyecto(nombreProyecto, callback) {
  /* u: datos de un usuario que se va a guardar */

  pool.getConnection(function(err, connection) {
    //var sqlExists = "SELECT * FROM `usuario` WHERE `dni`= ?";
    //connection.query(sqlExists, [u.dni], function(err, fila) {

      // Si no existe el id del usuario a eliminar
      //if (fila.length === 0) {
          var sql = "INSERT INTO `proyectos`( `name`) VALUES (?)";

          // Ejecutamos la consulta SQL
          connection.query(sql, [nombreProyecto], function(err, result) {
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
      /*}else{
        callback(null, {"msg": "yaExiste"});
      }*/
    //});
  });
}
//SELECT SUM(idProyecto) as numTest, SUM(time) as totalTime, numMutants,  AVG(killed) as avg_killed, AVG(percent) as avg_percent FROM `test_proyecto` WHERE  idProyecto = 1

function getProyectos( callback) {
  pool.getConnection(function(err, connection) {

    var sql = "SELECT test_proyecto.idProyecto, proyectos.name, COUNT(test_proyecto.idProyecto) as numTest, ROUND(SUM(test_proyecto.time),2) as totalTime, test_proyecto.numMutants, ROUND(AVG(test_proyecto.killed),2) as avg_killed, ROUND(AVG(test_proyecto.percent),2) as avg_percent FROM `test_proyecto` join proyectos on (proyectos.id = test_proyecto.idProyecto) GROUP by idProyecto"

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
module.exports = {
  insertProyecto: insertProyecto,
  getProyectos: getProyectos
};
