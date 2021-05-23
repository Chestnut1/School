<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Download con PHP - parte 1</title>
</head>
<body>
<table border=8 width=40% align=CENTER border=3>
<TR><TH>Fai clic sui link per scaricare i file</TH></TR>
<?php # elenco dei contenuti di una cartella con link
$cartella = opendir('.\Downloads');

while ($file = readdir($cartella)) {
	$array_file[] = $file;
}

//echo  "Contenuto array: " . implode(" ", $array_file);

foreach ($array_file as $file) {
	echo "<TR><TD><CENTER>";
	if ( $file == ".." || $file == ".") continue;
	$dimensioni_file=filesize(".\Downloads\\".$file);
	echo "<a href=\"down.php?nome_file=$file&dimensioni_file=$dimensioni_file\">$file</a>,<BR>";	
	echo "</TR></TD></CENTER>";
}

?>
</table>
</body>
</html>