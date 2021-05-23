<!DOCTYPE html>
<html lang="en">
<head>
    <title>Pagina di amministrazione - Anagrafica Utenti</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="icon" type="image/png" href="img/login.png"/>
    <script type="application/javascript">
			function chiudi_sessione(){
				var frm= document.getElementById("frm");				
				frm.method="post";
				frm.action="index.html";
				frm.submit();
            }
    </script>
</head>
<body>
<?php
    session_start();
	if(isset($_SESSION['utente']) && $_SESSION['amministrazione'] == 1){
		echo("<h1>BENTORNATO AMMINISTRATORE </h1>");
		echo("<h3>Pannello di controllo agenzia matrimoniale</h3>");
		echo("<hr>");
		$messaggio = "";
		//connessione al db	
		$con = new mysqli('localhost','root','','agenziamatrimoniale');
		if ($con->connect_error)
			die("Error: Failed to connect to DB: ".$con->connect_errno . " - ". $con->connect_error);
		
		if (isset($_GET["azione"]) && isset($_GET["pulsante"])) {
			$ident = $_GET["pulsante"];
			switch ($_GET["azione"]) { 
			case 'create':
				$istruzione = "INSERT INTO utenti (nome, sesso, eta, altezza, peso, nickname, password, amministrazione) values ('" . $_POST["nome"] . "', '" . $_POST["sesso"] . "', " . $_POST["eta"] . ", " . $_POST["altezza"] . ", " . $_POST["peso"] . ", '" . $_POST["nickname"] . "', '" . $_POST["password"] . "', " . $_POST["campoNascosto"] . ");";
				if ($con->query($istruzione)) {$messaggio = 'Inserito nuovo record.';}
				break;
			case 'edit':
				$istruzione = "UPDATE utenti SET nome = '" . $_POST["txtNome$ident"] . "', sesso = '" . $_POST["txtSesso$ident"] . "', eta = " . $_POST["txtEta$ident"] . ", altezza = " . $_POST["txtAltezza$ident"] . ", peso = " . $_POST["txtPeso$ident"] . ", nickname = '"  . $_POST["txtNickname$ident"] . "', password = '" . $_POST["txtPassword$ident"] . "', amministrazione = 0 WHERE id = " . $_GET["pulsante"] . ";";
				if ($con->query($istruzione)) {$messaggio = "Modificato record.";}					
				break;
			case 'delete':
				$istruzione = "DELETE FROM utenti WHERE id = " . $_GET["pulsante"] . ";";
				if ($con->query($istruzione)) {$messaggio = "Cancellato record.";}					
				break;
			default:
				//echo ("DEBUG - nessuna delle tre.");
				$messaggio = "DEBUG - nulla";
				break;
			}
		}
		
		$istruzione = "SELECT * FROM utenti";
		// eseguo la query
		$rs = $con->query($istruzione);
		// Numero di righe
		$num = $rs->num_rows;		
		echo("<h3 style='color:green;'>Anagrafica utenti</h3><br>" . $messaggio . "<br>");
		if($num>0){
			echo("<form method='post'>");
			echo("<div class='table-responsive'>");	
			echo('<table class="table" style="border:2px solid black;border-collapse:collapse" border="1">');
			echo('<thead><tr class="table"><th class="col-xs-1">Rif.</th><th class="col-xs-3">Nome</th><th class="col-xs-1">Sesso</th><th class="col-xs-1">Anni</th><th class="col-xs-1">Altezza (cm)</th><th class="col-xs-1">Peso (Kg)</th><th class="col-xs-2">Nickname</th><th class="col-xs-2">Password</th></tr></thead>');
			echo('<tbody>');
			while($record = $rs->fetch_assoc()){
				$id = $record["id"]; //accedo alla colonna che si chiama "id"
				echo("<tr class='table'>");
				echo("<td class='col-xs-1' style='color:white;background:gray;'> $id </td>");
				echo("<td class='col-xs-3'><input class='form-control' type='text' id='txtNome$id' size='15' name='txtNome$id' value = '" . $record["nome"] . "'/></td>");
				echo("<td class='col-xs-1'><input class='form-control' type='text' id='txtSesso$id' size='1' name='txtSesso$id' value = '" . $record["sesso"] . "'/></td>");
				echo("<td class='col-xs-2'><input class='form-control' type='text' id='txtEta$id' size='2' name='txtEta$id' value='" . $record["eta"] . "'/></td>");
				echo("<td class='col-xs-2'><input class='form-control' type='text' id='txtPeso$id' size='2' name='txtPeso$id' value='" . $record["peso"] . "'/></td>");
				echo("<td class='col-xs-2'><input class='form-control' type='text' id='txtAltezza$id' size='2' name='txtAltezza$id' value='" . $record["altezza"] . "'/></td>");
				echo("<td class='col-xs-2'><input class='form-control' type='text' id='txtNickname$id' size='15' name='txtNickname$id' value='" . $record["nickname"] . "'/></td>");
				echo("<td class='col-xs-2'><input class='form-control' type='text' id='txtPassword$id' size='15' name='txtPassword$id' value='" . $record["password"] . "'/></td>");
				echo("<td><button id='btn$id' type='submit' class='btn btn-primary' formaction='adminAnag.php?azione=edit&pulsante=" . $record["id"] ."'>Salva modifiche</button></td>");
				echo("<td><button id='btn$id' type='submit' class='btn btn-danger' formaction='adminAnag.php?azione=delete&pulsante=" . $record["id"] ."'>Elimina utente</button></td>");				
				echo("</tr>");					
			}
			echo("</tbody></table></div><hr>");
			echo("</form>");
			echo("<br><hr><br>");
		}		
	}else{
		header("location: index.html");  //renderizza alla home
	}
?>

	<h3 style='color:green;'>Inserisci nuovo utente</h3>
	<br>
	<form action="adminAnag.php?azione=create&pulsante=0" method="POST">
        <div class="form-group">
          <label for="nome">Nome</label>
          <input type="text"  name="nome" class="form-control" id="nome" placeholder="Enter nome">
        </div>
        <div class="form-group">
          <label for="sesso">Sesso</label>
          <input type="text" name="sesso" class="form-control" id="sesso" placeholder="M/F">
        </div>
        <div class="form-group">
            <label for="eta">Eta</label>
            <input type="number" name="eta" class="form-control" id="eta" value="40">
        </div>
        <div class="form-group">
            <label for="altezza">Altezza</label>
            <input type="number" name="altezza" class="form-control" id="altezza" value="170">
        </div>
        <div class="form-group">
            <label for="peso">Peso</label>
            <input type="number" name="peso" class="form-control" id="peso" value="60">
        </div>
        <div class="form-group">
            <label for="nickname">Nickname</label>
            <input type="text" name="nickname" class="form-control" id="nickname" placeholder="nickname">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="text" name="password" class="form-control" id="password" placeholder="password">
        </div>
		<input type="hidden" id="campoNascosto" name="campoNascosto" value="0">
        <button type="submit" class="btn btn-primary">Registra</button>
    </form>

<?php
	echo("<br><br>");
	echo("<form action='login.php' method='POST' id='frm'>");
	echo("<button id='btnAnagrafica' type='submit' class='btn btn-success' formaction='admin.php'>Torna a pannello amministrazione</button>");
	echo("<button type='button' onClick='chiudi_sessione()' class='btn btn-dark'>Esci</button>");
	echo("</form>");
?>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>