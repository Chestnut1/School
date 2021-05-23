<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Esercizio Login con sessione PHP - parte 2</title>
		<script type="application/javascript">
			function creaTabella(){
				var frm= document.getElementById("frm");
				
				frm.method="post";
				frm.action="filiali.php";
				frm.submit();
			}
			function esci(){
				var frm= document.getElementById("frm");
				
				frm.method="post";
				frm.action="filiali.php?esci";
				frm.submit();
			}
		</script>
	</head>
	<body>
		<h1>Elenco Filiali</h1>
		<?php
			session_start();
			if (!isset($_GET["esci"])){
				echo "ID di sessione: " . ($_SESSION["utente"]);
				if (!isset($_SESSION["utente"]))
					header('location:/Esercizi/es010_sessione/index.php');
				$id = $_SESSION["utente"];
				
				$codFiliale = -1;
				if(isset($_POST["filiale"]))
					$codFiliale = $_POST["filiale"];
				
				$con = new mysqli('localhost','root','','credenziali');
				if ($con->connect_error)
					die("Error: Failed to connect to DB: ".$con->connect_errno . " - ". $con->connect_error);
				
				$sql= "SELECT Nome,filiali.cFiliale AS codiceFiliale ";
				$sql.="FROM filiali,conti WHERE filiali.cFiliale=conti.cFiliale";
				$sql.=" AND conti.cCorrentista = $id";	
				$rs=$con->query($sql);
				if(!$rs)
					die("Error: Failed to execute query:".$con->connect_errno . " - ". $con->connect_error);
				echo("<form id='frm'>");
				while($record = $rs->fetch_assoc()){
					$cod = $record["codiceFiliale"];
					$nome = $record["Nome"];
					echo("<input type='radio' name='filiale' value='$cod' onChange = 'creaTabella()' ");
					if ($cod == $codFiliale)
						echo("checked ");
					echo("/>$nome");
					echo("<br/>");
				}
				
				if ($codFiliale != -1){
					$sql = "SELECT Data,Importo,movimenti.cMovimento AS codiceMovimento,";
					$sql.= "Descrizione FROM movimenti,conti,operazioni";
					$sql.= " WHERE conti.cCorrentista = $id AND conti.cFiliale=$codFiliale ";
					$sql.= "AND movimenti.cConto = conti.cConto AND movimenti.cOperazione=operazioni.cOperazione";
					//echo($sql);
					$rs = $con->query($sql);
					if (!$rs)
						die("Error: Failed to execute query:".$con->connect_errno . " - ". $con->connect_error);
					echo("<table border=1>");
					while($record=$rs->fetch_assoc()){
						echo("<tr>");
						$id=$record["codiceMovimento"];
						echo("<td><input type = 'text' name='txtID$id' value='$id'/></td>");
						echo("<td><input type = 'text' name='txtData$id' value='".$record["Data"]."'/></td>");
						echo("<td><input type = 'text' name='txtImporto$id' value='".$record["Importo"]."'/></td>");
						echo("<td><input type = 'text' name='txtOperazione$id' value='".$record["Descrizione"]."'/></td>");
						echo("</tr>");
					}
					echo("</table>");
				}
				echo("<button type='button' onClick='esci()'>Log out</button>");
				echo("</br>");
				echo("<a href='password.php'>Cambia password</a>");
				echo("</form>");
			}
			else{
				session_unset();
				//echo("destroy");
				session_destroy();
				header('location:/Esercizi/Es14_LoginBanche/');
			}
		?>
	</body>
</html>