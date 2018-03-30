'use strict';

var express = require('express');
var path = require('path');
var logger = require('morgan');
var bodyParser = require('body-parser');
var favicon = require('serve-favicon');
var fs = require('fs');
var https = require('https');
var passport = require("passport");
var passportHTTP = require("passport-http");
var db = require('./helpers/db');
var config = require('./config');
var cors = require('cors');

const request = require('request');

var app = express();
app.use(express.static(path.join(__dirname, "public")));
app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

var principal = require('./routes/principal');
var proyectos = require('./routes/proyectos');

app.use(cors());
app.options('*', cors());

app.use('/', principal);
app.use('/proyectos', proyectos);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  res.status(404).json({ error: true, errorMsg: "Not Found" });
});

// error handler
app.use(function(err, req, res, next) {
  console.log(err);
  res.status(500).json({ error: true, errorMsg: "Error" });
});


app.listen(process.env.PORT || config.port, function(err) {
  if(!err) {
    console.log('App is running on port ' + config.port);

    //setInterval(all55Call(), 3000000);
  }
});
