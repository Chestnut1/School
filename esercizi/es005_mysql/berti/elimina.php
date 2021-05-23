<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Es05 mysql</title>
	</head>
	<body>
		<?php
			//controlla se ho passato nell'URL l'id e controlla se e' un numero
			if (isset($_REQUEST["pulsante"]) && is_numeric($_REQUEST["pulsante"]))
				$id = $_REQUEST["pulsante"];
			else
				die("Parametro mancante");
			
			//connessione al db
			$con = new mysqli('localhost','root','','dbautomobili');
			if ($con->connect_error)
				die("Error: Failed to connect to DB: ".$con->connect_errno . " - ". $con->connect_error);
			//esegue la query
			$sql="DELETE FROM marche WHERE id = $id";
			$ok = $con->query($sql);	//vale la riga eliminata. Quindi se ha qualche valore l'operazione e' riuscita
			if($ok){
				//echo("<h1>Cancellazione avvenuta con successo<h1>");
				header("location:/Esercizi/es005_mysql/berti/index.php");
			}
			else
				echo("<h1>Errore cancellazione record<h1>");
		?>
	</body>
</html>