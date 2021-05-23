<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    
    <title>Utente</title>

    <script type="application/javascript">
			function chiudi_sessione(){
                alert("sto uscendo");
				var frm= document.getElementById("frm");
				
				frm.method="post";
				frm.action="index.html";
				frm.submit();
            }
    </script>
</head>
<body>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <div class="row">
            <div class="col col-md-3"></div>

            <div class="col col-md-6">
                <button type='button' onClick='chiudi_sessione()' class='btn btn-dark'>Esci</button>
            </div>
        </div>
    <?php
        session_start();
        if(isset($_SESSION['utente'])){
            $utente = "".$_SESSION['utente'];
            echo("<h1>BENTORNATO </h1>".$_SESSION['utente']);
        }else{
            echo("<h1>NON TI CONOSCO SPARISCI<h1/>".$_SESSION['utente']);
            header("location:/Esercizi/es005_mysql/login/index.html");  //renderizza alla home
        }

        //connessione al db
		$con = new mysqli('localhost','root','','agenziaMatrimoniale');
		if ($con->connect_error)    //controllo errori di connessione
			die("Error: Failed to connect to DB: ".$con->connect_errno . " - ". $con->connect_error);      
		
        $sql="SELECT sesso FROM utenti WHERE nickname = '$utente'";   //cerco tutti gli utenti
		$ok = $con->query($sql);    //eseguo la query

        if($ok){
            echo("<h1>ELENCO COMBINAZIONI UTENTE</h1>");

            $record = $ok->fetch_assoc();
            if($record){ //maschio
                echo($record."<br>");
                $sql="SELECT * FROM utenti WHERE sesso = 0 AND amministratore = 0";
		        $ok = $con->query($sql);    //eseguo la query

                //ciclo i record
                while($record = $ok->fetch_assoc()){
                    echo(implode(", " , $record)."<br><br>");
                }

            }else{ //femmina
                echo($record."<br>");
                $sql="SELECT * FROM utenti WHERE sesso = 1 AND amministratore = 0";
		        $ok = $con->query($sql);    //eseguo la query

                //ciclo i record
                while($record = $ok->fetch_assoc()){
                    echo(implode(", " , $record)."<br><br>");
                }
                
            }
        }
        
        $con->close();

        echo("<form action='index.html' method='POST' id='frm'>");
        echo("<button type='button' onClick='chiudi_sessione()' class='btn btn-dark'>Esci</button>");
        echo("</form>");
        
    ?>
</body>
</html>