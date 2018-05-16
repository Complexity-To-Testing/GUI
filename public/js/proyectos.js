var idProyectoSeleccionado;
var idTestSeleccionado;
var jsonEstaditicas;
var jsonEstaditicasPrueba;
var jsonMutantes;
var currentNombreProyecto;
var currentNombreTest;
/*
  ACTUALIZAR VISTA
*/

function rellenarProyectos(json) {
  // Limpiamos la tabla de los posibles resultados anteriores.
  $('#tbl-proyecto > tbody').empty();

  // Rellenamos la tabla con la informacion de los proyectos.
  json.forEach(function(proyecto) {
    var nombreProyecto = "'" + proyecto.name+ "'";
    $('#tbl-proyecto > tbody:last-child').append(
      '<tr data-toggle="modal" data-target="#myModal" onClick="">' +
        '<td>' + proyecto.idProyecto +'</td>' +
        '<td>' + proyecto.name +'</td>' +
        '<td>' + proyecto.numTest +'</td>' +
        '<td>' + proyecto.totalTime +'</td>' +
        '<td>' + proyecto.numMutants +'</td>' +
        '<td>' + proyecto.avg_killed +'</td>' +
        '<td>' + proyecto.avg_percent +'</td>' +
        '<td align="right"> <form name="verTestsProyecto" action="javascript:verTestsProyecto(' + proyecto.idProyecto + ', ' + nombreProyecto + ');" > <input id="verTestsProyecto"  class="btn btn-primary btn-success" type="submit" value="Tests" /> </form> </td>' +
        '<td align="right"> <form name="verMutantesKilledProyecto" action="javascript:verMutantesKilledProyecto(' + proyecto.idProyecto + ', ' + nombreProyecto + ');" > <input id="verMutantesKilledProyecto"  class="btn btn-primary btn-success" type="submit" value="Killed mutants" /> </form> </td>' +
        '<td align="right"> <form name="verEstadisticas" action="javascript:verEstadisticas(' + proyecto.idProyecto + ', ' + nombreProyecto + ');" > <input id="verEstadisticas"  class="btn btn-primary btn-success" type="submit" value="Estadísticas" /> </form> </td>' +
      '</tr>'
    );
  });
}

function rellenarTests(json) {
  // Limpiamos la tabla de los posibles resultados anteriores.
  $('#tbl-tests > tbody').empty();

  // Rellenamos la tabla con la informacion de los proyectos.
  json.forEach(function(test) {
    var nombreTest = "'" + test.nombreTest+ "'";
    $('#tbl-tests > tbody:last-child').append(
      '<tr data-toggle="modal" data-target="#myModal" onClick="">' +
        '<td>' + test.id +'</td>' +
        '<td>' + test.nombreTest +'</td>' +
        '<td>' + test.killed +'</td>' +
        '<td>' + test.time +'</td>' +
        '<td>' + test.percent +'</td>' +
        '<td align="right"> <form name="verMutantesKilledTest" action="javascript:verMutantesKilledTest(' + test.id + ', ' + nombreTest + ');" > <input id="verMutantesKilledTest"  class="btn btn-primary btn-success" type="submit" value="Killed mutants" /> </form> </td>' +
      '</tr>'
    );
  });
}

function verTestsProyecto(idProyecto, nombreProyecto) {
  //listaEstadisticas = [];
  idProyectoSeleccionado = idProyecto;
  currentNombreProyecto = nombreProyecto;

  $('.container > div').addClass('hidden');
  $('#listado-tests').removeClass('hidden');
  $.when(getTestProyecto(idProyectoSeleccionado)).done(function(tests) {
    rellenarTests(tests);
  });
}

function verMutantesKilledProyecto(idProyecto, nombreProyecto) {
  //listaEstadisticas = [];
  idProyectoSeleccionado = idProyecto;
  currentNombreProyecto = nombreProyecto;
  $.when(obtenerSumMutantesKilledPorIdProyecto(idProyectoSeleccionado)).done(function(mutantes) {

    jsonMutantes = mutantes;
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChartMutante);

    $('.container > div').addClass('hidden');

  });
}

function verMutantesKilledTest(idTest, nombreTest) {
  //listaEstadisticas = [];
  idTestSeleccionado = idTest;
  currentNombreTest = nombreTest;
  $.when(obtenerSumMutantesKilledPorIdTest(idTestSeleccionado)).done(function(mutantes) {

    jsonMutantes = mutantes;
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChartTest);

    $('.container > div').addClass('hidden');
    $('#chart').removeClass('hidden');
  });
}

