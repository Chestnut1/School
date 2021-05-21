<?php
    include_once "config.php";

    //prendo i dati da AJAX
    $fname = mysqli_real_escape_string($conn, $_POST['fname']);
    $lname = mysqli_real_escape_string($conn, $_POST['lname']);
    $birth = mysqli_real_escape_string($conn, $_POST['date']);
    $email = mysqli_real_escape_string($conn, $_POST['email']);
    $uname = mysqli_real_escape_string($conn, $_POST['uname']);
    $password = mysqli_real_escape_string($conn, $_POST['pwd']);


    if(!empty($fname) && !empty($lname) && !empty($email) && !empty($password) && !empty($birth)){
        //controllo se la mail esiste già
        try {			
            //connessione al DB	
            $con = new PDO("mysql:host=localhost;dbname=chat", "root", "");
            $con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $istruzione="SELECT email FROM utenti WHERE email = '" . $email . "'";
            $stmt = $con->prepare($istruzione);
            $stmt->execute();  //eseguo la query
            $row = $stmt->fetch(PDO::FETCH_ASSOC);
            $totale = $stmt->rowCount();

            if($totale==0){ //l'email non è presente nel DB

                //controllo sul tipo di file dell'immagine profilo
                if(isset($_FILES['imgprofile'])){   //controllo se l'utente ha caricato un file

                    //prendo le informazioni dal file caricato
                    $img_name = $_FILES['imgprofile']['name'];
                    $img_type = $_FILES['imgprofile']['type'];
                    $tmp_name = $_FILES['imgprofile']['tmp_name'];  //nome usato per salvare il file nello storage

                    //prendo l'estensione del file
                    $img_explode = explode('.', $img_name);
                    $img_ext = end($img_explode);   //prendo la fine del nome del file (cnaodoadsa.jpg) -> jpg
                    
                    $extensions = ['png', 'jpg', 'jpeg'];    //elenco di estensioni accettate

                    if(in_array($img_ext, $extensions) === true){
                        //l'esntesione del file inserito è accettata

                        $time = time();     //time sarà il nuovo filename. In questo modo si garantisce l'univocità

                        $new_image_name = $time.$img_name;

                        //sposto l'immagine dell'utente in una cartella dedicata
                        if(move_uploaded_file($tmp_name, "users_profile_images".$new_image_name)){
                            $status = "Active now"; //appena registrato imposto il suo stato su attivo
                        }

                        //inserisco i dati all'interno del DB
                        $istruzione="INSERT INTO utenti(username, email, nome, cognome, nascita, immagine, stato) values ('" . $uname . "', '" . $email . "', '" . $fname . "', '" . $lname . "', '" . $birth . "', '" . $new_image_name . "', '" . $status . "')";
                        $stmt = $con->prepare($istruzione);
                        $stmt->execute();  //eseguo la query
                        $row = $stmt->fetch(PDO::FETCH_ASSOC);
                    }else{
                        //se l'estensione non è tra quelle accettate
                        echo "Profile img must be one of this: .pmg, .jpg. jpeg!" ;
                    }

                }else{
                    echo "You must select a profile image!";
                }

            }else{  //l'email è già registrata nel DB
                echo "Email already exist";
            }

            $con = NULL; //chiudo connessione

        } catch(PDOException $e) { //controllo errori di connessione
            echo "Error: Failed to connect to DB: " . $e->getMessage();
            die();
        }
    }else{
        echo "All input fields are required!";
    }
?>