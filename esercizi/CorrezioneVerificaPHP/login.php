<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="icon" type="image/png" href="img/login.png"/>
</head>
<body>
    <?php
        if(isset($_POST["usr"]) && isset($_POST["pwd"])){

            //prendo le credenziali
            $usr = $_POST["usr"];
            $pwd = $_POST["pwd"];

            //connessione al db
			$con = new mysqli('localhost','root','','agenziamatrimoniale');
			if ($con->connect_error)    //controllo errori di connessione
				die("Error: Failed to connect to DB: ".$con->connect_errno . " - ". $con->connect_error);
                
                    
			$sql="SELECT id, nome, sesso, nickname, password, amministrazione FROM utenti  WHERE nickname = '$usr' && password = '$pwd' ";   //cerco nome utente e password
			$ok = $con->query($sql);    //eseguo la query

			if($ok && $record = $ok->fetch_assoc()){   //l'utente esiste e le credenziali sono corrette

                //AVVIO SESSIONE
                session_start();

                //copio il nome utente 
                $_SESSION['idUtente'] = $record['id'];
                $_SESSION['nomeUtente'] = $record['nome'];
                $_SESSION['sessoUtente'] = $record['sesso'];
                $_SESSION['nicknameUtente'] = $record['nickname'];
                $_SESSION['amministrazione'] = $record['amministrazione'];

                if($record['amministrazione'] == 1){
                    header("location: admin.php");  //renderizza alla home
               
                }else{
                    header("location: utente.php");  //renderizza alla home
                    
                }


			} else {    //messaggio di errore
				echo("<label style='color:red'>Password o Username non validi</label>");
            }
                
            $con->close();
        }else{
            echo("<label style='color:red'>Inserisci username e password</label>");
        }
    ?>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>