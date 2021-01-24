<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>PHP</title>
</head>

<body>
	<h1>Benvenuto!!</h1>
    <h3>Questi sono i tuoi dati inseriti</h3>
    <?php
        $nome=$_GET["txtNome"];
        echo("NOME: $nome<br>");

        $indirizzo=$_GET["rdbIndirizzo"];
        echo("INDIRIZZO DI STUDIO: $indirizzo<br>");

        //In questo caso $hobbies è un vettore enumerativo
        $hobbies=$_GET["chkHobbies"];
        echo("HOBBY: ");
        foreach ($hobbies as $valore)
            echo("$valore, ");
        echo("<br>");

        $citta=$_GET["lstCitta"];
        echo("CITTA': $citta<br>");

        $segni=$_GET["txtSegni"];
        echo("SEGNI PARTICOLARI: $segni<br>");
        
        //Anche scoperta è un vettore enumerativo
        $scoperta=$_GET["lstScoperta"];
        $msg=implode(', ',$scoperta);
        echo("SCOPERTO TRAMITE: $msg<br>");
    ?>
</body>

</html>