function verEstadisticas(idProyecto, nombreProyecto) {
  //listaEstadisticas = [];
  idProyectoSeleccionado = idProyecto;
  currentNombreProyecto = nombreProyecto;
    // $.when(obtenerEstadisticasPorIdProyecto(idProyectoSeleccionado)).done(function(estadisticas) {
    (function (d, io, $){
    	'use strict'
      var io = io()
      io.emit('obtenerEstadisticasPorIdProyecto', idProyecto);

    })(document, io, jQuery);
//  });
}
function mostrarEstadisticas(estadisticas) {
    jsonEstaditicas = estadisticas;
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    $('.container > div').addClass('hidden');
    $('#chart').removeClass('hidden');
    $('#chartMutant').removeClass('hidden');
    $('#chartDR').removeClass('hidden');
    $('#chartDR2').removeClass('hidden');
//  });
}

function verEstadisticasPorPrueba(nombrePrueba) {
  //listaEstadisticas = [];
  $.when(obtenerEstadisticasPorPrueba(nombrePrueba)).done(function(estadisticas) {
    jsonEstaditicasPrueba = estadisticas;
    google.charts.load('current', {'packages':['corechart','bar']});
    google.charts.setOnLoadCallback(drawChartPrueba);

    $('.container > div').addClass('hidden');
    $('#chart').removeClass('hidden');
    $('#chartMutant').removeClass('hidden');
    $('#chartDR').removeClass('hidden');
    $('#chartDR2').removeClass('hidden');
  });
}

function drawChartOLD() {
  // Create our data table out of JSON data loaded from server.
  var data = new google.visualization.DataTable();
  data.addColumn('string', 'Nombre test');
  data.addColumn('number', 'killed');
  data.addColumn('number', 'Time');
  data.addColumn('number', 'Distingising rate');
  //data.addColumn('string', 'nombre clase test');

  $.each(jsonEstaditicas, function(i,jsonData)
  {
    var value=jsonData.killed;
    var time=jsonData.time;
    var percent=jsonData.percent;
    var name=jsonData.nombreTest;

    //var nameTest=jsonData.nombreTest;
    data.addRows([ [name, value, time, percent]]);
  });

  var options = {
    title: 'Estadisticas del proyecto ' + currentNombreProyecto,
    //function: 'linear',
    pointSize: 16
  };

  var chart = new google.visualization.LineChart(document.getElementById('chart'));
  google.visualization.events.addListener(chart, 'ready', function() {  });

  chart.draw(data, options);
  /*
  chart=new google.visualization.ColumnChart(document.getElementById('chart'));
  chart=new google.visualization.PieChart(document.getElementById('chart'));
  chart=new google.visualization.BarChart(document.getElementById('chart'));
  chart=new google.visualization.GeoChart(document.getElementById('chart'));
  */
}

function drawChart() {
  // Create our data table out of JSON data loaded from server.
  var data = new google.visualization.DataTable();
  data.addColumn('string', 'mutante');
  data.addColumn('number', 'killed');
  var dataMutant = new google.visualization.DataTable();
  dataMutant.addColumn('string', 'mutante');
  dataMutant.addColumn('number', 'mutant');
  var dataDR = new google.visualization.DataTable();
  dataDR.addColumn('string', 'mutante');
  dataDR.addColumn('number', 'DR');
  var dataDR2 = new google.visualization.DataTable();
  dataDR2.addColumn('number', 'DR_Invert');
  dataDR2.addColumn('number', 'Tests');

  $.each(jsonEstaditicas, function(i,jsonData)
  {
    var time=jsonData.time;
    var mutante=jsonData.numMutants;
    var killed=jsonData.killed;
    var name=jsonData.nombreTest;
    var dr=killed/mutante;
    var dr2=(1/(1-dr));
    //var nameTest=jsonData.nombreTest;
    //data.addRows([ [name, value, mutante, time]]);
    // data.addRows([ [name, value,mutante]]);
    data.addRows([ [name,killed]]);
    dataMutant.addRows([ [name,mutante]]);
    dataDR.addRows([ [name,dr]]);
    dataDR2.addRows([ [dr2,i+1]]);
  });

  //dataDR.sort([{column: 1}]);
  dataDR2.sort([{column: 0}]);
  var options = {
    title: 'Estadisticas killed ',
    pointSize: 16,
    is3D: true
  };
  var optionsMutant = {
    title: 'Estadisticas Num Mutants ' ,
    pointSize: 16,
    is3D: true
  };
  var optionsDR = {
    title: 'Estadisticas Distingising Rate ',
    pointSize: 16,
    is3D: true
  };
  var optionsDR2 = {
    hAxis: {
      title: 'Inversa del DR (1/(1-DR))'
    },
    vAxis: {
      title: 'Coste (Tiempo)'
    },
    colors: ['#AB0D06', '#007329']/*,
    trendlines: {
      0: {type: 'exponential', color: '#333', opacity: 1},
      1: {type: 'linear', color: '#111', opacity: .3}
    }*/
  };

  var chart = new google.visualization.LineChart(document.getElementById('chart'));
  var chartMutant = new google.visualization.LineChart(document.getElementById('chartMutant'));
  var chartDR = new google.visualization.LineChart(document.getElementById('chartDR'));
  var chartDR2 = new google.visualization.LineChart(document.getElementById('chartDR2'));

  google.visualization.events.addListener(chart, 'ready', function() {  });
  google.visualization.events.addListener(chartMutant, 'ready', function() {  });
  google.visualization.events.addListener(chartDR, 'ready', function() {  });
  google.visualization.events.addListener(chartDR2, 'ready', function() {  });

  chart.draw(data, options);
  chartMutant.draw(dataMutant, optionsMutant);
  chartDR.draw(dataDR, optionsDR);
  chartDR2.draw(dataDR2, optionsDR2);
  /*
  chart=new google.visualization.ColumnChart(document.getElementById('chart'));
  chart=new google.visualization.PieChart(document.getElementById('chart'));
  chart=new google.visualization.BarChart(document.getElementById('chart'));
  chart=new google.visualization.GeoChart(document.getElementById('chart'));
  */
}

