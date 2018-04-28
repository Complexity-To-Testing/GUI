'use strict';

// Variable que se usa para guardar temporalmente la lista de competicones al crear un nuevo campeonato antes de subir a BBDD.
var listaCompeticiones = [];
// Variable que se usa para guardar temporalmente el idCampeonato que se ha seleccionado.
var idCampeonatoSeleccionado = -1;

var SERVER = '/'; // MIKE

$(document).ready(function() {
  $('nav li').on('click', function() {
    $('nav li').removeClass('active');
    $(this).addClass('active');

    switch($(this).attr('id')) {
      // BOTÓN: ESTADÍSTICAS
      case 'nav-listado-proyectos':
            // Desaparece suavamente
            $('.container > div').fadeOut(400);
            // Se elimina todo lo que hubiese
            $('.container > div').addClass('hidden');
            $('#listado-proyectos').removeClass('hidden');
            // Y se rellena la nueva lista
            $.when(getProyectos()).done(function(proyectos) {
              rellenarProyectos(proyectos);
            });
            // Aparece suavemente
            setTimeout(function () {
              $('.container > div').fadeIn(300);
            }, 500);
      break;
      // BOTÓN: CREAR PROYECTO
      case 'nav-experimeto':
            $('.container > div').fadeOut(400);
            $('.container > div').addClass('hidden');
            $('#home-experimento').removeClass('hidden');
            setTimeout(function () {
              $('.container > div').fadeIn(300);
            }, 500);
      break;
      // BOTÓN: GENERAR PROGRAMA
      case 'nav-generador':
            $('.container > div').fadeOut(400);
            $('.container > div').addClass('hidden');
            $('#home-generador').removeClass('hidden');
            setTimeout(function () {
              $('.container > div').fadeIn(300);
            }, 500);
      break;
      // BOTÓN: COMPLEXITY TO TESTING
      case 'nav-home':
          $('.container > div').fadeOut(400);
          $('.container > div').addClass('hidden');
          $('#home-principal').removeClass('hidden');
          setTimeout(function () {
            $('.container > div').fadeIn(300);
          }, 500);
      break;
      // BOTÓN: COMPLEXITY TO TESTING
      case 'nav-grafica-prueba':
          $('.container > div').fadeOut(400);
          $('.container > div').addClass('hidden');
          $('#home-graficas-prueba').removeClass('hidden');
          setTimeout(function () {
            $('.container > div').fadeIn(300);
          }, 500);
      break;
    }
  });
  // GESTION GENERARDOR DE PROGRAMA
  $('#btn-nuevo-programa').on('click', function() {
    programaTestNumAnidacionesIf();
    /*
    var datosPrograma = {
      numeroAnidacionesIf: $('#inputNumeroAnidacionesIf').val(),
      numeroAnidacionesWhile: $('#inputNumeroAnidacionesWhile').val(),
      numeroIteracionesWhile: $('#inputNumeroIteracionesWhile').val(),
      numeroAnidacionesFor: $('#inputNumeroAnidacionesFor').val(),
      numeroIteracionesFor: $('#inputNumeroIteracionesFor').val(),
      numeroCondicionesLogicas: $('#inputNumeroCondicionesLogicas').val(),
      numeroExpresionesLogicas: $('#inputNumeroExpresionesLogicas').val(),
      numeroExpresionesAritmeticas: $('#inputNumeroExpresionesAritmeticas').val()
    }

    // Si se ha rellenado todos los campos.
    if (validarFormularioGeneradorPrograma()) {
      generarPrograma(datosPrograma);
    } else {
      alert("Debes completar los campos en rojo.")
    }*/
  });

  // GESION DE PROYECTOS
  $('#btn-ejecutar-proyecto').on('click', function() {
      var nombreProyecto = $('#inputNombreProyecto').val();
      $('.container > div').addClass('hidden');
      $('#preloader').removeClass('hidden');
      var resultado = $.ajax({
        url: SERVER + "ejecutar/"+nombreProyecto,
        type: "GET",
        dataType: 'json',
        data: {},
        success: function(data) {
          if (data.exito) {
            $('#preloader').addClass('hidden');
            $('#preloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
            $('#success').removeClass('hidden')
            $('#success').delay(350).css({'overflow':'visible'});
          } else {
            alert("ERROR"+ data.msg);
          }
        },
        error: function (xhr, status) { alert('Oooops, hubo un error...'); },
        complete: function(xhr, status) {
        }
      });
  });

  $('#btn-mostrar-grafica-prueba').on('click', function() {
      var nombrePrueba = $('#inputNombrePrueba').val();
      console.log("<-- on clink mostrar grafica ");
      console.log(nombrePrueba);
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
              }
          });

      });
});

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
  var valido = true;
  //  jQuery.validator.messages.number = 'Esta campo debe ser num&eacute;rico.';
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
  return valido;
}
