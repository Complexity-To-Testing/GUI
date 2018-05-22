
  // A2 modificamos lista de inputs con valores aleatorios
  // A3 pares de pruebas lista de decision_input(1) inputs con valores aleatorios
  // A5 Increment iter For mutant CONDITIONALS_BOUNDARY
  // A7 Increment iter For mutant MATH
  // A8 Increment iter For mutant INCREMENTS
  // A9 Increment iter For mutant INCREMENTS profFin 10
  // B1 combinacion de pares con profFin = 500 mutantes 0 1 2 3 -> generadorPrograma no genera Programa
  // B2 combinacion de pares con profFin = 200 mutantes 0 1 2 3 -> generadorPrograma no genera Programa

  // F1 F1_0123_
  // M_0  listaDecision = 1
  // M_1  listaDecision = 1
  // M_2  listaDecision = 1
  // M_3  listaDecision = 1
/*
  "INCREMENTS"                    # 0
  "MATH"                          # 1
  "CONDITIONALS_BOUNDARY"         # 2
  "NEGATE_CONDITIONALS"           # 3
  "INVERT_NEGS"                   # 4
  "RETURN_VALS"                   # 5
  "VOID_METHOD_CALLS"             # 6
  "CONSTRUCTOR_CALLS"             # 7
  "INLINE_CONSTS"                 # 8
  "NON_VOID_METHOD_CALLS"         # 9
  "REMOVE_CONDITIONALS"           # 10
  "EXPERIMENTAL_MEMBER_VARIABLE"  # 11
  "EXPERIMENTAL_SWITCH")          # 12
  */
  var listaPruebas = [
                      [0]
                      [1]
                      [2]
                      [3]
                      [4]
                      [5]
                      [6]
                      [7]
                      [8]
                    ];
  var conjuntoPruebasDefecto = {
    prefijo: "01234_2_Atr_5_tests_",
    tamPrueba: 3,
    contPrueba: 0,
    parametroCont:          [ 1,// AndIf
                            1,// AnidWhile_
                            1,// IterWhile_
                            2,// AnidFor_
                            1,// IterFor_
                            1,// CondLog_
                            1,// ExprLog_
                            1,// ExprArit_
                            2// ExprsSeg_
                          ],
    parametrosPorDefecto:[1,1,1,2,1,1,1,1,1],
    parametroIncremento: [3,3,30,3,30,3,3,3,3],
    listaPruebas: listaPruebas, // Conjuntos de atributos a probar
    parametroTam: 0,
    contListaPruebas: 0,
    pruebaAEjecutar: listaPruebas[contListaPruebas],
    listaNombrePrueba:[ "AnidIf",    // 0
                        "AnidWhile_", // 1
                        "IterWhile_", // 2
                        "AnidFor_",   // 3
                        "IterFor_",   // 4
                        "CondLog_",   // 5
                        "ExprLog_",   // 6
                        "ExprArit_",  // 7
                        "ExprsSeg_"  // 8
                      ],
     datosPrograma : {
       nombreProyecto:"",
      listaMutantes: "0 1 2 3 4",
      numeroAnidacionesIf: parametroCont[0],
      numeroAnidacionesWhile: parametroCont[1],
      numeroIteracionesWhile: parametroCont[2],
      numeroAnidacionesFor: parametroCont[3],
      numeroIteracionesFor: parametroCont[4],
      numeroCondicionesLogicas: parametroCont[5],
      numeroExpresionesLogicas: parametroCont[6],
      numeroExpresionesAritmeticas: parametroCont[7],
      numeroExpresionesSeguidas: parametroCont[8],
      listaInputsComprobacion:  getListaAleatorioInputs(-200,200, 401),  // para (-5,5) -> devuelve -5,-4,-3,-2,-1,0,1,2,3,4,5,
      numeroFuncion: 1,
      decicionInputs: "1,", //  Para (3) -> Devuelve 0,0,0,
      size_tests: 5,
      ifsAniCuerpoBucle: 1,
      aleatorio: 0,
      ini: 1,
      fin: 2
    }
  }

  function ejecutarConjuntoPruebas(conjuntoPruebas) {
    console.log("<-- ejecutarConjuntoPruebas");

    (function (d, io, $){
      'use strict'
      var io = io()

      if (conjuntoPruebas.contPrueba === conjuntoPruebas.tamPrueba) {
        if (conjuntoPruebas.contListaPruebas === conjuntoPruebas.listaPruebas.length ){
          return;
        } else {
          conjuntoPruebas.contListaPruebas++;
          conjuntoPruebas.pruebaAEjecutar=conjuntoPruebas.listaPruebas[conjuntoPruebas.contListaPruebas];
          conjuntoPruebas.parametroCont = [1,1,1,1,1,1,1,1,1];
          conjuntoPruebas.contPrueba = 0;
          if (conjuntoPruebas.pruebaAEjecutar === undefined) {
            return;
          }
        }
      }else {
        conjuntoPruebas.contPrueba++;
      }

    conjuntoPruebas.datosPrograma.nombreProyecto = conjuntoPruebas.prefijo;

    for (var i = 0; i < conjuntoPruebas.pruebaAEjecutar.length; i++) {
      conjuntoPruebas.parametroCont[conjuntoPruebas.pruebaAEjecutar[i]] += conjuntoPruebas.parametroIncremento[conjuntoPruebas.pruebaAEjecutar[i]];
    }
    for (var i = 0; i < conjuntoPruebas.pruebaAEjecutar.length; i++) {
      conjuntoPruebas.datosPrograma.nombreProyecto += conjuntoPruebas.listaNombrePrueba[conjuntoPruebas.pruebaAEjecutar[i]]+ "_"+conjuntoPruebas.parametroCont[conjuntoPruebas.pruebaAEjecutar[i]]+"_";
    }


     conjuntoPruebas.datosPrograma.numeroAnidacionesIf=conjuntoPruebas.parametroCont[0];
     conjuntoPruebas.datosPrograma.numeroAnidacionesWhile=conjuntoPruebas.parametroCont[1];
     conjuntoPruebas.datosPrograma.numeroIteracionesWhile=conjuntoPruebas.parametroCont[2];
     conjuntoPruebas.datosPrograma.numeroAnidacionesFor=conjuntoPruebas.parametroCont[3];
     conjuntoPruebas.datosPrograma.numeroIteracionesFor=conjuntoPruebas.parametroCont[4];
     conjuntoPruebas.datosPrograma.numeroCondicionesLogicas=conjuntoPruebas.parametroCont[5];
     conjuntoPruebas.datosPrograma.numeroExpresionesLogicas=conjuntoPruebas.parametroCont[6];
     conjuntoPruebas.datosPrograma.numeroExpresionesAritmeticas=conjuntoPruebas.parametroCont[7];
     conjuntoPruebas.datosPrograma.numeroExpresionesSeguidas=conjuntoPruebas.parametroCont[8];
       console.log(conjuntoPruebas.pruebaAEjecutar);
       console.log(conjuntoPruebas.datosPrograma);
    //console.log(conjuntoPruebas.datosPrograma);
    io.emit('ejecutar-conjunto-pruebas', conjuntoPruebas);

    })(document, io, jQuery);
  }
