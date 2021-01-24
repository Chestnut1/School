Test page<br>
<?php
	//input
	$risultato=0;
	
	$v=array(0, 0, 0);
	if(isset($_GET["n1"])){
		$v[0]=$_GET["n1"];
	}
	if(isset($_GET["n2"])){
		$v[1]=$_GET["n2"];
	}
	if(isset($_GET["n3"])){
		$v[2]=$_GET["n3"];
	}
	
	if(isset($_GET["btnSomma"])){
		$risultato=$v[0]+$v[1]+$v[2];
	}
	if(isset($_GET["btnDifferenza"])){
		$risultato=$v[0]-$v[1]-$v[2];
	}
	if(isset($_GET["btnMoltiplica"])){
		$risultato=$v[0]*$v[1]*$v[2];
	}
	
	//output: buffer del socket di response -> visualizzato dal client come a fine pagina
	echo "Risultato: " . $risultato . "</br>";
?>