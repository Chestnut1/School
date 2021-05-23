<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Cookie con PHP - parte 1</title>
</head>
<body>

<?php

if (isset($_COOKIE['cookieNome'])){
	$Nome = $_COOKIE['cookieNome'];
	echo "Ciao $Nome";
	//setcookie ('cookieNome','',-time(),'/'); cancella cookie
	} else {
	echo "Non ti conosco ma puoi dirmi chi sei :<a href=\"inserisci.html\">Inserisci il tuo nome</a>";
}
?>

</body>
</html>
