function addZero(x, n) {
  while (x.toString().length < n) {
    x = "0" + x;
  }
  return x;
}


window.onload = function(){
  var fecha = new Date(); //Fecha actual
  var mes = fecha.getMonth()+1; //obteniendo mes
  var dia = fecha.getDate(); //obteniendo dia
  var ano = fecha.getFullYear(); //obteniendo año
  if(dia<10)
    dia='0'+dia; //agrega cero si el menor de 10
  if(mes<10)
    mes='0'+mes //agrega cero si el menor de 10
  document.getElementById('hoy').value=ano+"-"+mes+"-"+dia;
  document.getElementById('estado').value="Nuevo";
  var valor = document.getElementById('id_recivido').value;
  document.getElementById('id_enviado').value = valor;
  
  
  
  var d = new Date();
  var x = document.getElementById("id_recivido").value;
  var h = addZero(d.getHours(), 1);
  var m = addZero(d.getMinutes(), 1);
  var s = addZero(d.getSeconds(), 1);
 // var ms = addZero(d.getMilliseconds(), 3);
 
  document.getElementById('foliono').value =  x + "-" + h + m + s ;
}


