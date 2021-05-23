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
			try {				
				$con = new PDO("sqlite:./agenziamatrimoniale.db");
				//$con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
				$istruzione = "SELECT id, nome, sesso, nickname, password, amministrazione FROM utenti WHERE nickname = '" . $usr . "' AND password = '" . $pwd . "';";
				$stmt = $con->prepare($istruzione);
				$stmt->execute();  //eseguo la query		
				$row = $stmt->fetch(PDO::FETCH_ASSOC);				
				//$totale = $stmt->rowCount(); rowCount() function doesn't work for SQLite
				//rowCount() is only really safe to use on MySQL and a few others.
				//if($totale > 0){
				if ($row){  //if ($row && count($row)){
					//AVVIO SESSIONE
					session_start();							
					$_SESSION['idUtente'] = $row['id'];
					$_SESSION['nomeUtente'] = $row['nome'];
					$_SESSION['sessoUtente'] = $row['sesso'];
					$_SESSION['nicknameUtente'] = $row['nickname'];
					$_SESSION['amministrazione'] = $row['amministrazione'];

					if($_SESSION['amministrazione'] == 1){
						header("location: admin.php");  //renderizza alla home
				    
					}else{
						header("location: utente.php");  //renderizza alla home
                    }				
				}else{
					die("Password o Username non validi");
				}
				$stmt->closeCursor(); //in MySQL è inessenziale
				$con = NULL; //chiudo connessione
			} catch(PDOException $e) { //controllo errori di connessione
				echo "Error: Failed to connect to DB: " . $e->getMessage();
				die();
			}
        }else{
            echo("<label style='color:red'>Inserisci username e password</label>");
        }
    ?>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>