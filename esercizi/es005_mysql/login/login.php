<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Secret page</title>

    
</head>
<body>
    <?php
        if(isset($_POST["usr"]) && isset($_POST["pwd"])){

            //prendo le credenziali
            $usr = $_POST["usr"];
            $pwd = $_POST["pwd"];

            //connessione al db
			$con = new mysqli('localhost','root','','agenziaMatrimoniale');
			if ($con->connect_error)    //controllo errori di connessione
				die("Error: Failed to connect to DB: ".$con->connect_errno . " - ". $con->connect_error);
                
                    
			$sql="SELECT nickname,password,amministratore FROM utenti  WHERE nickname = '$usr' && password = '$pwd' ";   //cerco nome utente e password
			$ok = $con->query($sql);    //eseguo la query
            
            
			if($ok && $record = $ok->fetch_assoc()){   //l'utente esiste e le credenziali sono corrette
                //AVVIO SESSIONE
                session_start();

                //copio informazioni
                $_SESSION['utente'] = $record['nickname'];
                $_SESSION['amministratore'] = $record['amministratore'];
                
                //controllo sull'amministratore
                if ($record['amministratore'] == 1){
                    //carico pagina amministratore
                    
                    header('location:/Esercizi/es005_mysql/login/amministratore.php');
                    echo($record['amministratore']);
                }else{
                    //carico pagina utente
                    header('location:/Esercizi/es005_mysql/login/utente.php');
                }
			} else {    //messaggio di errore
				echo("<label style='color:red'>Password o Username non validi</label>");
            }
                
            $con->close();
        }else{
            echo("<label style='color:red'>Inserisci username e password</label>");
        }


    ?>
</body>
</html>