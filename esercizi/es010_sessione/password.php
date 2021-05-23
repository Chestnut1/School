<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Esercizio Login con sessione PHP - parte 3</title>
	</head>
	<body>
		<h1>Cambio password</h1>
		<form>
			<label>
				Vecchia password:
				<input type = 'text' name='txtVecchia'/>
			</label>
			</br>
			<label>
				Nuova password:
				<input type = 'password' name='txtNuova'/>
			</label>
			</br>
			<button type='submit' formmethod='post'>Cambia</button>
		</form>
		<?php
			if ($_SERVER['REQUEST_METHOD'] == 'POST'){
				$con = new mysqli('localhost','root','','dbbanche');
				if ($con->connect_error)
					die("Error: Failed to connect to DB: ".$con->connect_errno . " - ". $con->connect_error);
				$vecchia = $con->real_escape_string($_POST["txtVecchia"]);
				$nuova = $con->real_escape_string($_POST["txtNuova"]);
				session_start();
				$id = $_SESSION["utente"];
				
				$sql="SELECT Pwd FROM correntisti WHERE cCorrentista=$id";
				$rs=$con->query($sql);
				if(!$rs)
					die("Error: Failed to execute query:".$con->connect_errno . " - ". $con->connect_error);
				
				$record = $rs->fetch_assoc();
				$pwd = $record["Pwd"];
				if ($pwd=="" || $vecchia==$pwd){
					$sql = "update Correntisti SET Pwd = '$nuova' WHERE cCorrentista=$id";
					$rs=$con->query($sql);
					if(!$rs)
						die("Error: Failed to execute query:".$con->connect_errno . " - ". $con->connect_error);
					else
						header('location:/Esercizi/Es14_LoginBanche/');
				}
				else echo("Impossibile aggiornare la password");
			}
		?>
	</body>
</html>