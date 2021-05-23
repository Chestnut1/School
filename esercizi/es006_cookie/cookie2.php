<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Cookie con PHP - parte 3</title>
</head>
<body>
<br>
<?php
$nome=$_GET["txtNome"];
setcookie ("cookieNome",$nome,time()+10,"/");
echo "cookie impostato <a href=\"cookie1.php\"> VERIFICA</a>";
?>
</body>
</html>