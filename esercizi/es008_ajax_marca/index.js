var richiesta;

function richiediDettagli(){
	var id = document.getElementById("lstMarche").value;
	
	richiesta = new XMLHttpRequest();
	//se l'url comincia con uno / cerca in htdocs altrimenti nella cartella corrente
	
	var url="dettagli.php";	
	richiesta.open("post", url, true);
	
	// va bene se non si devono inviare caratteri particolari e dati in formato binario (upload)
	richiesta.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
	 
	richiesta.onreadystatechange = aggiorna;
	richiesta.send("id=" + encodeURIComponent(id));
}

function aggiorna() {
	if (richiesta.readyState==4 && richiesta.status==200) 
	{
		var risposta = richiesta.responseText;
		if(risposta.substr(0,5) == "Error")
			alert(risposta);
		else
		{
			var json = JSON.parse(risposta); //parsificare in javascript
			//json è un vettore di record che contiene un unico record
			if(json.length==1)
			{
				var marca = json[0]; //$riga
				document.getElementById("txtID").innerHTML = marca["id"];
				document.getElementById("txtNome").innerHTML = marca.nome;
				document.getElementById("txtNazione").innerHTML = marca["nazione"];
				document.getElementById("dettagli").style.visibility = "visible";
			}
			else if(json.length == 0)
				alert("Nessuno record trovato");
			else
				alert("Dati non validi");
		}
	}
}