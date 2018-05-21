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
    if (nombreAtr.includes("AnidIf"))
        return  'color: #FF5733';

    if (nombreAtr.includes("AnidWhile_"))
        return  'color: #FFA233';

    if (nombreAtr.includes("IterWhile_"))
        return  'color: #FFD433';

    if (nombreAtr.includes("AnidFor_"))
        return  'color: #87283E';
    if (nombreAtr.includes("IterFor_"))
        return  'color: #FA114A';

    if (nombreAtr.includes("CondLog_"))
        return  'color: #BBFF33';

    if (nombreAtr.includes("ExprLog_"))
        return  'color: #68FF33';

    if (nombreAtr.includes("ExprArit_"))
        return  'color: #42CD6A';

    if (nombreAtr.includes("ExprsSeg_"))
        return  'color: #42CDA9';

    if (nombreAtr.includes("NumFun_"))
        return  'color: #9E11FA';

    if (nombreAtr.includes("SizeTests"))
        return  'color: #42AFCD';

    if (nombreAtr.includes("IfsAniCuerpoBucle"))
        return  'color: #428ACD';

    if (nombreAtr.includes("Aleatorio"))
        return  'color: #4260CD';

    if (nombreAtr.includes("Fin"))
          return  'color: #428acd';

    if (nombreAtr.includes("Ini"))
        return  'color: #1299F7';


    return 'color: #000000';

  }
