var config = require('../config');
var mysql = require('mysql');

var pool = null;

exports.connect = function(cb) {
  pool = mysql.createPool({
    host: config.dbHost,
    user: config.dbUser,
    password: config.dbPassword,
    database: config.dbName
  });
  cb();
}

exports.executeQuery = function(query, params, cb) {
  pool.getConnection(function(err, connection) {
    if(err) {
      connection.release();
    }

    connection.query(query, params, function(err, rows) {
      connection.release();
      if(!err) {
        console.log("No error");
        cb(rows);
      }
      console.log("error");
    });

    connection.on('error', function(err) {
      return;
    });
  });
}

exports.get = function() {
  return pool;
}
