/*
incrementar ifs de anidacion hasta 50
int num_while=1;//numero de anidacion
int size_while=1;//numero de iteracion
int num_for=1;//numero de anidacion
int size_for=1;//numero de iteracion
int size_cond=1;
int size_expLogics=1;
int size_expArit=1;
int num_exp_seguida=4
int num_funcion=1
int[] decision_inputs={0}

*/
var tamPrueba = 50;
var inputString = getListaInputsInc(-500, 500);
var i = 0;
function generadorDeProgramasAutomaticoP8_1() {
  tamPrueba -= 1;
  if (tamPrueba < 0) {
    return;
  }
  i+=1;
  var nombreProyecto = "P8.1_("+i+",1,1,1,1,1,1,1,4,1)Input[-500,500]";
  var datosPrograma = {
    numeroAnidacionesIf: i,
    numeroAnidacionesWhile: 1,
    numeroIteracionesWhile: 1,
    numeroAnidacionesFor: 1,
    numeroIteracionesFor: 1,
    numeroCondicionesLogicas: 1,
    numeroExpresionesLogicas: 1,
    numeroExpresionesAritmeticas: 1,
    numeroExpresionesSeguidas: 4,
    listaInputsComprobacion: inputString,
    numeroFuncion: 1,
    decicionInputs: "0,"//getRandomInput(0, 1)
  }
  console.log(nombreProyecto);
  $.when(generarPrograma(datosPrograma, nombreProyecto)).done(function() {
    generadorDeProgramasAutomaticoP8_1();
  });
}
var tamPrueba = 50;
var inputString = getListaInputsInc(-500, 500);
var i = 0;
function generadorDeProgramasAutomaticoP8_2() {
  tamPrueba -= 1;
  if (tamPrueba < 0) {
    return;
  }
  i+=1;
  var nombreProyecto = "P8.2_(1,"+i+",1,1,1,1,1,1,4,1)Input[-500,500]";
  var datosPrograma = {
    numeroAnidacionesIf: 1,
    numeroAnidacionesWhile: i,
    numeroIteracionesWhile: 1,
    numeroAnidacionesFor: 1,
    numeroIteracionesFor: 1,
    numeroCondicionesLogicas: 1,
    numeroExpresionesLogicas: 1,
    numeroExpresionesAritmeticas: 1,
    numeroExpresionesSeguidas: 4,
    listaInputsComprobacion: inputString,
    numeroFuncion: 1,
    decicionInputs: "0,"//getRandomInput(0, 1)
  }
  console.log(nombreProyecto);
  $.when(generarPrograma(datosPrograma, nombreProyecto)).done(function() {
    generadorDeProgramasAutomaticoP8_2();
  });
}
var tamPrueba = 25;
var inputString = getListaInputsInc(-500, 500);
var i = 14;
function generadorDeProgramasAutomaticoP8_3() {
  tamPrueba -= 1;
  if (tamPrueba < 0) {
    return;
  }
  i+=1;
  var nombreProyecto = "P8.3_(1,1,1,"+i+",1,1,1,1,4,1)Input[-500,500]";
  var datosPrograma = {
    numeroAnidacionesIf: 1,
    numeroAnidacionesWhile: 1,
    numeroIteracionesWhile: 1,
    numeroAnidacionesFor: i,
    numeroIteracionesFor: 1,
    numeroCondicionesLogicas: 1,
    numeroExpresionesLogicas: 1,
    numeroExpresionesAritmeticas: 1,
    numeroExpresionesSeguidas: 4,
    listaInputsComprobacion: inputString,
    numeroFuncion: 1,
    decicionInputs: "0,"//getRandomInput(0, 1)
  }
  console.log(nombreProyecto);
  $.when(generarPrograma(datosPrograma, nombreProyecto)).done(function() {
    generadorDeProgramasAutomaticoP8_3();
  });
}
var tamPrueba = 50;
var inputString = getListaInputsInc(-500, 500);
var i = 0;
function generadorDeProgramasAutomaticoP8_4() {
  tamPrueba -= 1;
  if (tamPrueba < 0) {
    return;
  }
  i+=1;
  var nombreProyecto = "P8.4_("+i+","+i+",1,"+i+",1,1,1,1,4,1)Input[-500,500]";
  var datosPrograma = {
    numeroAnidacionesIf: i,
    numeroAnidacionesWhile: i,
    numeroIteracionesWhile: 1,
    numeroAnidacionesFor: i,
    numeroIteracionesFor: 1,
    numeroCondicionesLogicas: 1,
    numeroExpresionesLogicas: 1,
    numeroExpresionesAritmeticas: 1,
    numeroExpresionesSeguidas: 4,
    listaInputsComprobacion: inputString,
    numeroFuncion: 1,
    decicionInputs: "0,"//getRandomInput(0, 1)
  }
  console.log(nombreProyecto);
  $.when(generarPrograma(datosPrograma, nombreProyecto)).done(function() {
    generadorDeProgramasAutomaticoP8_4();
  });
}
var tamPrueba = 50;
var inputString = getListaInputsInc(-1000, 2000);
var i = 0;
function generadorDeProgramasAutomaticoP8_6() {
  tamPrueba -= 1;
  if (tamPrueba < 0) {
    return;
  }
  i+=1;
  var nombreProyecto = "P8.6_(1,1,1,1,10,1,1,1,4,1)Input[-1000,2000]";
  var datosPrograma = {
    numeroAnidacionesIf: 1,
    numeroAnidacionesWhile: 1,
    numeroIteracionesWhile: 1,
    numeroAnidacionesFor: 1,
    numeroIteracionesFor: 10,
    numeroCondicionesLogicas: 1,
    numeroExpresionesLogicas: 1,
    numeroExpresionesAritmeticas: 1,
    numeroExpresionesSeguidas: 4,
    listaInputsComprobacion: inputString,
    numeroFuncion: 1,
    decicionInputs: getListaDecision(i)//getRandomInput(0, 1)
  }
  console.log(nombreProyecto);
  $.when(generarPrograma(datosPrograma, nombreProyecto)).done(function() {
    generadorDeProgramasAutomaticoP8_6();
  });
}
var tamPrueba = 500;
var inputString = getListaInputsInc(-3000, 3000);
var i = 0;
function generadorDeProgramasAutomaticoP8_7() {
  tamPrueba -= 5;
  if (tamPrueba < 0) {
    return;
  }
  i+=5;
  console.log("<--- Iteracion " + i);
  var nombreProyecto = "P8.7_(1,1,1,1,10,1,1,1,4,1)Input[-1000,2000]";
  var datosPrograma = {
    numeroAnidacionesIf: 1,
    numeroAnidacionesWhile: 1,
    numeroIteracionesWhile: 10,
    numeroAnidacionesFor: 1,
    numeroIteracionesFor: 1,
    numeroCondicionesLogicas: 1,
    numeroExpresionesLogicas: 1,
    numeroExpresionesAritmeticas: 1,
    numeroExpresionesSeguidas: 4,
    listaInputsComprobacion: inputString,
    numeroFuncion: 1,
    decicionInputs: getListaDecision(i)//getRandomInput(0, 1)
  }
  console.log(nombreProyecto);
  $.when(generarPrograma(datosPrograma, nombreProyecto)).done(function() {
    generadorDeProgramasAutomaticoP8_7();
  });
}
var tamPrueba = 20;
var inputString = getListaInputsInc(-3000, 3000);
var i = 0;
function generadorDeProgramasAutomaticoP8_8() {
  tamPrueba -= 1;
  if (tamPrueba < 0) {
    return;
  }
  i+=1;
  console.log("<--- Iteracion " + i);
  var nombreProyecto = "P8.8_(1,1,1,"+i+",1,1,1,1,4,1)Input[-3000,3000]";
  var datosPrograma = {
    numeroAnidacionesIf: 1,
    numeroAnidacionesWhile: 1,
    numeroIteracionesWhile: 1,
    numeroAnidacionesFor: i,
    numeroIteracionesFor: 1,
    numeroCondicionesLogicas: 1,
    numeroExpresionesLogicas: 1,
    numeroExpresionesAritmeticas: 1,
    numeroExpresionesSeguidas: 4,
    listaInputsComprobacion: inputString,
    numeroFuncion: 1,
    decicionInputs: getListaDecision(i)//getRandomInput(0, 1)
  }
  console.log(nombreProyecto);
  $.when(generarPrograma(datosPrograma, nombreProyecto)).done(function() {
    generadorDeProgramasAutomaticoP8_8();
  });
}
var tamPrueba = 20;
var inputString = getListaInputsInc(-3000, 3000);
var i = 0;
function generadorDeProgramasAutomaticoP8_10() {
  tamPrueba -= 1;
  if (tamPrueba < 0) {
    return;
  }
  i+=1;
  console.log("<--- Iteracion " + i);
  var nombreProyecto = "P8.10_("+i+",1,1,1,1,1,1,1,4,1)Input[-3000,3000]";
  var datosPrograma = {
    numeroAnidacionesIf: i,
    numeroAnidacionesWhile: 1,
    numeroIteracionesWhile: 1,
    numeroAnidacionesFor: 1,
    numeroIteracionesFor: 1,
    numeroCondicionesLogicas: 1,
    numeroExpresionesLogicas: 1,
    numeroExpresionesAritmeticas: 1,
    numeroExpresionesSeguidas: 4,
    listaInputsComprobacion: inputString,
    numeroFuncion: 1,
    decicionInputs: getListaDecision(i)//getRandomInput(0, 1)
  }
  console.log(nombreProyecto);
  $.when(generarPrograma(datosPrograma, nombreProyecto)).done(function() {
    generadorDeProgramasAutomaticoP8_10();
  });
}
var tamPrueba = 30;
var inputString = getListaInputsInc(-3000, 3000);
var i = 0;
function generadorDeProgramasAutomaticoP8_11() {
  tamPrueba -= 1;
  if (tamPrueba < 0) {
    return;
  }
  i+=1;
  console.log("<--- Iteracion " + i);
  var nombreProyecto = "P8.11_(1,1,1,1,1,1,1,1,4,1)Input[-3000,3000]";
  var datosPrograma = {
    numeroAnidacionesIf: 0,
    numeroAnidacionesWhile: 0,
    numeroIteracionesWhile: 1,
    numeroAnidacionesFor: 0,
    numeroIteracionesFor: 1,
    numeroCondicionesLogicas: 1,
    numeroExpresionesLogicas: 1,
    numeroExpresionesAritmeticas: 1,
    numeroExpresionesSeguidas: 200,
    listaInputsComprobacion: inputString,
    numeroFuncion: 1,
    decicionInputs: getListaDecision(i)//getRandomInput(0, 1)
  }
  console.log(nombreProyecto);
  $.when(generarPrograma(datosPrograma, nombreProyecto)).done(function() {
    generadorDeProgramasAutomaticoP8_11();
  });
}
var tamPrueba = 30;
var inputString = getListaInputsInc(-3000, 3000);
var i = 0;
function generadorDeProgramasAutomaticoP8_12() {
  tamPrueba -= 1;
  if (tamPrueba < 0) {
    return;
  }
  i+=1;
  console.log("<--- Iteracion " + i);
  var nombreProyecto = "P8.12_(1,1,1,1,1,1,1,1,1,200)Input[-3000,3000]";
  var datosPrograma = {
    numeroAnidacionesIf: 0,
    numeroAnidacionesWhile: 0,
    numeroIteracionesWhile: 1,
    numeroAnidacionesFor: 1,
    numeroIteracionesFor: 1,
    numeroCondicionesLogicas: 1,
    numeroExpresionesLogicas: 1,
    numeroExpresionesAritmeticas: 1,
    numeroExpresionesSeguidas: 50,
    listaInputsComprobacion: inputString,
    numeroFuncion: 1,
    decicionInputs: getListaDecision(i)//getRandomInput(0, 1)
  }
  console.log(nombreProyecto);
  $.when(generarPrograma(datosPrograma, nombreProyecto)).done(function() {
    generadorDeProgramasAutomaticoP8_12();
  });
}
var tamPrueba = 10  ;
var inputString = getListaInputsInc(-3000, 3000);
var i = 0;
function generadorDeProgramasAutomaticoP8_11_2() {
  tamPrueba -= 1;
  if (tamPrueba < 0) {
    return;
  }
  i+=1;
  console.log("<--- Iteracion " + i);
  var nombreProyecto = "P8.11_2(0,0,1,0,1,1,1,1,4,1)Input[-3000,3000]";
  var datosPrograma = {
    numeroAnidacionesIf: 0,
    numeroAnidacionesWhile: 0,
    numeroIteracionesWhile: 1,
    numeroAnidacionesFor: 0,
    numeroIteracionesFor: 1,
    numeroCondicionesLogicas: 1,
    numeroExpresionesLogicas: 1,
    numeroExpresionesAritmeticas: 1,
    numeroExpresionesSeguidas: 4,
    listaInputsComprobacion: inputString,
    numeroFuncion: 1,
    decicionInputs: getListaDecision(i)//getRandomInput(0, 1)
  }
  console.log(nombreProyecto);
  $.when(generarPrograma(datosPrograma, nombreProyecto)).done(function() {
    generadorDeProgramasAutomaticoP8_11_2();
  });
}

var tamPrueba = 10  ;
var inputString = getListaInputsInc(-3000, 3000);
var i = 0;
function generadorDeProgramasAutomaticoP9_1() {
  tamPrueba -= 1;
  if (tamPrueba < 0) {
    return;
  }
  i+=1;
  console.log("<--- Iteracion " + i);
  var nombreProyecto = "P9.1(0,0,1,0,1,1,1,1,4,1)Input[-3000,3000]";
  var datosPrograma = {
    numeroAnidacionesIf: 0,
    numeroAnidacionesWhile: 0,
    numeroIteracionesWhile: 1,
    numeroAnidacionesFor: 0,
    numeroIteracionesFor: 1,
    numeroCondicionesLogicas: 1,
    numeroExpresionesLogicas: 1,
    numeroExpresionesAritmeticas: 1,
    numeroExpresionesSeguidas: 4,
    listaInputsComprobacion: inputString,
    numeroFuncion: 1,
    decicionInputs: getListaDecision(i)//getRandomInput(0, 1)
  }
  console.log(nombreProyecto);
  $.when(generarPrograma(datosPrograma, nombreProyecto)).done(function() {
    generadorDeProgramasAutomaticoP9_1();
  });
}
