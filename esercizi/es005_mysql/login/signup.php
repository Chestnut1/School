<!DOCTYPE html>
<html lang="en">
<head>
    <title>Signup Page</title>
    <script type="application/javascript">
			//funzione che viene chiamata quando si clicca sul bottone salva
			function controllo(){
				var ok=true;
				var vet = document.getElementsByTagName("input");	//prende tutto il contenuto dei campi input
				
				//cicla attraverso gli input
				for(var i=0;i<vet.length; i++){
					if(vet[i].value==""){
						ok=false;
						break;
					}
				}
				
				if(!ok)
				{
					//Messaggio di errore
					var msg = document.getElementById("txtMessaggio");
					
					msg.innerHTML = "Errore: campi non compilati";
					msg.style.color="red";
				}
				else{
					var frm = document.getElementById("frm");	//risalgo al form
					frm.method="post";
					frm.action="signup.php?azione=salva";
					frm.submit();
				}
			}
	</script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="icon" type="image/png" href="img/signup.png"/>
</head>
<body>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <div class="container">

        <br><br><br><br><br>

        <!--    FORM    -->
        <div class="row">
            <div class="col col-md-3"></div>

            <div class="col col-md-6">

                <form action="aggiungi.php" method="POST" id="frm">

                    <!--    EMAIL   -->
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="email" class="form-control" aria-describedby="emailHelp" name="usr">
                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                    </div>

                    <!--    PASSWORD    -->
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" name="pwd">
                    </div>
                    
                    <!--    SIGNUP BUTTON    -->                    
                    <button type="button" onClick="controllo()" class="btn btn-dark">Sign Up</button>
                </form>

                <br><br>
            </div>
        </div>


    </div>

    <?php
			if($_GET["azione"] == "salva"){
				//prendo le nuove variabili
				$usr = $_POST["usr"];
				$pwd = $_POST["pwd"];
                
                //connessione al db
				$con = new mysqli('localhost','root','','credenziali');
				if ($con->connect_error)    //controllo errori di connessione
					die("Error: Failed to connect to DB: ".$con->connect_errno . " - ". $con->connect_error);
                
                    
				$sql="SELECT usr FROM utenti  WHERE usr = '$usr' ";   //cerco se l'utente esiste gia'
				$ok = $con->query($sql);    //eseguo la query
				
				if($ok){   //aggiungo utente
                    $sql = "INSERT INTO utenti (usr, pwd) VALUES('$usr','$pwd')";
                    $ok = $con->query($sql);    //eseguo la query
                    header("location:/Esercizi/es005_mysql/login/index.html");
				} else {    //messaggio di errore
					echo("<label style='color:red'>Username gia' esistente.</label>");
                }
                
                $con->close();
			}
		?>
</body>
</html>