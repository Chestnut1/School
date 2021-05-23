<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Contattaci</title>
</head>

<body>
	<h1>Grazie per averci contattato! La tua richeista sarà elaborata e riceverai una risposta entro 72 ore!</h1>
    <h3>Questi sono i tuoi dati inseriti</h3>
    <?php
        $msg = "Grazie per esserti registrato!\nEcco i dati che hai inserito:\n\nverrai contattato entro 72 ore da un nostro operatore!";

        $nome=$_POST["txtNome"];
        echo("NOME: $nome<br>");

        $cognome=$_POST["txtCognome"];
        echo("COGNOME: $cognome<br>");

        $mail=$_POST["get_email"];
        echo("MAIL: $mail<br>");

        $password=$_POST["rdbPwd"];
        echo("PASSWORD: $password<br>");

        $citta=$_POST["inputState"];
        echo("CITTA': $citta<br>");

        foreach($_POST['chkCorsi'] as $corso) {
            echo $corso . '<br>';
        }

        
    ?>
</body>

</html>