var mysql = require('mysql');
var config = require("./config");
var pool;

module.exports = {
    getPool: function () {
      if (pool) return pool;
      pool = mysql.createPool({
        connectionLimit : 100,
        host: config.dbHost,
        user: config.dbUser,
        password: config.dbPassword,
        database: config.dbName
      });
      return pool;
    }
};
