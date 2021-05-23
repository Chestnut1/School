<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    
    <title>Welcome</title>

    <script type="application/javascript">
			function chiudi_sessione(){
                alert("sto uscendo");
				var frm= document.getElementById("frm");
				
				frm.method="post";
				frm.action="index.html";
				frm.submit();
            }
    </script>>
</head>
<body>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <?php
    session_start();
        if(isset($_SESSION['utente'])){
            echo("<h1>BENTORNATO </h1>".$_SESSION['utente']);
        }else{
            echo("<h1>NON TI CONOSCO SPARISCI<h1/>".$_SESSION['utente']);
            header("location:/Esercizi/es005_mysql/login/index.html");  //renderizza alla home
        }
        echo("<form action='index.html' method='POST' id='frm'>");
        echo("<button type='button' onClick='chiudi_sessione()' class='btn btn-dark'>Esci</button>");
        echo("</form>");
    ?>
</body>
</html>