<!DOCTYPE html>
<html>
<head> 
    <meta charset="UTF-8"> 
	<title>Esempio Ajax con PHP</title>
	<script type="text/javascript"  src="index.js"> </script>
	<style>
		.myLabel{
			width:75px;
			height:20px;
			text-align:right;
			color:#00A;			
			float:left;
		}
		.myText{
			width:150px;
			height:20px;
			text-align:left;
			color:#000;
			background-color: #EEF;					
			border: 1px solid #AAA;			
			overflow:auto;
		}
	</style>
</head>
<body>
	<h2>Scegli una marca dalla lista</h2>
	<form name="form1">
	    <select id="lstMarche" name="lstMarche" onchange="richiediDettagli()">
        <?php
		$con=new mysqli("localhost","root","","dbautomobili");
		if ($con->connect_errno)
			die ("Errore connessione db " . $con->connect_error);   
		$sql = "select * from marche";
			$rs=$con->query($sql);
		if(!$rs)
			die("Failed to execute query:" . $con->errno ."-" . $con->error);
			
		while($riga=$rs->fetch_assoc())
		{
			$id = $riga['id'];	
			$nome = $riga['nome'];	
			echo("<option value='$id'> $nome </option>");
		}		
		echo("</select>");
		echo("<script> document.getElementById('lstMarche').selectedIndex=-1; </script>");
        ?>		
		
		<br>
		<br>
		<br>
        <div id="dettagli" style="visibility:hidden;border:1px black">
            <div class="myLabel">ID : </div>
            <div class="myText" id="txtID"> </div>
            <div class="myLabel">Marca : </div>
            <div class="myText" id="txtNome"></div>
            <div class="myLabel">Nazione : </div>
            <div class="myText" id="txtNazione"></div>
        </div>
    </form>
</body>
</html>