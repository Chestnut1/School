<?php
    session_start();
    include_once "config.php";

    //prendo i dati da AJAX
    $uname = mysqli_real_escape_string($conn, $_POST['uname']);
    $password =hash("sha512" ,mysqli_real_escape_string($conn, $_POST['pwd']), false);

    if(!empty($uname) && !empty($password)){
        //controllo se username e password sono corretti
        try {			
            //connessione al DB	
            $con = new PDO("mysql:host=localhost;dbname=chat", "root", "");
            $con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $query="SELECT username, password FROM utenti WHERE username = '" . $uname . "' AND password = '" . $password ."'";
            $stmt = $con->prepare($query);
            $stmt->execute();  //eseguo la query
            $row = $stmt->fetch(PDO::FETCH_ASSOC);
            $totale = $stmt->rowCount();

            if($totale > 0){
                $_SESSION['username'] = $row['username'];

                echo "success";
            }else{
                echo "Invalid credentials!";
            }

        } catch(PDOException $e) { //controllo errori di connessione
            echo "Error: Failed to connect to DB: " . $e->getMessage();
            die();
        }
    }else{
        echo "All inputs are required!";
    }


?>