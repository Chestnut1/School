<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Scrittura file PHP</title>
</head>

<body>
<?php
try {
	//connessione al DB con PDO
	$con = new PDO("sqlite:./Disneyland.db");	//altri driver: mysql, oracleDB, MariaDB
	$con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	
	//apro il file in scrittura
	try {
		$myfile = fopen("output.csv", "w") or die("Unable to open file!");  		
		echo "File creato.<br>";
	} catch (Exception $e) {
		echo $e->getMessage();
	}

	//prendo il numero di righe
	$stmt2 = $con->prepare("SELECT COUNT(*) AS rowcount FROM Personaggi");
	$stmt2->execute();
	$num = $stmt2->fetch(PDO::FETCH_ASSOC);	//alternativa FETCH_NUM e poi isare $num[0]
	
	echo "Numero di righe:" . $num['rowcount'] . "<br>";

	//scrittura sul file
	if($num['rowcount'] == 0){	//controllo sul numero di righe
		die("La tabella dei personaggi è vuota !");
	}else{
		$stmt1 = $con->prepare("SELECT * FROM Personaggi");
		$stmt1->execute();  //eseguo la query
		while($row = $stmt1->fetch(PDO::FETCH_ASSOC)){	//ciclo per ogni riga
			
			$nome = trim($row['Nome']);	//trim() elimina spazi bianchi prima e dopo
			$prov = trim($row['Prov']);

			fwrite($myfile, $nome . ", " . $prov . "\n");	//scrivo linea sul file
		}
	}

	fclose($myfile);	//chiudo file
	$con = NULL; //chiudo connessione
	echo "<br>Connessioni terminate.<br>";

} catch (PDOException $e){
	die("Errore nella connessione PDO: " . $e->getMessage());
} catch (Exception $e){
	die("Errore: " . $e->getMessage());
}
?>
</body>