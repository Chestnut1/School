<!DOCTYPE html>
<html lang="en">
<head>
    <title>Valutazione partner potenziali</title>
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
            function abilita(id){
				var btn = document.getElementById("btn"+id);
				btn.removeAttribute("disabled");
			}
    </script>
</head>
<body>
    <?php
		session_start();
        if(isset($_SESSION['idUtente'])){
			if ($_SESSION['sessoUtente'] == 0) {
				echo('<div class="container"><div class="row"><div class="col-xs-12">');
				echo "<h1>BENTORNATA " . $_SESSION['nomeUtente'] . "</h1>";
				echo "</div></div></div>";
			} else {
				echo('<div class="container"><div class="row"><div class="col-xs-12">');
				echo "<h1>BENTORNATO " . $_SESSION['nomeUtente'] . "</h1>";
				echo "</div></div></div>";
			}	
			$messaggio = "";

            //connessione al db	
			try {				
				$con = new PDO("sqlite:./agenziamatrimoniale.db");
				$con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);				
				if (isset($_GET["azioneUt"]) && isset($_GET["sesso"]) && isset($_GET["idAbb"])) {
					$num = $_GET["idAbb"];
					switch ($_GET["azioneUt"]) { 
					case 'edit':
						if ($_GET["sesso"] == 0)
							$istruzione = "UPDATE abbinamenti SET giudizio1 = " . $_POST["txtGiudizio$num"] . " WHERE id = $num;";
						else
							$istruzione = "UPDATE abbinamenti SET giudizio2 = " . $_POST["txtGiudizio$num"] . " WHERE id = $num;";
						$stmt = $con->prepare($istruzione);
						if ($stmt->execute()) {$messaggio = "Registrato giudizio.";}					
						break;
					default:
						//echo ("DEBUG - nessuna delle tre.");
						$messaggio = "DEBUG - nulla";
						break;
					}
					echo $messaggio;
				}			
				//utente femmina in abbinamenti sempre solo in prima posizione, maschi sempre solo in seconda posizione
				//giudizio1 è il giudizio di utente1 sulla coppia proposta, quindi femmina modifica giudizio1 e maschio giudizio2
				if ($_SESSION['sessoUtente'] == 0) {
					$istruzione1 = 'SELECT count(*) AS nAbb FROM utenti INNER JOIN abbinamenti ON utenti.id = abbinamenti.idUtente2 WHERE abbinamenti.idUtente1 = '. $_SESSION['idUtente'];
					$istruzione2 = 'SELECT utenti.*, abbinamenti.id AS idAbb, abbinamenti.giudizio1 FROM utenti INNER JOIN abbinamenti ON utenti.id = abbinamenti.idUtente2 WHERE abbinamenti.idUtente1 = ' . $_SESSION['idUtente'];
				} else {
					$istruzione1 = 'SELECT count(*) AS nAbb FROM utenti INNER JOIN abbinamenti ON utenti.id = abbinamenti.idUtente1 WHERE abbinamenti.idUtente2 = '. $_SESSION['idUtente'];
					$istruzione2 = 'SELECT utenti.*, abbinamenti.id AS idAbb, abbinamenti.giudizio2 FROM utenti INNER JOIN abbinamenti ON utenti.id = abbinamenti.idUtente1 WHERE abbinamenti.idUtente2 = ' . $_SESSION['idUtente'];
				}
				// eseguo la query per il numero di righe
				$result = $con->query($istruzione1);
				echo("<h3>Elenco candidati partner</h3><hr>" . $messaggio . "<hr>");
				$nAbb=0;
				if ($row = $result->fetch(PDO::FETCH_OBJ))
						$nAbb=$row->nAbb;
				echo "Numero abbinamenti: " . $nAbb;
				if ($nAbb > 0){ 
					echo("<form method='post'>");
					echo("<h6 style='color:orange;'>Puoi immettere la tua percentuale di gradimento.</h6>");
					echo("<div class='table-responsive'>");	
					echo('<table class="table" style="border:2px solid black;border-collapse:collapse" border="1">');
					echo('<thead><tr class="table"><th class="col-xs-1">Rif.</th><th class="col-xs-3">Nome</th><th class="col-xs-2">Anni</th><th class="col-xs-2">Altezza (cm)</th><th class="col-xs-2">Peso (Kg)</th><th class="col-xs-3">% Gradimento</th></tr></thead>');
					$result->closeCursor();
					$stmt = $con->prepare($istruzione2);
					$stmt->execute();  //eseguo la query
					echo('<tbody>');					
					while($record = $stmt->fetch(PDO::FETCH_ASSOC)){
						$idAbb = $record['idAbb'];
						$id = $record['id'];
						echo('<tr class="table">');
						echo "<td class='col-xs-1' style='color:white;background:gray;'> $id </td>";
						if ($_SESSION['sessoUtente'] == 0) {
							echo '<td class="col-xs-3" style="background:aqua"><input class="form-control" readonly type="text" size="15" name="txtNome$id" value = "' . $record["nome"] . '"/></td>';
							echo '<td class="col-xs-2" style="background:aqua"><input class="form-control" readonly type="text" size="2" name="txtEta$id" value="' . $record["eta"] . '"/></td>';
							echo '<td class="col-xs-2" style="background:aqua"><input class="form-control" readonly type="text" size="2" name="txtPeso$id" value="' . $record["peso"] . '"/></td>';
							echo '<td class="col-xs-2" style="background:aqua"><input class="form-control" readonly type="text" size="2" name="txtAltezza$id" value="' . $record["altezza"] . '"/></td>';
							echo("<td class='col-xs-3' style='background:aqua'><input class='form-control' type='text' id='txtGiudizio$idAbb' size='10' name='txtGiudizio$idAbb' value='" . $record["giudizio1"] . "'/></td>");               
							echo("<td><button id='btn$idAbb' type='submit' class='btn btn-primary' formaction='utente.php?azioneUt=edit&sesso=0&idAbb=".$record["idAbb"]."'>Salva</button></td>");
						} else {
							echo '<td class="col-xs-3" style="background:pink"><input class="form-control" readonly type="text" size="15" name="txtNome$id" value = "' . $record["nome"] . '"/></td>';
							echo '<td class="col-xs-2" style="background:pink"><input class="form-control" readonly type="text" size="2" name="txtEta$id" value="' . $record["eta"] . '"/></td>';
							echo '<td class="col-xs-2" style="background:pink"><input class="form-control" readonly type="text" size="2" name="txtPeso$id" value="' . $record["peso"] . '"/></td>';
							echo '<td class="col-xs-2" style="background:pink"><input class="form-control" readonly type="text" size="2" name="txtAltezza$id" value="' . $record["altezza"] . '"/></td>';
							echo("<td class='col-xs-3' style='background:pink'><input class='form-control' type='text' id='txtGiudizio$idAbb' size='10' name='txtGiudizio$idAbb' value='" . $record["giudizio2"] . "'/></td>");               
							echo("<td><button id='btn$idAbb' type='submit' class='btn btn-primary' formaction='utente.php?azioneUt=edit&sesso=1&idAbb=" . $record["idAbb"] . "'>Salva</button></td>");
						}				
						echo('</tr>');					
					}
					echo("</tbody></table></div>");
					echo("</form>");
				}
				$stmt->closeCursor();
				$con = NULL; //chiudo connessione
			} catch(PDOException $e) { //controllo errori di connessione
				echo "Error: Failed to connect to DB: " . $e->getMessage();
				die();
			}
        }else{
            header("location: index.html");  //reindirizza alla home
        }
        echo("<form action='login.php' method='POST' id='frm'>");
        echo("<button type='button' onClick='chiudi_sessione()' class='btn btn-dark'>Esci</button>");
        echo("</form>");
    ?>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>