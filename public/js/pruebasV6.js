
  var prefijo = "A1_"
  var tamPrueba = 10
  var contPrueba = 0;
  var parametroCont =   [1,1,1,1,1,1,1,1,1,1,1,1];
  var parametroIncremento =  [1,1,1,1,1,1,1,1,1,1,1,1];
  var parametroTam =        [5,5,5,5,5,5,5,5,5,5,5,5];
  var listaPruebas = [[0],[1],[2],[3],[4],[5],[6],[7],[8],[9],[10],[11]]; // Aqui meter los casos
  var contListaPruebas = 0
  var pruebaAEjecutar = listaPruebas[contListaPruebas];
  var listaNombrePrueba = [ "AnidIf_",    // 0
                            "AnidWhile_", // 1
                            "IterWhile_", // 2
                            "AnidFor_",   // 3
                            "IterFor_",   // 4
                            "CondLog_",   // 5
                            "ExprLog_",   // 6
                            "ExprArit_",  // 7
                            "ExprsSeg_",  // 8
                            "NumFun_",    // 9
                            "ProfIni_",   // 10
                            "ProfFin_"    // 11
                          ];
  function generadorDeProgramasAutomaticoListasPruebas() {
      if (contPrueba === tamPrueba) {
        if (contListaPruebas === listaPruebas.length ){
          return;
        } else {
          contListaPruebas++;
          pruebaAEjecutar=listaPruebas[contListaPruebas];
          parametroCont = [1,1,1,1,1,1,1,1,1,1,1,1];
          contPrueba = 0;
          console.log(pruebaAEjecutar);
          if (pruebaAEjecutar === undefined) {
            return;
          }
        }
      }else {
        contPrueba++;
      }

    var nombreProyecto = "";
    for (var i = 0; i < pruebaAEjecutar.length; i++) {
      parametroCont[pruebaAEjecutar[i]] += parametroIncremento[pruebaAEjecutar[i]];
    }
    for (var i = 0; i < pruebaAEjecutar.length; i++) {
      nombreProyecto += listaNombrePrueba[pruebaAEjecutar[i]]+ "_";
    }


    var datosPrograma = {
      numeroAnidacionesIf: parametroCont[0],
      numeroAnidacionesWhile: parametroCont[1],
      numeroIteracionesWhile: parametroCont[2],
      numeroAnidacionesFor: parametroCont[3],
      numeroIteracionesFor: parametroCont[4],
      numeroCondicionesLogicas: parametroCont[5],
      numeroExpresionesLogicas: parametroCont[6],
      numeroExpresionesAritmeticas: parametroCont[7],
      numeroExpresionesSeguidas: parametroCont[8],
      listaInputsComprobacion: getListaInputsInc(contPrueba*(-1), contPrueba),  // para (-5,5) -> devuelve -5,-4,-3,-2,-1,0,1,2,3,4,5,
      numeroFuncion: parametroCont[9],
      decicionInputs: getListaDecision(10), //  Para (3) -> Devuelve 0,0,0,
      profundidadInicial: parametroCont[10],
      profundidadFinal: parametroCont[11]
    }

    nombreProyecto = prefijo + nombreProyecto + "("
    +datosPrograma.numeroAnidacionesIf + ", "
    +datosPrograma.numeroAnidacionesWhile + ", "
    +datosPrograma.numeroIteracionesWhile + ", "
    +datosPrograma.numeroAnidacionesFor + ", "
    +datosPrograma.numeroIteracionesFor + ", "
    +datosPrograma.numeroCondicionesLogicas + ", "
    +datosPrograma.numeroExpresionesLogicas + ", "
    +datosPrograma.numeroExpresionesAritmeticas + ", "
    +datosPrograma.numeroExpresionesSeguidas + ", "
    +datosPrograma.numeroFuncion + ", "
    +datosPrograma.profundidadInicial + ", "
    +datosPrograma.profundidadFinal + ""
    +")";
    console.log(nombreProyecto);
    $.when(generarPrograma(datosPrograma, nombreProyecto)).done(function() {
      generadorDeProgramasAutomaticoListasPruebas();
    });
  }
