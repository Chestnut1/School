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
	$query1 = $con->prepare("SELECT COUNT(*) AS rowcount FROM Personaggi");
	$query1->execute();
	$num = $query1->fetch(PDO::FETCH_ASSOC);	//alternativa FETCH_NUM e poi isare $num[0]
	
	echo "Numero di righe:" . $num['rowcount'] . "<br>";

	//scrittura sul file
	if($num['rowcount'] == 0){	//controllo sul numero di righe
		die("La tabella dei personaggi è vuota !");
	}else{
		$query2 = $con->prepare("SELECT * FROM Personaggi");
		$query2->execute();  //eseguo la query
		$res = $query2->fetchall();

        //var_dump($res);
        
        foreach($res as $key=>$row){	//ciclo per ogni riga, $key->$row (numero iterazione) -> (riga)
            echo $key . "<br>";
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