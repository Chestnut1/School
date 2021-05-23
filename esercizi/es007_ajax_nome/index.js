/* uso una chiamata asincrona per non bloccare la UI */
var richiesta;
function verifica(){
    var nome=document.getElementById("txtNome").value;
    var parametri="txtNome=" + encodeURIComponent(nome);
    var url="controlla.php?"+parametri;
    richiesta = new XMLHttpRequest();
    richiesta.open("GET", url, true); //true=chiamata asincrona
    //i parametri sono passati in formato url-encoded
    richiesta.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
    richiesta.onreadystatechange = aggiorna; //callback per ajax asincrono
    richiesta.send(null); //invece di null potrei mettere una stringa
                          //di parametri POST in formato url-encoded
}

function aggiorna() {
    if (richiesta.readyState==4 && richiesta.status==200) 
    {
		var txt = document.getElementById("txtNome");
		if (richiesta.responseText == "Ok") 
            txt.style.color = "green";
        else
            txt.style.color = "red";
    }
}