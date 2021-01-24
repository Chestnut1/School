<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>PHP</title>
</head>

<body>
	<h1>Risultato: </h1>
    <?php
        //if($_SERVER["REQUEST_METHOD"]=="POST")
        if(isset($_REQUEST["txt1"]) && isset($_REQUEST["txt2"]) && isset($_REQUEST["txt3"])) {
            if ($_REQUEST["txt1"] == "")
                $n1 = 0;
            else
                $n1 = intval($_REQUEST["txt1"]);

            if ($_REQUEST["txt2"] == "")
                $n2 = 0;
            else
                $n2 = intval($_REQUEST["txt2"]);

            if ($_REQUEST["txt3"] == "")
                $n3 = 0;
            else
                $n3 = intval($_REQUEST["txt3"]);

            if ($n1 > $n2 && $n1 > $n3)
                echo("Il maggiore è: $n1<br>");
            else if ($n2 > $n3)
                echo("Il maggiore è: $n2<br>");
            else
                echo("Il maggiore è: $n3<br>");
        }
        else
            echo("Parametri non corretti");
        
        echo("Grazie di aver giocato");

    ?>
</body>

</html>