<?php  //la pagina di un Web Service DEVE iniziare con <?php come primissima cosa
	header("content-type:application/json;charset=utf-8"); //tipo di risposta testuale (possono essere testuale,json,xml);
	$id = $_POST["id"];
	$con = new mysqli('localhost','root','','dbautomobili');
	if ($con->connect_errno){
		die("Error: Failed to connect to DB:" . $con->connect_errno . " " . $con->connect_error);
	}		
	$sql = "SELECT * FROM marche WHERE id = '$id' ";
	$rs = $con->query($sql);
	if(!$rs)
		die("Error: Failed to execute query:" . $con->connect_errno . " " . $con->connect_error);
	
	$vet = array();
	while($riga = $rs->fetch_assoc())
		array_push($vet,$riga);
		//$vet[] = $riga;
	echo(json_encode($vet));
?>