<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Esercizio Login con sessione PHP - parte 1</title>
		<script type="application/javascript">
			
		</script>
	</head>
	<body>
		<h1>Login</h1>
		<form method="post" action="index.php">
			<label>Username:<input type="text" id="txtUser" name="txtUser"/></label>
			</br>
			<label>Password:<input type="password" id="txtPwd" name="txtPwd"/></label>
			</br>
			</br>
			<input type="submit" value="Invia"/>
		</form>
		<?php
			// Se � settato significa che � stato premuto submit
			if (isset($_POST["txtUser"])){
				//concede alla pagina di accedere alle variabili di sessione
				session_start();
				$con = new mysqli('localhost','root','','credenziali');
				if ($con->connect_error)
					die("Error: Failed to connect to DB: ".$con->connect_errno . " - ". $con->connect_error);

				if (controlla($con,$_POST["txtUser"])){
					$user=$_POST["txtUser"];
					if (controlla($con,$_POST["txtPwd"])){
						$pwd=$_POST["txtPwd"];
						$sql = "SELECT * FROM utenti WHERE pwd='$pwd' AND usr='$user'";
						$rs = $con->query($sql);
						if (!$rs)
							die("Error: Failed to execute query:".$con->connect_errno . " - ". $con->connect_error);
						$num = $rs->num_rows;
						if ($num==1){
							$record = $rs->fetch_assoc();
							$id = $record["id"];
							$_SESSION["utente"]=$id;
							//echo ("OK");
							header('location:/Esercizi/es010_sessione/filiali.php');
						}
						else
							echo("<label style='color:red'>Password o Username non validi</label>");
					}
					else
						echo("<label style='color:red'>Password non valida</label>");
				}
				else
					echo("<label style='color:red'>Username non valida</label>");
			}
			
			function controlla($con,&$s){
				$s = $con->real_escape_string($s);
				if ($s == "")
					return false;
				else
					return true;
			}
		?>
	</body>
</html>