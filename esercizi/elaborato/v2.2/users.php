<?php
    session_start();
    if(!isset($_SESSION['username'])){
        header("location: index.php");
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chat</title>

    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.css"/></head>
    <script src="https://kit.fontawesome.com/47307b47fe.js" crossorigin="anonymous"></script>
<body>
    <div class="wrapper">
        <section class="users">
            <header>
            <?php
            include_once "php/config.php";
                try {			
                    //connessione al DB	
                    $con = new PDO("mysql:host=localhost;dbname=chat", "root", "");
                    $con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                    $query="SELECT * FROM utenti WHERE username = '{$_SESSION['username']}'";
                    $stmt = $con->prepare($query);
                    $stmt->execute();  //eseguo la query
                    $row = $stmt->fetch(PDO::FETCH_ASSOC);
                    $totale = $stmt->rowCount();
        
                    if($totale > 0){
                        $_SESSION['nome'] = $row['nome'];
                        $_SESSION['cognome'] = $row['cognome'];
                        $_SESSION['email'] = $row['email'];
                        $_SESSION['nascita'] = $row['nascita'];
                        $_SESSION['immagine'] = $row['immagine'];
                    }else{
                        echo "Invalid credentials!";
                    }
        
                } catch(PDOException $e) { //controllo errori di connessione
                    echo "Error: Failed to connect to DB: " . $e->getMessage();
                    die();
                }
            ?>
                <div class="content">
                    <img src="php/users_profile_images/<?php echo $_SESSION['immagine'];?>" alt="">
                    <div class="details">
                        <span><?php echo $_SESSION['username'] ?></span>
                        <p>Active now</p>
                    </div>
                </div>
                <a href="#" class="logout">Logout</a>
            </header>
            <div class="search">
                <span class="text">Select a user to start a chat</span>
                <input type="text" placeholder="Entare username...">
                <button><i class="fas fa-search"></i></button>
                <!--arrivato al minuti 24.42, non funziona l'icona di riceca, guardare se il link nel css è corretto-->
            </div>
            <div class="users-list">
                <a href="#">
                    <div class="content">
                        <img src="imgs/profile/profile2.jpg" alt="">
                        <div class="details">
                            <span>Tommaso Genovese</span>
                            <p>Test msg</p>
                        </div>
                    </div>
                    <div class="status-dot"><i class="fas fa-circle"></i></div>
                </a>
                <a href="#">
                    <div class="content">
                        <img src="imgs/profile/profile3.jpg" alt="">
                        <div class="details">
                            <span>Tommaso Genovese</span>
                            <p>Test msg</p>
                        </div>
                    </div>
                    <div class="status-dot"><i class="fas fa-circle"></i></div>
                </a>
                <a href="#">
                    <div class="content">
                        <img src="imgs/profile/profile1.jpg" alt="">
                        <div class="details">
                            <span>Tommaso Genovese</span>
                            <p>Test msg</p>
                        </div>
                    </div>
                    <div class="status-dot"><i class="fas fa-circle"></i></div>
                </a>
                <a href="#">
                    <div class="content">
                        <img src="imgs/profile/profile2.jpg" alt="">
                        <div class="details">
                            <span>Tommaso Genovese</span>
                            <p>Test msg</p>
                        </div>
                    </div>
                    <div class="status-dot"><i class="fas fa-circle"></i></div>
                </a>
                <a href="#">
                    <div class="content">
                        <img src="imgs/profile/profile3.jpg" alt="">
                        <div class="details">
                            <span>Tommaso Genovese</span>
                            <p>Test msg</p>
                        </div>
                    </div>
                    <div class="status-dot"><i class="fas fa-circle"></i></div>
                </a>
                <a href="#">
                    <div class="content">
                        <img src="imgs/profile/profile1.jpg" alt="">
                        <div class="details">
                            <span>Tommaso Genovese</span>
                            <p>Test msg</p>
                        </div>
                    </div>
                    <div class="status-dot"><i class="fas fa-circle"></i></div>
                </a>
                
                <!--    34.03   -->
            </div>
        </section>
    </div>

    <script src="javascript/users.js"></script>
</body>
</html>