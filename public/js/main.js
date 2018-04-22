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
      case 'nav-listado-proyectos':
        $('.container > div').addClass('hidden');
        $('#listado-proyectos').removeClass('hidden');

        /*$.when(getCampeonatos()).done(function(campeonatos) {
          rellenarCampeonatos(campeonatos);
        });*/

        $.when(getProyectos()).done(function(proyectos) {
          rellenarProyectos(proyectos);
        });
        break;
      case 'nav-experimeto':
        $('.container > div').addClass('hidden');
        $('#home-experimento').removeClass('hidden');

        /*$.when(getEquiposPorIdCreador()).done(function(equipos) {
          rellenarEquipos(equipos);
        });*/
        // rellenarSelectCampeonatosListaEquipos(); //###CambiosCR
        break;

    }
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
