<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Scrittura file PHP</title>
</head>

<body>
<?php
try {
    session_start();
	//connessione al DB con PDO
	$con = new PDO("sqlite:./agenziamatrimoniale.db");	//altri driver: mysql, oracleDB, MariaDB
	$con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	
	//apro il file in scrittura
	try {
		$myfile = fopen("esportazione_abbinamenti_admin.csv", "w") or die("Unable to open file!");  		
		echo "File creato.<br>";
	} catch (Exception $e) {
		echo $e->getMessage();
	}

    //controllo il sesso dell'utente
    if ($_SESSION['sessoUtente'] == 0) {
        $istruzione1 = 'SELECT count(*) AS nAbb FROM utenti INNER JOIN abbinamenti ON utenti.id = abbinamenti.idUtente2 WHERE abbinamenti.idUtente1 = '. $_SESSION['idUtente'];
        $istruzione2 = 'SELECT utenti.*, abbinamenti.id AS idAbb, abbinamenti.giudizio1 FROM utenti INNER JOIN abbinamenti ON utenti.id = abbinamenti.idUtente2 WHERE abbinamenti.idUtente1 = ' . $_SESSION['idUtente'];
    } else {
        $istruzione1 = 'SELECT count(*) AS nAbb FROM utenti INNER JOIN abbinamenti ON utenti.id = abbinamenti.idUtente1 WHERE abbinamenti.idUtente2 = '. $_SESSION['idUtente'];
        $istruzione2 = 'SELECT utenti.*, abbinamenti.id AS idAbb, abbinamenti.giudizio2 FROM utenti INNER JOIN abbinamenti ON utenti.id = abbinamenti.idUtente1 WHERE abbinamenti.idUtente2 = ' . $_SESSION['idUtente'];
    }

    // eseguo la query per il numero di righe
    $result = $con->query($istruzione1);
    $nAbb=0;
    if ($row = $result->fetch(PDO::FETCH_OBJ))
            $nAbb=$row->nAbb;
    echo "Numero abbinamenti: " . $nAbb;

    if ($nAbb > 0){ 
        $result->closeCursor();
        $stmt = $con->prepare($istruzione2);
        $stmt->execute();  //eseguo la query
        while($record = $stmt->fetch(PDO::FETCH_ASSOC)){

            if ($_SESSION['sessoUtente'] == 0) {
                fwrite($myfile, $record["nome"] . ", " . $record["eta"] .  $record["peso"] . $record["giudizio1"] . "\n");	//scrivo linea sul file
            }else {
                fwrite($myfile, $record["nome"] . ", " . $record["eta"] .  $record["peso"] . $record["giudizio2"] ."\n");	//scrivo linea sul file
            }		
            
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