<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>PHP</title>
</head>

<body>
	<h1>Esito upload</h1>
    <?php
		//print_r($_FILES); //$_FILE contiene i file ricevuti e tutte le loro informazioni
		if ($_FILES["txtFile"]["error"] == UPLOAD_ERR_OK) {
			$fileRicevuto=$_FILES["txtFile"];
            //$fileRicevuto["name"] restituisce il path completo del file ricevuto
            //basename restituisce il vero nome contenuto dopo l'ultimo slash
            //$target_file rappresenta il percorso dove salvare il file sul server
            $target_file = "Uploads/" . basename($fileRicevuto["name"]);
            $size=$fileRicevuto["size"];
            $mimeType=$fileRicevuto["type"];
            echo("Nome file: $target_file<br>");
            echo("Dimensione: $size<br>");
            echo("MIME type: $mimeType<br><br>");
            if(file_exists($target_file))
                echo("Attenzione il file esiste già.<br>");
            else
            {
                echo("I dati contenuti nel file sono stati caricati correttamente nel DB.<br><br>");
                $con = new PDO("sqlite:agenziamatrimoniale.db");
                $con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);				
                $command = $con->prepare("INSERT INTO utenti (nome, sesso, eta, altezza, peso, nickname, password) VALUES (:nome, :sesso, :eta, :altezza, :peso, :nickname, '12345')");
				$utenti = file( $_FILES["txtFile"]["tmp_name"], FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
				//var_dump($utenti);
				foreach ($utenti as $utente) {
                    //$protocollo = split(trim($linea), ":")[0];   
                    //var_dump($utente);
                    $values = explode("," , $utente);
                    

					$command->bindParam(":nome", $values[0], PDO::PARAM_STR);
					$command->bindParam(":sesso", $values[1], PDO::PARAM_STR);
					$command->bindParam(":eta", $values[2], PDO::PARAM_STR);
					$command->bindParam(":altezza", $values[3], PDO::PARAM_STR);
					$command->bindParam(":peso", $values[4], PDO::PARAM_STR);
					$command->bindParam(":nickname", $values[5], PDO::PARAM_STR);

					if($command->execute())
					    echo " L'utente $utente &egrave; stato aggiunto al database.<br>";
					else
						echo " Errore: l'utente $utente NON &egrave; stato aggiunto al database.<br>";
				}
				move_uploaded_file($fileRicevuto["tmp_name"], $target_file);
				echo "<br>Il file uploadato ora si trova nella sottodirectory Upload.<br><hr>";
				//oppure eliminare il file una volta caricati i dati
				//unlink($fileRicevuto["tmp_name"]);
			}
        }
    ?>
    <a href="admin.php">HOME ADMIN</a>
</body>

</html>