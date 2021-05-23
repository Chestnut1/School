<?php
//prima dell'apertura dello script php non bisogna scrivere nulla nemmeno una spazio
//la stessa cosa vale dopo il chiuso php
$nome=$_GET["txtNome"];
//**********************************************
header("Content-Type:text/plain; charset=UTF-8");
$con=new mysqli("localhost","root","","dbBanche");
if($con->connect_errno)
    die("Errore connessione database " . $con->connect_errno . " " . $con->connect_error);
$sql="select * from correntisti WHERE nome='$nome'";
$rs=$con->query($sql);
if(!$rs)
    die("Errore nella query " . $con->errno . " " . $con->error);
//**********************************************
if($rs->num_rows == 1)
   echo("Ok");
else
   echo("Errore");
?>
