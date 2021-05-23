<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>PHP</title>
</head>

<body>
	<?php
	require_once './Pos/RemoteConnector.php';
	require_once './Pos/LIB_parse.php';
	$url = 'http://www.itiscuneo.gov.it/';
	try {

		$servername = "localhost";
		$username = "root";
		$password = "";
		$con = new PDO("mysql:host=$servername;dbname=scraping", $username, $password);
		$con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

		$command = $con->prepare("SELECT idURL, URL FROM inputurl WHERE protocollo = 'http' ");
		$rows = $command->fetchall(PDO::FETCH_ASSOC);

		foreach ($rows as $url) {
			$output = new Pos_RemoteConnector($url);
			if (strlen($output)) {
				$output = tidy_html($output);
				echo "<debug-titolo=>Titolo: </debug-titolo=>" . $title . "<hr>";
				
				$body = remove($output, "<html>", "</head>");

				echo "<hr>";

				$links = parse_array($body, "<a HREF=", ">");
				echo "<h3>Link esterni al sito trovati nella pagina: </h3><br>";
				$i=1;
				foreach($links as $link){
					$value = get_attribute($link, "HREF");
					if (substr($value, 0, 4) == "http") { 
						//testare risultato
						$command = $con->prepare("INSERT INTO dati (URLestratto, idURLorigine, protocollo) VALUES ($value, $link, 'http')");
						$command->execute();
						echo "N." . $i . ": " . $value . "<br>";
						$i++;
					}			
				}
				//echo "<hr>";
				//print json_encode($links);
			} else {
				echo $output->getErrorMessage();
			}
		}

		
	} catch (Exception $e) {
		echo $e->getMessage();
	}
	?>


</body>