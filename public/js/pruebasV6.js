var nombrePrueba = "P9.1"
var tamPrueba = 10  ;
var inputString = getListaInputsInc(-3000, 3000);
var i = 0;
function generadorDeProgramasAutomaticoP9_1() {
  tamPrueba -= 1;
  if (tamPrueba < 0) {
    return;
  }
  i+=1;

  var datosPrograma = {
    numeroAnidacionesIf: 1,
    numeroAnidacionesWhile: 1,
    numeroIteracionesWhile: 1,
    numeroAnidacionesFor: 1,
    numeroIteracionesFor: 1,
    numeroCondicionesLogicas: 1,
    numeroExpresionesLogicas: 1,
    numeroExpresionesAritmeticas: 1,
    numeroExpresionesSeguidas: 1,
    listaInputsComprobacion: inputString,
    numeroFuncion: 1,
    decicionInputs: getListaDecision(i),//getRandomInput(0, 1)
    profundidadInicial: 1,
    profundidadFinal: 4
  }

  console.log("<--- Iteracion " + i);
  var nombreProyecto = nombrePrueba + "("
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
    generadorDeProgramasAutomaticoP9_1();
  });
}

  var fila = 0;
  var tamPrueba = 100;        // Tamaño de la prueba
  var columna = 0;           //
  var valoresParam =   [1,1,1,1,1,1,1,1,1];
  var validosParam = [true, true, true, true, true, true, true, true, true]
  var parametroTam =   [10,10,100,10,100,10,10,10,10];
  var casos = [ "AnidIf_",
                "AnidWhile_",
                "IterWhile_",
                "AnidFor_",
                "IterFor_",
                "CondLog_",
                "ExprLog_",
                "ExprArit_",
                "ExprsSeg_"];

  function generadorDeProgramasAutomaticoP9_2() {
    if (fila === valoresParam.length) {
      validosParam[columna] = false;
      columna++;
      fila = 0;

      if (columna === valoresParam.length) {
        return;
      }
    }

    if (fila !== columna){
      valoresParam[columna] =  fila + 1;
      valoresParam[fila] = fila + 1;
      var nombreProyecto = casos[columna]+casos[fila];
      var datosPrograma = {
        numeroAnidacionesIf: valoresParam[0],
        numeroAnidacionesWhile: valoresParam[1],
        numeroIteracionesWhile: valoresParam[2],
        numeroAnidacionesFor: valoresParam[3],
        numeroIteracionesFor: valoresParam[4],
        numeroCondicionesLogicas: valoresParam[5],
        numeroExpresionesLogicas: valoresParam[6],
        numeroExpresionesAritmeticas: valoresParam[7],
        numeroExpresionesSeguidas: valoresParam[8],
        listaInputsComprobacion: "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,",
        numeroFuncion: 2,
        decicionInputs: "0,1,",
        profundidadInicial: 1,
        profundidadFinal: 4
      }
      console.log("fila:"+fila + " " + "columna:"+columna + " " + nombreProyecto);
      console.log(valoresParam);
      $.when(generarPrograma(datosPrograma, nombreProyecto)).done(function() {
        fila ++;
        generadorDeProgramasAutomaticoP9_2();
      });
    } else {

      fila ++;
      generadorDeProgramasAutomaticoP9_2();
    }
  }

  var prefijo = "V9_"
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
