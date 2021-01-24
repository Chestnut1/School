<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>PHP</title>
</head>

<body>
	<h1>Esercizio base per PHP</h1>
	<?php
        $nome = "Pi greco";
        $var = 3.14;
        $eta;
        $somma;
        $interna = "interna";
        $vect = array('a', 'b', 'c', 'd');
        $vect2 = array(2, 3, 4, 5);
        function stampa_nome(&$nome) {
            // meglio nella head
            nl2br(print("$nome \n"));
            global $interna;
            $interna="Valorizzata nella funzione";
            //questa non verrà mai stampata, perché la $nome esterna è un'altra variabile
            $nome="pippo";
        }
    ?>
    <h2>Array enumerativi</h2>
    <br>
    <?php
        echo "Il numero di elementi è " . count($vect) . "<br>";// Numero di elementi contenuti nel vettore
        array_push($vect, "e",  "f",  "g" );
        echo "Ora il numero di elementi è " . count($vect) . "<br>";
        for ($x = 0; $x < count($vect); $x++){
            $temporanea = $vect[$x];
            echo "L'elemento di indice $x è $temporanea <br>";
        }
        echo "La somma degli elementi è " . array_sum($vect2) . "<br>";
        for ($x = 0; $x < count($vect2); $x++){
            $temporanea = $vect2[$x];
            echo "L'elemento di indice $x è $temporanea <br>";
        }
    ?>
    <br>
    <hr>
    <h2>Array associativi</h2>
    <?php
        $age = array("Peter"=>35, "Ben"=>37, "Joe"=>43);
        echo "Peter ha " . $age['Peter'] . " anni.";
        $age['Joe'] = 13;
        echo "Joe ha " . $age['Joe'] . " anni.";
        $age = array_merge($age, array("Jack"=>29, "foo"=>13));
        $age = $age + array("Bill"=>39, "Frederik"=>23, "1"=>2, 1=>66);
        echo "Jack ha " . $age['Jack'] . " anni.";
        echo "Bill ha " . $age['Bill'] . " anni.";
        echo "1 ha " . $age['1'] . " anni.";
        echo "Bill ha " . $age[1] . " anni.<br>";
//il risultato è Peter ha 35 anni.Joe ha 13 anni.Jack ha 29 anni.Bill ha 39 anni.1 ha 66 anni.Bill ha 66 anni.
        foreach ($age as $nome => $eta) {
            echo "L'utente " . $nome . " ha " . $eta . " anni\n";
            global $somma;
            $somma += $eta;
        }
        echo "La somma degli anni è " . $somma . " .<br>";
    ?>
    <br>
    <hr>
    <h2>Costrutti di base del linguaggio PHP</h2>
    <?php
		echo ("Il mio nome &egrave; $nome e valgo $var <br>");
		echo $nome . " =" . $var;
		if(isset($nome)) {
			echo '<p>Variabile $nome valorizzata.</p><br>';
		} else {
			echo '<p>Variabile $nome non valorizzata.</p><br>';
		}
		if(is_numeric($var)) {
			echo '<p>Variabile $nome numerica.</p><br>';
		} else {
			echo '<p>Variabile $nome stringa.</p><br>';
		}
		if($var != 'undefined') {
			echo '<p>Variabile $var definita .</p><br>';
		} else {
			echo '<p>Variabile $var non definita .</p><br>';
		}
        echo ("Variabile interna prima della chiamata a funzione: $interna <br>");
        stampa_nome($nome);
        echo ("Variabile interna dopo la chiamata a funzione: $interna <br>");
        echo "E' andato a capo ? <br>";
		$colore = "giallo";
		switch ($colore) {
			case 'blu'   :
				echo "Il colore selezionato è blu<br>";
				break;
			case 'giallo':
				echo "Il colore selezionato è giallo<br>";
				break;
			default      :
				echo "Nessun colore corrispondente alla tua selezione<br>";
				break;
		}
        echo "Oggi è il " .  date("Y/m/d") . "<br>";
        echo "Oggi è il " .  date("d/m/Y") . "<br>";
        echo "Oggi è il " .  date("d-m-Y") . "<br>";
    ?>
</body>

</html>.