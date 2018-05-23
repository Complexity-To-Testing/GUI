function getListaDecision(numFuncion) {
  var lista = "";
  for (var i = 1; i < numFuncion; i++) {
    lista += "0,"
  }
  return lista;
}

function getListaAleatorioInputs(min, max, tamLista) {
  var lista = "";
  for (var i = 0; i < tamLista + 1; i++) {
    lista+=(Math.random() * (max - min) + min)+",";
  }
  return lista;
}
function getListaInputsInc(inicioLista, tamLista) {
  var lista = "";
  for (var i = inicioLista; i < tamLista + 1; i++) {
    lista+=i+","; //(Math.random() * (max - min) + min)+",";
  }
  return lista;
}
function getRandomInput(min, max) {
  return (Math.random() * (max - min) + min)+","
}

function getAtrAleatorio(){
  var checkBox = document.getElementById("checkAtrAleatorio");
    if (checkBox.checked == true){
      return 1;
    } else {
      return 0;
    }
}

function getChecksMutantes(){
    var listaMutantes = "";
    if (document.getElementById("INCREMENTS").checked == true){
      listaMutantes += "0 "
    }
    if (document.getElementById("MATH").checked == true){
      listaMutantes += "1 "
    }
    if (document.getElementById("CONDITIONALS_BOUNDARY").checked == true){
      listaMutantes += "2 "
    }
    if (document.getElementById("NEGATE_CONDITIONALS").checked == true){
      listaMutantes += "3 "
    }
    if (document.getElementById("INVERT_NEGS").checked == true){
      listaMutantes += "4 "
    }
    if (document.getElementById("RETURN_VALS").checked == true){
      listaMutantes += "5 "
    }
    if (document.getElementById("VOID_METHOD_CALLS").checked == true){
      listaMutantes += "6 "
    }
    if (document.getElementById("CONSTRUCTOR_CALLS").checked == true){
      listaMutantes += "7 "
    }
    if (document.getElementById("INLINE_CONSTS").checked == true){
      listaMutantes += "8 "
    }
    if (document.getElementById("NON_VOID_METHOD_CALLS").checked == true){
      listaMutantes += "9 "
    }
    if (document.getElementById("REMOVE_CONDITIONALS").checked == true){
      listaMutantes += "10 "
    }
    if (document.getElementById("EXPERIMENTAL_MEMBER_VARIABLE").checked == true){
      listaMutantes += "11 "
    }
    if (document.getElementById("EXPERIMENTAL_SWITCH").checked == true){
      listaMutantes += "12 "
    }
    return listaMutantes;
}
function getChecksMutantes1(){
    var listaMutantes = "";
    if (document.getElementById("INCREMENTS1").checked == true){
      listaMutantes += "0 "
    }
    if (document.getElementById("MATH1").checked == true){
      listaMutantes += "1 "
    }
    if (document.getElementById("CONDITIONALS_BOUNDARY1").checked == true){
      listaMutantes += "2 "
    }
    if (document.getElementById("NEGATE_CONDITIONALS1").checked == true){
      listaMutantes += "3 "
    }
    if (document.getElementById("INVERT_NEGS1").checked == true){
      listaMutantes += "4 "
    }
    if (document.getElementById("RETURN_VALS1").checked == true){
      listaMutantes += "5 "
    }
    if (document.getElementById("VOID_METHOD_CALLS1").checked == true){
      listaMutantes += "6 "
    }
    if (document.getElementById("CONSTRUCTOR_CALLS1").checked == true){
      listaMutantes += "7 "
    }
    if (document.getElementById("INLINE_CONSTS1").checked == true){
      listaMutantes += "8 "
    }
    if (document.getElementById("NON_VOID_METHOD_CALLS1").checked == true){
      listaMutantes += "9 "
    }
    if (document.getElementById("REMOVE_CONDITIONALS1").checked == true){
      listaMutantes += "10 "
    }
    if (document.getElementById("EXPERIMENTAL_MEMBER_VARIABLE1").checked == true){
      listaMutantes += "11 "
    }
    if (document.getElementById("EXPERIMENTAL_SWITCH1").checked == true){
      listaMutantes += "12 "
    }
    return listaMutantes;
}
function getColorColumnAtr(nombreAtr) {

    if (nombreAtr.includes("AnidIf")&&nombreAtr.includes("AnidWhile")){
      return  'color:    #e6b0aa';
    } else if (nombreAtr.includes("AnidIf")&&nombreAtr.includes("IterWhile")){
      return  'color:   #d7bde2  ';
    }else if (nombreAtr.includes("AnidIf")&&nombreAtr.includes("AnidFor")){
      return  'color:  #a9cce3 ';
    }else if (nombreAtr.includes("AnidIf")&&nombreAtr.includes("IterFor")){
      return  'color:   #a3e4d7  ';
    }else if (nombreAtr.includes("AnidIf")&&nombreAtr.includes("CondLog")){
      return  'color:  #f9e79f ';
    }else if (nombreAtr.includes("AnidIf")&&nombreAtr.includes("ExprLog")){
      return  'color:  #f5cba7 ';
    }else if (nombreAtr.includes("AnidIf")&&nombreAtr.includes("ExprArit")){
      return  'color:  #d5dbdb ';
    }else if (nombreAtr.includes("AnidIf")&&nombreAtr.includes("ExprsSeg")){
      return  'color:  #abb2b9 ';

    } else if (nombreAtr.includes("AnidFor")&&nombreAtr.includes("AnidIf")){
      return  'color:    #c0392b ';
    } else if (nombreAtr.includes("AnidFor")&&nombreAtr.includes("AnidWhile")){
      return  'color:     #9b59b6  ';
    } else if (nombreAtr.includes("AnidFor")&&nombreAtr.includes("IterWhile")){
      return  'color:    #9b59b6   ';
    }else if (nombreAtr.includes("AnidFor")&&nombreAtr.includes("IterFor")){
      return  'color:    #1abc9c   ';
    }else if (nombreAtr.includes("AnidFor")&&nombreAtr.includes("CondLog")){
      return  'color:   #f1c40f  ';
    }else if (nombreAtr.includes("AnidFor")&&nombreAtr.includes("ExprLog")){
      return  'color:   #e67e22  ';
    }else if (nombreAtr.includes("AnidFor")&&nombreAtr.includes("ExprArit")){
      return  'color:   #7f8c8d  ';
    }else if (nombreAtr.includes("AnidFor")&&nombreAtr.includes("ExprsSeg")){
      return  'color:   #34495e   ';

    } else if (nombreAtr.includes("AnidWhile")&&nombreAtr.includes("AnidIf")){
      return  'color:     #CCFFFF  ';
    } else if (nombreAtr.includes("AnidWhile")&&nombreAtr.includes("AnidFor")){
      return  'color:     #CCCCFF   ';
    } else if (nombreAtr.includes("AnidWhile")&&nombreAtr.includes("IterWhile")){
      return  'color:     #CC99FF    ';
    }else if (nombreAtr.includes("AnidWhile")&&nombreAtr.includes("IterFor")){
      return  'color:     #CC33FF     ';
    }else if (nombreAtr.includes("AnidWhile")&&nombreAtr.includes("CondLog")){
      return  'color:     #6699FF    ';
    }else if (nombreAtr.includes("AnidWhile")&&nombreAtr.includes("ExprLog")){
      return  'color:     #66CCFF    ';
    }else if (nombreAtr.includes("AnidWhile")&&nombreAtr.includes("ExprArit")){
      return  'color:    #66FFFF   ';
    }else if (nombreAtr.includes("AnidWhile")&&nombreAtr.includes("ExprsSeg")){
      return  'color:    #0099FF    ';
    } else  if (nombreAtr.includes("AnidIf")){
      return  'color: #FF5733';
    } else if (nombreAtr.includes("AnidWhile")){
      return  'color: #FFA233 ';
    }else if (nombreAtr.includes("IterWhile")){
      return  'color: #FFD433';
    }else if (nombreAtr.includes("AnidFor")){
      return  'color: #87283E';
    }else if (nombreAtr.includes("CondLog")){
      return  'color: #BBFF33';
    }else if (nombreAtr.includes("ExprLog")){
      return  'color: #68FF33';
    }else if (nombreAtr.includes("ExprArit")){
      return  'color: #42CD6A';
    }else if (nombreAtr.includes("ExprsSeg")){
      return  'color: #42CDA9';
    }else if (nombreAtr.includes("NumFun")){
      return  'color: #9E11FA';
    }else if (nombreAtr.includes("SizeTests")){
      return  'color: #42AFCD';
    }else if (nombreAtr.includes("IfsAniCuerpoBucle")){
      return  'color: #428ACD';
    }else if (nombreAtr.includes("Aleatorio")){
      return  'color: #4260CD';
    }else if (nombreAtr.includes("Fin")){
      return  'color: #428acd';
    }else if (nombreAtr.includes("Ini")){
      return  'color: #1299F7';
    } else {
      return 'color: #000000';
    }
  }
