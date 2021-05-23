<?php

//CREAZIONE TABELLA
echo("<div class='table-responsive'>");	
echo('<table class="table" style="border:2px solid black;border-collapse:collapse" border="1">');


//intestazione tabella
echo('<thead><tr class="table"><th class="col-xs-1">Rif.</th><th class="col-xs-3">Nome</th><th class="col-xs-2">Anni</th><th class="col-xs-2">Altezza (cm)</th><th class="col-xs-2">Peso (Kg)</th><th class="col-xs-3">% Gradimento</th></tr></thead>');

$result->closeCursor();
$stmt = $con->prepare($istruzione2);
$stmt->execute();  //eseguo la query

echo('<tbody>');					
while($record = $stmt->fetch(PDO::FETCH_ASSOC)){
    $idAbb = $record['idAbb'];
    $id = $record['id'];

    //colonna id
    echo('<tr class="table">');
    echo "<td class='col-xs-1' style='color:white;background:gray;'> $id </td>";

    //altre colonne
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

?>