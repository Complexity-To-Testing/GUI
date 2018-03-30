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
        '<td align="right"> <form name="verEstadisticas" action="javascript:verEstadisticas(' + proyecto.idProyecto + ', ' + nombreProyecto + ');" > <input id="verEstadisticas"  class="btn btn-primary btn-success" type="submit" value="Ver estadisticas" /> </form> </td>' +
      '</tr>'
    );
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

function verEstadisticas(idProyecto, nombreProyecto) {
  //listaEstadisticas = [];
  //idProyectoSeleccionado = idProyecto;

  /*$.when(obtenerEstadisticasPorIdProyecto(idProyecto)).done(function(estadisticas) {
    if (estadisticas != null) {
      estadisticas.forEach(function(resultadoTest) {
        listaEstadisticas.push({idCompeticion: resultadoTest.id, nombreCompeticion: resultadoTest.nombre, esLiga: Boolean(resultadoTest.liga), posicionArray: listaEstadisticas.length});
      });
    }

    mostrarGraficas(listaEstadisticas);

    $('.container > div').addClass('hidden');
    $('#chart').removeClass('hidden');
  });
  */
  $('.container > div').addClass('hidden');
  $('#chart').removeClass('hidden');
}

function obtenerEstadisticasPorIdProyecto(idProyecto) {
  return $.ajax({
    url: SERVER + "proyecto/getEstadisticas/" + idProyecto,
    type: "GET",
    dataType: 'json',
    error: function (xhr, status) { alert('Oooops, hubo un error...'); },
    complete: function(xhr, status) {}
  });
}
