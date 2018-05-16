'use strict';

// Variable que se usa para guardar temporalmente la lista de competicones al crear un nuevo campeonato antes de subir a BBDD.
var listaCompeticiones = [];
// Variable que se usa para guardar temporalmente el idCampeonato que se ha seleccionado.
var idCampeonatoSeleccionado = -1;

var SERVER = '/'; // MIKE
$(document).ready(function() {
(function (d, io, $){
	'use strict'
  var io = io()

  $('nav-home').click();

  $('nav li').on('click', function() {
    $('nav li').removeClass('active');
    $(this).addClass('active');

    switch($(this).attr('id')) {
      // BOTÓN: ESTADÍSTICAS
      case 'nav-listado-proyectos':
            console.log("emitiendo");
            // Desaparece suavamente
            $('.container > div').fadeOut(400);

            io.emit('listado proyectos');

            // Aparece suavemente
            setTimeout(function () {
              // Se elimina todo lo que hubiese
              $('.container > div').addClass('hidden');
              $('#listado-proyectos').removeClass('hidden');
              $('.container > div').fadeIn(300);
            }, 500);
      break;
      // BOTÓN: CREAR PROYECTO
      case 'nav-experimeto':
            $('.container > div').fadeOut(400);
            setTimeout(function () {
              $('.container > div').addClass('hidden');
              $('#home-experimento').removeClass('hidden');
              $('.container > div').fadeIn(300);
            }, 500);
      break;
      // BOTÓN: GENERAR PROGRAMA
      case 'nav-generador':
            $('.container > div').fadeOut(400);
            setTimeout(function () {
              $('.container > div').addClass('hidden');
              $('#home-generador').removeClass('hidden');
              $('.container > div').fadeIn(300);
            }, 500);
      break;
      // BOTÓN: GENERAR PROGRAMA AUTOMATICO
      case 'nav-generador-automatico':
          generadorDeProgramasAutomaticoListasPruebasV10();
      break;
      // BOTÓN: COMPLEXITY TO TESTING
      case 'nav-home':
          $('.container > div').fadeOut(400);
          setTimeout(function () {
            $('.container > div').addClass('hidden');
            $('#home-principal').removeClass('hidden');
            $('.container > div').fadeIn(300);
          }, 500);
      break;
      // BOTÓN: COMPLEXITY TO TESTING
      case 'nav-grafica-prueba':
          $('.container > div').fadeOut(400);
          setTimeout(function () {
            $('.container > div').addClass('hidden');
            $('#home-graficas-prueba').removeClass('hidden');
            $('.container > div').fadeIn(300);
          }, 500);
      break;
    }
  });
  // GESTION GENERARDOR DE PROGRAMA
  $('#btn-nuevo-programa').on('click', function() {
    // generadorDeProgramasAutomatico2();
    var nombreProyecto = $('#inputNombreProyectoGenerado').val();
    var listaMutantes = getChecksMutantes1();
    console.log(listaMutantes);
    var datosPrograma = {
      listaMutantes:listaMutantes,
      nombreProyecto:$('#inputNombreProyectoGenerado').val(),
      numeroAnidacionesIf: $('#inputNumeroAnidacionesIf').val(),
      numeroAnidacionesWhile: $('#inputNumeroAnidacionesWhile').val(),
      numeroIteracionesWhile: $('#inputNumeroIteracionesWhile').val(),
      numeroAnidacionesFor: $('#inputNumeroAnidacionesFor').val(),
      numeroIteracionesFor: $('#inputNumeroIteracionesFor').val(),
      numeroCondicionesLogicas: $('#inputNumeroCondicionesLogicas').val(),
      numeroExpresionesLogicas: $('#inputNumeroExpresionesLogicas').val(),
      numeroExpresionesAritmeticas: $('#inputNumeroExpresionesAritmeticas').val(),
      numeroExpresionesSeguidas: $('#inputNumeroExpresionesSeguidas').val(),
      listaInputsComprobacion: $('#inputsInputDeComprobacion').val(),
      numeroFuncion:  $('#inputNumeroFuncion').val(),
      decicionInputs:  $('#inputDecisionInputs').val(),
      size_tests: $('#inputsSize_tests').val(),
      aleatorio:  getAtrAleatorio(),
      ini:  $('#inputIni').val(),
      fin:  $('#inputFin').val(),
      ifsAniCuerpoBucle:  $('#inputFfsAniCuerpoBucle').val()
    }

    // Si se ha rellenado todos los campos.
    if (validarFormularioGeneradorPrograma() && listaMutantes !== "") {
      // Activamos el loader
      $('#preloader').removeClass('hidden');

      io.emit('generarPrograma', datosPrograma);
      //$.when(generarPrograma(datosPrograma, nombreProyecto)).done(function() {
        // Desactivamos el loader

      //});
    } else {
      $.notify({
        title: "<strong>Info</strong>:",
        message: " Debes completar los campos en rojo."
      },{
        // settings
        type: 'info'
      });
    }
  });

  // GESION DE PROYECTOS
  $('#btn-ejecutar-proyecto').on('click', function() {
      var nombreProyecto = $('#inputNombreProyecto').val();
      var listaMutantes = getChecksMutantes();

      if (nombreProyecto !== "" && listaMutantes !=="") {
        $('.container > div').addClass('hidden');
        $('#preloader').removeClass('hidden');
        io.emit('ejecutarProyecto', {nombreProyecto:nombreProyecto,listaMutantes:listaMutantes});
      } else {
        $.notify({
          title: "<strong>Info</strong>:",
          message: " Debes completar los campos en rojo."
        },{
          // settings
          type: 'info'
        });
      }
  });

  $('#btn-mostrar-grafica-prueba').on('click', function() {
      var nombrePrueba = $('#inputNombrePrueba').val();
      verEstadisticasPorPrueba(nombrePrueba);
  });

  $("#btnSubmitClasses").click(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();

        // Get form
        var form = $('#fileUploadFormClasses')[0];

        // Create an FormData object
        var data = new FormData(form);

        // If you want to add an extra field for the FormData
        data.append("CustomField", "This is some extra data, testing");

        // disabled the submit button
        $("#btnSubmitClasses").prop("disabled", true);

        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/procesar_file_Classes",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {
              if (data.exito) {
                $("#resultClasses").text("SUCCESS : "+data.msg);
                $("#btnSubmitClasses").prop("disabled", false);
              } else {
                $("#resultClasses").text("ERROR : "+data.msg);
                $("#btnSubmitClasses").prop("disabled", false);
              }
            },
            error: function (e) {
                $("#resultClasses").text("ERROR : "+e.responseText.msg);
                $("#btnSubmitClasses").prop("disabled", false);
            },
            complete: function(xhr, status) {

            }
        });

    });

  $("#btnSubmitTests").click(function (event) {
          console.log("<-- On click Submit");
          //stop submit the form, we will post it manually.
          event.preventDefault();

          // Get form
          var form = $('#fileUploadFormTests')[0];

      // Create an FormData object
          var data = new FormData(form);

      // If you want to add an extra field for the FormData
          data.append("CustomField", "This is some extra data, testing");

      // disabled the submit button
          $("#btnSubmitTests").prop("disabled", true);

          $.ajax({
              type: "POST",
              enctype: 'multipart/form-data',
              url: "/procesar_file_Tests",
              data: data,
              processData: false,
              contentType: false,
              cache: false,
              timeout: 600000,
              success: function (data) {
                if (data.exito) {
                  $("#resultTests").text("SUCCESS : "+data.msg);
                  $("#btnSubmitTests").prop("disabled", false);
                } else {
                  $("#resultTests").text("ERROR : "+data.msg);
                  $("#btnSubmitTests").prop("disabled", false);
                }
              },
              error: function (e) {
                  $("#resultTests").text("ERROR : "+e.responseText.msg);
                  $("#btnSubmitTests").prop("disabled", false);
              },
              complete: function(xhr, status) {
              }
          });

      });


	$('#chat-form').on('submit', function (e){
		e.preventDefault()
		io.emit( 'new message', $('#message-text').val() )
		$('#message-text').val(null)
		return false
	})

	io.on('new user', function (newUser){
		alert(newUser.message)
	})

	io.on('mostrar proyectos', function (proyectos){
		rellenarProyectos(proyectos);
	})
  io.on('mostrar estadisticas', function (estadisticas){
    mostrarEstadisticas(estadisticas);
    $('#preloader').addClass('hidden');
  })
  io.on('test guardado', function (idProyecto){
    io.emit('obtenerEstadisticasPorIdProyecto', idProyecto);
  })
	io.on('mostrar error', function (msg){
    $.notify({
    	title: "<strong>Error</strong>",
    	message: msg
    },{
    	// settings
    	type: 'danger'
    });
	})
	io.on('mostrar exito', function (msg){
    $('#preloader').addClass('hidden');
    $.notify({
    	title: "<strong>Exito </strong>:",
    	message: msg
    },{
    	// settings
    	type: 'success'
    });
	})
	io.on('mostrar finalizado', function (msg){
    $('#preloader').addClass('hidden');
    $.notify({
    	title: "<strong>Finalizado </strong>:",
    	message: msg
    },{
    	// settings
    	type: 'success'
    });
	})
	io.on('mostrar proceso', function (msg){
    $.notify({
    	title: "<strong>Info</strong>:",
    	message: msg
    },{
    	// settings
    	type: 'info'
    });
	})
})(document, io, jQuery)

