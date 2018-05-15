function getListaDecision(numFuncion) {
  var lista = "";
  for (var i = 1; i < numFuncion; i++) {
    lista += "0,"
  }
  return lista;
}

function getListaInputs(min, max, tamLista) {
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
