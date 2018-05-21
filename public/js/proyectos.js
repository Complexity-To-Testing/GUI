var idProyectoSeleccionado;
var idTestSeleccionado;
var jsonEstaditicas;
var jsonEstaditicas2
var jsonEstaditicasPrueba;
var jsonMutantes;
var currentNombreProyecto;
var currentNombreTest;
var currentDatosComparacion;
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

function cargarDatosProyectosComparacion(idProyecto, idProyecto2) {
  $.when(getTestProyecto(idProyecto)).done(function(tests) {
    $.when(getTestProyecto(idProyecto2)).done(function(tests2) {
      $.when(getProyectoPorId(idProyecto)).done(function(proyecto1) {
        $.when(getProyectoPorId(idProyecto2)).done(function(proyecto2) {
          currentDatosComparacion = {
            proyectoNames : [proyecto1.name,proyecto2.name],
            proyectoTests : [tests, tests2]
          }
          console.log(currentDatosComparacion);
          mostrarEstadisticasComparacion();
        });
      });
    });
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
    google.charts.load('current', {'packages':['corechart','line']});
    google.charts.setOnLoadCallback(drawChart);

    $('.container > div').addClass('hidden');
    $('#chart').removeClass('hidden');
    $('#chartMutant').removeClass('hidden');
    $('#chartDR').removeClass('hidden');
    $('#chartDR2').removeClass('hidden');
    //  });
}

function mostrarEstadisticasComparacion() {

    google.charts.load('current', {'packages':['corechart','line']});
    google.charts.setOnLoadCallback(drawChartComparacion);

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
    // data.addRows([ [name, value,mutante]])

    data.addRows([ [name,killed]]);
    dataMutant.addRows([ [name,mutante]]);
    dataDR.addRows([ [name,dr]]);
    dataDR2.addRows([ [dr2,i+1]]);
  });

  //dataDR.sort([{column: 1}]);
  dataDR2.sort([{column: 0}]);
  var options = {
    title: 'Estadisticas killed,killed+3 ',
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
      title: 'Coste (numero de Tests)'
    },
    colors: ['#AB0D06', '#007329'],
    pointSize: 15
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
  console.log("<--");
  // Create our data table out of JSON data loaded from server.
  var data = new google.visualization.DataTable();
  data.addColumn('string', 'mutante');
  data.addColumn('number', 'killed');
  data.addColumn({type: 'string', role: 'style'});
  var dataMutant = new google.visualization.DataTable();
  dataMutant.addColumn('string', 'mutante');
  dataMutant.addColumn('number', 'mutant');
  dataMutant.addColumn({type: 'string', role: 'style'});
  var dataDR = new google.visualization.DataTable();
  dataDR.addColumn('string', 'mutante');
  dataDR.addColumn('number', 'DR');
  dataDR.addColumn({type: 'string', role: 'style'});
  var dataDR2 = new google.visualization.DataTable();
  dataDR2.addColumn('string', 'mutante');
  dataDR2.addColumn('number', 'alfa');
  dataDR2.addColumn({type: 'string', role: 'style'});

  $.each(jsonEstaditicasPrueba, function(i,jsonData)
  {
    var name=jsonData.name;

    console.log(getColorColumnAtr(name));
    data.addRow([ name,0,getColorColumnAtr(name)]);
    dataMutant.addRow([name,0,getColorColumnAtr(name)]);
    dataDR.addRow([ name,0,getColorColumnAtr(name)]);
    dataDR2.addRow([ name,0,getColorColumnAtr(name)]);
  });


  //dataDR.sort([{column: 1}]);
  //dataDR2.sort([{column: 0}]);
  var options = {
    title: 'Estadisticas killed ',
    pointSize: 16,
    hAxis: {  direction:-1, slantedText:true, slantedTextAngle:90 },
    is3D: true
  };
  var optionsMutant = {
    title: 'Estadisticas Num Mutants ' ,
    pointSize: 16,
    hAxis: {  direction:-1, slantedText:true, slantedTextAngle:90 },
    is3D: true
  };
  var optionsDR = {
    title: 'Estadisticas Distingising Rate ',
    pointSize: 16,
    is3D: true
  };
  var optionsDR2 = {
      title: 'Estadisticas alfa = 1/(1-DR)',
      hAxis: {  direction:-1, slantedText:true, slantedTextAngle:90 }
    /*,
    colors: ['#AB0D06', '#007329'],
    trendlines: {
      0: {type: 'exponential', color: '#333', opacity: 1},
      1: {type: 'linear', color: '#111', opacity: .3}
    }*/
  };

  var chart = new google.visualization.ColumnChart(document.getElementById('chart'));
  var chartMutant = new google.visualization.ColumnChart(document.getElementById('chartMutant'));
  var chartDR = new google.visualization.ColumnChart(document.getElementById('chartDR'));
  var chartDR2 = new google.visualization.ColumnChart(document.getElementById('chartDR2'));
  chart.draw(data, options);
  chartMutant.draw(dataMutant, optionsMutant);
  chartDR.draw(dataDR, optionsDR);
  chartDR2.draw(dataDR2, optionsDR2);
  $.each(jsonEstaditicasPrueba, function(i,jsonData)
  {
    var time=jsonData.time;
    var mutante=jsonData.numMutants;
    var killed=jsonData.killed;
    var name=jsonData.name;
    var dr=killed/mutante;
    var dr2=(1/(1-dr));

    data.setValue(i,1,killed);
    dataMutant.setValue(i,1,mutante);
    dataDR.setValue(i,1,dr);
    dataDR2.setValue(i,1,dr2);
  });
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

function drawChartComparacion() {

  var data = new google.visualization.DataTable();
  data.addColumn('string', 'mutante');
  var dataMutant = new google.visualization.DataTable();
  dataMutant.addColumn('string', 'mutante');
  var dataDR = new google.visualization.DataTable();
  dataDR.addColumn('string', 'mutante');
  var dataDR2 = new google.visualization.DataTable();
  dataDR2.addColumn('number', 'Tests proyecto');

  // Create our data table out of JSON data loaded from server.
  for (var i = 0; i < currentDatosComparacion.proyectoNames.length; i++) {
    data.addColumn('number', currentDatosComparacion.proyectoNames[i]);
    dataMutant.addColumn('number', currentDatosComparacion.proyectoNames[i]);
    dataDR.addColumn('number', currentDatosComparacion.proyectoNames[i]);
    dataDR2.addColumn('number', currentDatosComparacion.proyectoNames[i]);
  }

  var ultiDr2 = 100;
  // Añadimos al principio
  $.each(currentDatosComparacion.proyectoTests[0], function(indiceTest,jsonData){
    var proyectosRow = {
      rowKilled:[],
      rowMutant:[],
      rowDR:[],
      rowDRInvert:[]
    };

    var time=jsonData.time;
    var name="Test_"+(indiceTest+1);

    proyectosRow.rowKilled.push(name);
    proyectosRow.rowMutant.push(name);
    proyectosRow.rowDR.push(name);
    proyectosRow.rowDRInvert.push(indiceTest + 1);


    for (var i = 0; i < currentDatosComparacion.proyectoTests.length; i++) {
      var mutante=currentDatosComparacion.proyectoTests[i][indiceTest].numMutants;
      var killed=currentDatosComparacion.proyectoTests[i][indiceTest].killed;
      var dr=killed/mutante;
      var dr2=(1/(1-dr));
      ultiDr2=dr2;
      proyectosRow.rowKilled.push(killed);
      proyectosRow.rowMutant.push(mutante);
      proyectosRow.rowDR.push(dr);
      proyectosRow.rowDRInvert.push(dr2);
    }

    // Añadimos la fila
    data.addRows([ proyectosRow.rowKilled]);
    dataMutant.addRows([ proyectosRow.rowMutant]);
    dataDR.addRows([ proyectosRow.rowDR]);
    dataDR2.addRows([ proyectosRow.rowDRInvert]);
  });

  // Añadimos al final
  dataDR2.addRows([[ currentDatosComparacion.proyectoTests[0].length+1,ultiDr2*2,ultiDr2*2]]);
  //  dataDR.sort([{column: 1}]);
  // dataDR2.sort([{column: 0}]);
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
      title: 'Coste (numero de Tests)'
    },
    colors: ['#AB0D06', '#007329'],
    pointSize: 15,
    orientation: 'vertical'
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

function getProyectoPorId(idProyecto) {
  return $.ajax({
    url: SERVER + 'proyectos/' + idProyecto,
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
