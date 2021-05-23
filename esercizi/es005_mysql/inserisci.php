<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Es05 mysql</title>
		
		<!-- text/javascript è uno standar vecchio 
			siccome javascript è un linguaggio si è deciso di deprecarlo
			e si è deciso di introdurre application/javascript
		-->
		<script type="application/javascript">
			function controllo(){
				var ok=true;
				var vet = document.getElementsByTagName("input");
				
				for(var i=0;i<vet.length; i++){
					if(vet[i].value==""){
						ok=false;
						break;
					}
				}
				
				if(!ok)
				{
					//Messaggio di errore
					var msg = document.getElementById("txtMessaggio");
					
					msg.innerHTML = "Errore: campi non compilati";
					msg.style.color="red";
				}
				else{
					var frm = document.getElementById("frm");
					frm.method="post";
					frm.action="inserisci.php?azione=salva";
					frm.submit();
				}
			}
		</script>
	</head>
	<body>
		<h1>Inserimento nuova marca</h1>
		<form id="frm">
			<label>Nome:<input type="text" name="txtNome" placeholder="Inserisci qui il nome"/></label>
			</br>
			<label>Nazione:<input type="text" name="txtNazione"/></label>
			</br>
			<button type="button" onClick="controllo()">Salva</button>
		</form>
		<div id="txtMessaggio"></div>
		
		<?php
			if($_GET["azione"] == "salva"){
				$nome=$_POST["txtNome"];
				$nazione=$_POST["txtNazione"];
				
				$con = new mysqli('localhost','root','','dbautomobili');
				if ($con->connect_error)
					die("Error: Failed to connect to DB: ".$con->connect_errno . " - ". $con->connect_error);
				
				$sql="INSERT INTO marche(nome,nazione) VALUES ('$nome','$nazione')";
				$ok = $con->query($sql);
				$con->close();
				
				if($ok){
					echo("<h1>Inserimento avvenuto con successo<h1>");
					header("location:/Esercizi/Es08_mysql/index.php");
				} else {
					die("Errore ".$con->errno . " - ".$con->error);
				}
			}
		?>
	</body>
</html>