<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>PHP</title>
</head>

<body>
	<h1>Esito upload</h1>
    <?php
        //fileRicevuti è un object contenente i file e tutte le loro informazioni
        $fileRicevuti=$_FILES["txtFile"];
        for($i=0;$i<count($fileRicevuti["name"]);$i++)
        {
            //$fileRicevuto["name"] restituisce il path completo del file ricevuto
            //basename restituisce il vero nome contenuto dopo l'ultimo slash
            //$target_file rappresenta il percorso dove salvare il file sul server
            $target_file = "uploads/" . basename($fileRicevuti["name"][$i]);
            $size=$fileRicevuti["size"][$i];
            $mimeType=$fileRicevuti["type"][$i];
            echo("nome: $target_file<br>");
            echo("size: $size<br>");
            echo("MIMEtype: $mimeType<br>");
            
            if(file_exists($target_file))
                echo("Attenzione il file esiste già<br>");
            else
            {
                echo("file caricato correttamente<br><hr>");
                move_uploaded_file($fileRicevuti["tmp_name"][$i], $target_file);
            }
            //move_uploaded_file esegue la copia fisica del file sul server
            //il primo parametro rappresenta il puntatore al file ricevuto
            //il secondo parametro rappresenta il percorso dove salvare il file
        }
    ?>
    <a href="index.html">INDEX</a>
</body>

</html>