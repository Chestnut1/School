<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Es05 mysql</title>
	</head>
	<body>
		<?php
			if (isset($_REQUEST["pulsante"]) && is_numeric($_REQUEST["pulsante"]))
				$id = $_REQUEST["pulsante"];
			else
				die("Parametro mancante");
			
			$con = new mysqli('localhost','root','','dbautomobili');
			if ($con->connect_error)
				die("Error: Failed to connect to DB: ".$con->connect_errno . " - ". $con->connect_error);
			
			$nome = $_REQUEST["txtNome".$id];
			$nazione = $_REQUEST["txtNazione".$id];
			
			$sql="UPDATE marche SET nome = '$nome', nazione='$nazione' WHERE id=$id";
			$ok = $con->query($sql);
			if($ok){
				echo("<h1>Salvataggio avvenuto con successo<h1>");
				//mettere temporizzazione di 3 secondi
				header("location:/Esercizi/Es08_mysql/index.php");
			}
			else
				echo("<h1>Errore salvataggio record<h1>");
			
		?>
	</body>
</html>