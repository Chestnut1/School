<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Es08 mysql</title>
		<script type="application/javascript">
			//funzione che viene chiamata quando vengon oapportate delle modifiche ad una riga
			function abilita(id){
				var btn = document.getElementById("btn"+id);
				btn.removeAttribute("disabled");
			}
		</script>
	</head>
	<body>
		<?php
			//connessione al db	
			$con = new mysqli('localhost','root','','dbautomobili');
			if ($con->connect_error)
				die("Error: Failed to connect to DB: ".$con->connect_errno . " - ". $con->connect_error);
			
			$istruzione = "SELECT * FROM marche";
			// eseguo la query
			$rs = $con->query($istruzione);
			// Numero di righe
			$num = $rs->num_rows;
			
			echo("<h1>Elenco marche</h1>");
			if($num>0){
				echo("<form method='post'>");
				echo("<table border=1>");
				// for record in rs
				while($record = $rs->fetch_assoc()){
					echo("<tr>");
					//accedo alla colonna che si chiama "id"
					$id = $record["id"];
					echo("<td><input readonly type='text' name='txtID$id' value = '$id'/></td>");

					//controlla se modifico la riga dalla pagina web, se si abilita il pulsante salva
					echo("<td><input type='text' name='txtNome$id' value='".$record["nome"]."' onChange = 'abilita($id)'/></td>");
					echo("<td><input type='text' name='txtNazione$id' value='".$record["nazione"]."' onChange = 'abilita($id)'/></td>");

					//salva le modifiche apportate al record
					echo("<td><button disabled id='btn$id' type='submit' formaction='salva.php?pulsante=$id'>Salva</button></td>");

					//quando premuto richiama la pagina php e gli passa il suo id
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