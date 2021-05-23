<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Download con PHP - parte 2</title>
</head>
<body>
<?php
$nome_file=$_GET["nome_file"];
$dimensioni_file=$_GET["dimensioni_file"];

header("Content-type: Application/octet-stream");
header("Content-Disposition: attachment; filename=$nome_file");
header("Content-Description: Download PHP");
header("Content-Length: $dimensioni_file");
readfile(".\Downloads\\".$nome_file);
?>
</body>
</html>
