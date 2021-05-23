<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Es08 mysql</title>
		<script type="application/javascript">
			function abilita(id){
				var btn = document.getElementById("btn"+id);
				btn.removeAttribute("disabled");
			}
		</script>
	</head>
	<body>
		<?php
			$con = new mysqli('localhost','root','','dbautomobili');
			if ($con->connect_error)
				die("Error: Failed to connect to DB: ".$con->connect_errno . " - ". $con->connect_error);
			
			$sql = "SELECT * FROM marche";
			// eseguo la query
			$rs = $con->query($sql);
			// Numero di righe
			$num = $rs->num_rows;
			
			echo("<h1>Elenco marche</h1>");
			if($num>0){
				echo("<form method='post'>");
				echo("<table border=1>");
				while($record = $rs->fetch_assoc()){
					echo("<tr>");
					$id = $record["id"];
					echo("<td><input readonly type='text' name='txtID$id' value = '$id'/></td>");
					echo("<td><input type='text' name='txtNome$id' value='".$record["nome"]."' onChange = 'abilita($id)'/></td>");
					echo("<td><input type='text' name='txtNazione$id' value='".$record["nazione"]."' onChange = 'abilita($id)'/></td>");
					echo("<td><button disabled id='btn$id' type='submit' formaction='salva.php?pulsante=$id'>Salva</button></td>");
					echo("<td><button type='submit' formaction='elimina.php?pulsante=$id'>Elimina</button></td>");
					echo("</tr>");
				}
				echo("</table>");
				echo("</form>");
			}
		?>
		<form>
		<button type="submit" formmethod="post" formaction="inserisci.php?azione=vuoto">Inserisci</button>
		</form>
		
	</body>
</html>