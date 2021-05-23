<!DOCTYPE html>
<html lang="en">
<head>
    <title>Pagina di amministrazione</title>
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
		if(isset($_SESSION['idUtente']) && 
			isset($_SESSION['amministrazione']) &&
				$_SESSION['amministrazione'] == 1){
            echo("<h1>BENTORNATO AMMINISTRATORE </h1>");
            echo("<h3>Pannello di controllo agenzia matrimoniale</h3>");
            echo("<hr>");
			$messaggioAdm = "";
			try {				
				$con = new PDO("sqlite:./agenziamatrimoniale.db");
				$con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
				if (isset($_GET["azioneAdm"]) && isset($_GET["pulsanteAdm"])) {
					$ident = $_GET["pulsanteAdm"];
					switch ($_GET["azioneAdm"]) { 
					case 'regenerate':
						$istruzione = "DELETE FROM abbinamenti;";
						$stmt = $con->prepare($istruzione);
						if ($stmt->execute()) $messaggioAdm = "Cancellati tutti gli abbinamenti.";
						$stmt->closeCursor();
						$istruzione = "INSERT INTO tblTemp1(idUtente1) SELECT utenti.id FROM utenti WHERE (sesso = 0) AND (amministrazione = 0);";
						$stmt = $con->prepare($istruzione);
						if ($stmt->execute()) {
							$istruzione = "INSERT INTO tblTemp2(idUtente2) SELECT utenti.id FROM utenti WHERE (sesso = 1) AND (amministrazione = 0);";
							$stmt->closeCursor();
							$stmt = $con->prepare($istruzione);
							if ($stmt->execute()) {
								$stmt->closeCursor();
								$istruzione = "INSERT INTO abbinamenti (idUtente1, idUtente2) SELECT idUtente1, idUtente2 FROM tblTemp1, tblTemp2;";							
								$stmt = $con->prepare($istruzione);
								if ($stmt->execute()) {
									$stmt->closeCursor();
									$messaggioAdm = $messaggioAdm . " Ricreati nuovi abbinamenti.";
								}
							}
						}
						$istruzione = "DELETE FROM tblTemp1;";
						$stmt = $con->prepare($istruzione);
						if ($stmt->execute()) {
							$stmt->closeCursor();
							$messaggioAdm = $messaggioAdm . " Pulita temp1.";
						}
						$istruzione = "DELETE FROM tblTemp2;";
						$stmt = $con->prepare($istruzione);
						if ($stmt->execute()) {
							$stmt->closeCursor();
							$messaggioAdm = $messaggioAdm . " Pulita temp2.";
						}					
						break;
					case 'calcola':
						$istruzione = "UPDATE abbinamenti SET scartato = 1 WHERE (giudizio1 < 25) OR (giudizio2 < 25) OR ((giudizio1 + giudizio2) < 50);";
						$stmt = $con->prepare($istruzione);
						if ($stmt->execute()) {
							$stmt->closeCursor();	
							$messaggioAdm = "Scartati abbinamenti sgraditi.";
						}					
						break;
					case 'deleteAll':
						$istruzione = "DELETE FROM abbinamenti WHERE scartato = 1;";
						$stmt = $con->prepare($istruzione);
						if ($stmt->execute()) {
							$stmt->closeCursor();					
							$messaggioAdm = "Cancellate tutte le coppie scartate.";
						}					
						break;				
					case 'delete':
						$istruzione = "DELETE FROM abbinamenti WHERE id = " . $_GET["pulsanteAdm"] . ";";
						$stmt = $con->prepare($istruzione);
						if ($stmt->execute()) {
							$stmt->closeCursor();
							$messaggioAdm = "Cancellato record.";
						}					
						break;
					default:
						//echo ("DEBUG - nessuna delle tre.");
						$messaggio = "DEBUG - nulla";
						break;
					}	
					echo $messaggio;					
				}
				
				echo("<h3 style='color:green;'>Elenco abbinamenti in corso di valutazione</h3><br>" . $messaggioAdm . "<br>");
				echo("<form method='post'>");
				echo("<button id='btnCalcolaScarti' type='submit' class='btn btn-primary' formaction='admin.php?azioneAdm=calcola&pulsanteAdm=0'>Calcola coppie da scartare in base ai giudizi dati</button>");
				echo("<button id='btnEliminaScartati' type='submit' class='btn btn-danger' formaction='admin.php?azioneAdm=deleteAll&pulsanteAdm=0'>Elimina coppie scartate</button>");
				echo("<button id='btnRigenera' type='submit' class='btn btn-warning' formaction='admin.php?azioneAdm=regenerate&pulsanteAdm=0'>Elimina tutte le coppie e ricrea tutte le possibili</button>");
				echo("<button id='btnAnagrafica' type='submit' class='btn btn-success' formaction='adminAnag.php'>Vai a Anagrafica Utenti</button>");
				echo("</form>");

				//utente femmina in abbinamenti sempre solo in prima posizione, maschi sempre solo in seconda posizione
				//giudizio1 è il giudizio di utente1 sulla coppia proposta, quindi femmina modifica giudizio1 e maschio giudizio2
				$istruzione1 = 'SELECT Count(*) AS nAbb FROM abbinamenti, utenti AS utenti1, utenti AS utenti2 WHERE (abbinamenti.idUtente1 = utenti1.id) AND (abbinamenti.idUtente2 = utenti2.id)';
				$istruzione2 = 'SELECT abbinamenti.id, utenti1.id AS idFemmina, utenti1.nome AS nomeFemmina, utenti2.id AS idMaschi, utenti2.nome AS nomeMaschio, abbinamenti.giudizio1 AS giudizioDiFemminaSuCoppia, abbinamenti.giudizio2 AS giudizioDiMaschioSuCoppia, abbinamenti.scartato FROM abbinamenti, utenti AS utenti1, utenti AS utenti2 WHERE  (abbinamenti.idUtente1 = utenti1.id) AND (abbinamenti.idUtente2 = utenti2.id)';
				// eseguo la query per il numero di righe
				$result = $con->query($istruzione1);
				$nAbb=0;
				if ($row = $result->fetch(PDO::FETCH_OBJ))
						$nAbb=$row->nAbb;
				echo "Numero abbinamenti: " . $nAbb;
				if ($nAbb > 0){ 				
					echo("<form method='post'>");
					echo("<div class='table-responsive'>");	
					echo('<table class="table" style="border:2px solid black;border-collapse:collapse" border="1">');
					echo('<thead><tr class="table"><th class="col-xs-1">Rif.</th><th class="col-xs-3">Donna</th><th class="col-xs-3">Uomo</th><th class="col-xs-2">Coppia piace a donna (%)</th><th class="col-xs-2">Coppia piace a uomo  (%)</th><th class="col-xs-1">Scartata</th></tr></thead>');
					$result->closeCursor();
					$stmt = $con->prepare($istruzione2);
					$stmt->execute();  //eseguo la query
					echo('<tbody>');					
					while($record = $stmt->fetch(PDO::FETCH_ASSOC)){
						$id = $record['id'];
						echo('<tr class="table">');
						echo "<td class='col-xs-1' style='color:white;background:gray;'> $id </td>";
						echo '<td class="col-xs-3"><input class="form-control" readonly type="text" size="15" name="txtNomeFemmina$id" value = "' . $record["nomeFemmina"] . '"/></td>';
						echo '<td class="col-xs-3"><input class="form-control" readonly type="text" size="15" name="txtNomeMaschio$id" value = "' . $record["nomeMaschio"] . '"/></td>';
						echo '<td class="col-xs-2"><input class="form-control" readonly type="text" size="2" name="txtgiudizioDiFemminaSuCoppia$id" value="' . $record["giudizioDiFemminaSuCoppia"] . '"/></td>';
						echo '<td class="col-xs-2"><input class="form-control" readonly type="text" size="2" name="txtgiudizioDiMaschioSuCoppia$id" value="' . $record["giudizioDiMaschioSuCoppia"] . '"/></td>';                        
						echo '<td class="col-xs-1"><input class="form-control" readonly type="text" size="1" name="chkScartato$id" value="' . $record["scartato"] . '"/></td>';                        						
						echo("<td><button id='btn$id' type='submit' class='btn btn-danger' formaction='admin.php?azioneAdm=delete&pulsanteAdm=" . $record["id"] ."'>Elimina coppia</button></td>");
						echo("</tr>");
					}
					echo("</tbody></table></div><hr>");
					echo("</form>");
					echo("<form method='post' action='mostraCoppieSoglia.php'>");
					echo('<div class="container"><div class="row">');
					echo('<h6 class="col-xs-4">Mostra solo coppie con somma giudizi superiore a: </h6>');
					echo('<input class="form-control col-xs-2" type="number" value="50" name="txtSoglia" id="txtSoglia"/>');
					echo("<button class='form-control col-xs-2 btn-success' id='btnMostraCoppieFunzionanti' type='submit'>Visualizza</button>");
					echo('</div></div>');
					echo("</form>");
				}
				$stmt->closeCursor();
				$con = NULL; //chiudo connessione
			} catch(PDOException $e) { //controllo errori di connessione
				echo "Error: Failed to connect to DB: " . $e->getMessage();
				die();
			}
		}else{ header("location: index.html");  //renderizza alla home
        }	
	echo("<br><br>");
        echo("<form action='login.php' method='POST' id='frm'>");
		echo("<button type='button' onClick='chiudi_sessione()' class='btn btn-dark'>Esci</button>");
        echo("</form>");
    ?>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>