function drawChartMutante() {
  // Create our data table out of JSON data loaded from server.
  var data = new google.visualization.DataTable();
  data.addColumn('string', 'mutante');
  data.addColumn('number', 'killed');
  //data.addColumn('string', 'nombre clase test');
  $.each(jsonMutantes, function(i,jsonData)
  {
    var value=jsonData.killed;
    var name=jsonData.mutante;

    //var nameTest=jsonData.nombreTest;
    data.addRows([ [name, value]]);
  });

  var options = {
    title: 'Mutantes killed del proyecto ' + currentNombreProyecto,
    //function: 'linear',
    pointSize: 16
  };

  var chart = new google.visualization.LineChart(document.getElementById('chart'));
  //var chart = new google.visualization.BarChart(document.getElementById('chart'));

  google.visualization.events.addListener(chart, 'ready', function() {  });

  chart.draw(data, options);
  /*
  chart=new google.visualization.ColumnChart(document.getElementById('chart'));
  chart=new google.visualization.PieChart(document.getElementById('chart'));
  chart=new google.visualization.BarChart(document.getElementById('chart'));
  chart=new google.visualization.GeoChart(document.getElementById('chart'));
  */
}

function drawChartTest() {
  // Create our data table out of JSON data loaded from server.
  var data = new google.visualization.DataTable();
  data.addColumn('string', 'mutante');
  data.addColumn('number', 'killed');
  //data.addColumn('string', 'nombre clase test');
  $.each(jsonMutantes, function(i,jsonData)
  {
    var value=jsonData.killed;
    var name=jsonData.mutante;

    //var nameTest=jsonData.nombreTest;
    data.addRows([ [name, value]]);
  });

  var options = {
    title: 'Mutantes killed del test ' + currentNombreTest,
    //function: 'linear',
    pointSize: 16
  };

  var chart = new google.visualization.LineChart(document.getElementById('chart'));
  //var chart=new google.visualization.BarChart(document.getElementById('chart'));
  google.visualization.events.addListener(chart, 'ready', function() {  });

  chart.draw(data, options);
  /*
  chart=new google.visualization.ColumnChart(document.getElementById('chart'));
  chart=new google.visualization.PieChart(document.getElementById('chart'));
  chart=new google.visualization.BarChart(document.getElementById('chart'));
  chart=new google.visualization.GeoChart(document.getElementById('chart'));
  */
}

