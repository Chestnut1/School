<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<?php
	    $servername = "localhost";
		$username = "root";
		$password = "";
        if(isset($_POST["username"]) && isset($_POST["password"])){
            //prendo le credenziali
            $usr = $_POST["username"];
            $pwd = $_POST["password"];

            //connessione al db
			try {				
				$con = new PDO("mysql:host=$servername;dbname=chat", $username, $password);
				$con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);


				$istruzione="SELECT id, password, nome, cognome, email, nascita FROM users WHERE nickname = '" . $usr . "' ";
				$stmt = $con->prepare($istruzione);
				$stmt->execute();  //eseguo la query
				$row = $stmt->fetch(PDO::FETCH_ASSOC);
				$totale = $stmt->rowCount();

				if($totale==0 or $pwd != $row['password']){
					die("Password o Username non validi");
				}else{
					//AVVIO SESSIONE
					session_start();							
					$_SESSION['id'] = $row['id'];
					$_SESSION['nome'] = $row['nome'];
					$_SESSION['cognome'] = $row['cognome'];
					$_SESSION['email'] = $row['email'];
					$_SESSION['nascita'] = $row['nascita'];

					
					header("location: chat.html");  //renderizza alla hat			
				}
				//$stmt->closeCursor(); in MySQL è inessenziale
				$con = NULL; //chiudo connessione
			} catch(PDOException $e) { //controllo errori di connessione
				echo "Error: Failed to connect to DB: " . $e->getMessage();
				die();
			}
        }else{
            echo("<label style='color:red'>Inserisci username e password</label>");
        }
    ?>
</body>
</html>