Test Page <br>

<?php
    $risultato = 0;


    &v = array(0, 0, 0);
    if(isset($_GET["n1"])){
        $v[0] = $_GET["n1"];
    }
    if(isset($_GET["n2"])){
        $v[1] = $_GET["n2"];
    }
    if(isset($_GET["n3"])){
        $v[3] = $_GET["n3"];
    }

    
    if(isset($_GET["btnSomma"]){
        $risultato = $_v[0]+$_v[1]+$_v[2];
    }
    if(isset($_GET["btnDifferenza"]){
        $risultato = $_v[0]-$_v[1]-$_v[2];
    }
    if(isset($_GET["btnMoltiplica"]){
        $risultato = $_v[0]*$_v[1]*$_v[2];
    }

    //output del risultato
    echo "Risultato: " . &risultato ."</br>";



>