function drawChartPrueba() {
  // Create our data table out of JSON data loaded from server.
  var data = new google.visualization.DataTable();
  data.addColumn('string', 'mutante');
  data.addColumn('number', 'killed');
  var dataMutant = new google.visualization.DataTable();
  dataMutant.addColumn('string', 'mutante');
  dataMutant.addColumn('number', 'mutant');
  var dataDR = new google.visualization.DataTable();
  dataDR.addColumn('string', 'mutante');
  dataDR.addColumn('number', 'DR');
  var dataDR2 = new google.visualization.DataTable();
  dataDR2.addColumn('string', 'mutante');
  dataDR2.addColumn('number', 'Time');

  $.each(jsonEstaditicasPrueba, function(i,jsonData)
  {
    var time=jsonData.time;
    var mutante=jsonData.numMutants;
    var killed=jsonData.killed;
    var name=jsonData.name;
    var dr=killed/mutante;
    var dr2=(1/(1-dr));
    //var nameTest=jsonData.nombreTest;
    //data.addRows([ [name, value, mutante, time]]);
    // data.addRows([ [name, value,mutante]]);
    data.addRows([ [name,killed]]);
    dataMutant.addRows([ [name,mutante]]);
    dataDR.addRows([ [name,dr]]);
    dataDR2.addRows([ [name,time]]);
  });

  //dataDR.sort([{column: 1}]);
  dataDR2.sort([{column: 0}]);
  var options = {
    title: 'Estadisticas killed ',
    pointSize: 16,
    is3D: true
  };
  var optionsMutant = {
    title: 'Estadisticas Num Mutants ' ,
    pointSize: 16,
    is3D: true
  };
  var optionsDR = {
    title: 'Estadisticas Distingising Rate ',
    pointSize: 16,
    is3D: true
  };
  var optionsDR2 = {
    hAxis: {
      title: 'Inversa del DR (1/(1-DR))'
    },
    vAxis: {
      title: 'Coste (Tiempo)'
    },
    colors: ['#AB0D06', '#007329']/*,
    trendlines: {
      0: {type: 'exponential', color: '#333', opacity: 1},
      1: {type: 'linear', color: '#111', opacity: .3}
    }*/
  };

  var chart = new google.charts.Bar(document.getElementById('chart'));
  var chartMutant = new google.charts.Bar(document.getElementById('chartMutant'));
  var chartDR = new google.charts.Bar(document.getElementById('chartDR'));
  var chartDR2 = new google.charts.Bar(document.getElementById('chartDR2'));

  google.visualization.events.addListener(chart, 'ready', function() {  });
  google.visualization.events.addListener(chartMutant, 'ready', function() {  });
  google.visualization.events.addListener(chartDR, 'ready', function() {  });
  google.visualization.events.addListener(chartDR2, 'ready', function() {  });

  chart.draw(data, options);
  chartMutant.draw(dataMutant, optionsMutant);
  chartDR.draw(dataDR, optionsDR);
  chartDR2.draw(dataDR2, optionsDR2);
  /*
  chart=new google.visualization.ColumnChart(document.getElementById('chart'));
  chart=new google.visualization.PieChart(document.getElementById('chart'));
  chart=new google.visualization.BarChart(document.getElementById('chart'));
  chart=new google.visualization.GeoChart(document.getElementById('chart'));
  */
}

/*
  OBTENER DATOS
*/


function generarPrograma(datosPrograma, nombreProyecto) {
  return   $.ajax({
      type: "POST",
      url: SERVER + 'generarPrograma/'+nombreProyecto,
      contentType: 'application/json',
      data: JSON.stringify(datosPrograma),
      error: function(xhr, status) { alert('Oooops, hubo un error...'); },
      success: function(data) {
        verEstadisticas(data.idProyecto, nombreProyecto);
      }
    });
}

function getProyectos() {
  return $.ajax({
    url: SERVER + 'proyectos/',
    type: "GET",
    dataType: 'json',
    error: function (xhr, status) { alert('Oooops, hubo un error...'); },
    complete: function(xhr, status) {}
  });
}

function getTestProyecto(idProyecto) {
  return $.ajax({
    url: SERVER + "proyectos/getTests/" + idProyecto,
    type: "GET",
    dataType: 'json',
    error: function (xhr, status) { alert('Oooops, hubo un error...'); },
    complete: function(xhr, status) {}
  });
}

function obtenerEstadisticasPorIdProyecto(idProyecto) {
  return $.ajax({
    url: SERVER + "proyectos/getEstadisticas/" + idProyecto,
    type: "GET",
    dataType: 'json',
    error: function (xhr, status) { alert('Oooops, hubo un error...'); },
    complete: function(xhr, status) {}
  });
}

function obtenerEstadisticasPorPrueba(nombrePrueba) {
  return $.ajax({
    url: SERVER + "proyectos/getResultadosPrueba/" + nombrePrueba,
    type: "GET",
    dataType: 'json',
    error: function (xhr, status) { alert('Oooops, hubo un error...'); },
    complete: function(xhr, status) {}
  });
}

function obtenerSumMutantesKilledPorIdProyecto(idProyecto) {
  return $.ajax({
    url: SERVER + "proyectos/getSumMutantesKilled/" + idProyecto,
    type: "GET",
    dataType: 'json',
    error: function (xhr, status) { alert('Oooops, hubo un error...'); },
    complete: function(xhr, status) {}
  });
}

function obtenerSumMutantesKilledPorIdTest(idTest) {
  return $.ajax({
    url: SERVER + "proyectos/getSumMutantesKilledPorTest/" + idTest,
    type: "GET",
    dataType: 'json',
    error: function (xhr, status) { alert('Oooops, hubo un error...'); },
    complete: function(xhr, status) {}
  });
}