function PathLoader(el) {
	this.el = el;
    this.strokeLength = el.getTotalLength();

    // set dash offset to 0
    this.el.style.strokeDasharray =
    this.el.style.strokeDashoffset = this.strokeLength;
}

PathLoader.prototype._draw = function (val) {
    this.el.style.strokeDashoffset = this.strokeLength * (1 - val);
}

PathLoader.prototype.setProgress = function (val, cb) {
	this._draw(val);
    if(cb && typeof cb === 'function') cb();
}

PathLoader.prototype.setProgressFn = function (fn) {
	if(typeof fn === 'function') fn(this);
}

document.addEventListener('click', function () {

    if(document.body.classList.contains('active')) {
        document.body.classList.remove('active');
        return;
    }
    document.body.classList.add('active');
});

/* Función para validar campos */
function validarFormularioGeneradorPrograma(){
  var listaInputs = $('#inputsInputDeComprobacion').val();
  var listaEnteros = listaInputs.split(",")
  var ultimoChar = listaInputs.slice(-1);
  var esEntero = true;

  for (var i = 0; i < listaEnteros.length; i++) {
    if (isNaN(listaEnteros[i])) {
      esEntero = false;
    }
  }

  var valido = true;
  //  jQuery.validator.messages.number = 'Esta campo debe ser num&eacute;rico.';
  if (esEntero === false) {
    valido = false;
    alert("Hay un input que no es entero en la lista de inputs, (Ejemplo: 1,2,3,4,5,)")
  }
  if (ultimoChar !== ",") {
    valido = false;
    alert("El último caracter de la lista de inputs tiene que ser una , (Ejemplo: 1,2,3,4,5,)")
  }
  if ($('#inputNombreProyectoGenerado').val() == "") {
    valido = false;
  }
  if ($('#inputNumeroAnidacionesIf').val() == "") {
    $('#numeroAnidacionesIf').addClass('has-error');
    valido = false;
  }else{
    $('#numeroAnidacionesIf').removeClass('has-error');
  }
  if ($('#inputNumeroAnidacionesWhile').val() == "") {
    $('#numeroAnidacionesWhile').addClass('has-error');
    valido = false;
  }else{
    $('#numeroAnidacionesWhile').removeClass('has-error');
  }
  if ($('#inputNumeroIteracionesWhile').val() == "") {
    $('#numeroIteracionesWhile').addClass('has-error');
    valido = false;
  }else{
    $('#numeroIteracionesWhile').removeClass('has-error');
  }
  if ($('#inputNumeroAnidacionesFor').val() == "") {
    $('#numeroAnidacionesFor').addClass('has-error');
    valido = false;
  }else{
    $('#numeroAnidacionesFor').removeClass('has-error');
  }
  if ($('#inputNumeroIteracionesFor').val() == "") {
    $('#numeroIteracionesFor').addClass('has-error');
    valido = false;
  }else{
    $('#numeroIteracionesFor').removeClass('has-error');
  }
  if ($('#inputNumeroCondicionesLogicas').val() == "") {
    $('#numeroCondicionesLogicas').addClass('has-error');
    valido = false;
  }else{
    $('#numeroCondicionesLogicas').removeClass('has-error');
  }
  if ($('#inputNumeroExpresionesLogicas').val() == "") {
    $('#numeroExpresionesLogicas').addClass('has-error');
    valido = false;
  }else{
    $('#numeroExpresionesLogicas').removeClass('has-error');
  }
  if ($('#inputNumeroExpresionesAritmeticas').val() == "") {
    $('#numeroExpresionesAritmeticas').addClass('has-error');
    valido = false;
  }else{
    $('#numeroExpresionesAritmeticas').removeClass('has-error');
  }
  if ($('#inputNumeroExpresionesSeguidas').val() == "") {
    $('#numeroExpresionesSeguidas').addClass('has-error');
    valido = false;
  }else{
    $('#numeroExpresionesSeguidas').removeClass('has-error');
  }
  if ($('#inputNumeroFuncion').val() == "") {
    $('#numeroFuncion').addClass('has-error');
    valido = false;
  }else{
    $('#numeroFuncion').removeClass('has-error');
  }
  if ($('#inputDecisionInputs').val() == "") {
    $('#decicionInputs').addClass('has-error');
    valido = false;
  }else{
    $('#decicionInputs').removeClass('has-error');
  }
  if ($('#inputsSize_tests').val() == "") {
    $('#size_tests').addClass('has-error');
    valido = false;
  }else{
    $('#size_tests').removeClass('has-error');
  }

  if ($('#inputIni').val() == "") {
    $('#ini').addClass('has-error');
    valido = false;
  }else{
    $('#ini').removeClass('has-error');
  }
  if ($('#inputFin').val() == "") {
    $('#fin').addClass('has-error');
    valido = false;
  }else{
    $('#fin').removeClass('has-error');
  }
  if ($('#inputFfsAniCuerpoBucle').val() == "") {
    $('#ifsAniCuerpoBucle').addClass('has-error');
    valido = false;
  }else{
    $('#ifsAniCuerpoBucle').removeClass('has-error');
  }
  return valido;
}
});
