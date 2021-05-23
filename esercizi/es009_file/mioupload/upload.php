<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mostra file</title>
</head>
<body>
    <?php
        $target_dir = "uploads/";
        $file_uploaded = $_FILES["fileList"];

        //ciclo per tutti i file ricevuti
        for($i = 0; $i < count($file_uploaded["name"]); $i++){
            $target_file = $target_dir . basename($file_uploaded["name"][$i]);
            
            //controllo se il file esiste già
            if(file_exists($target_file)){
                echo "<br><br>" . basename($file_uploaded["name"][$i]) . " ALREADY EXIST!<br><br><hr>";
                $to_upload = FALSE;
            }else{
                echo "<br><br>name: " . basename($file_uploaded["name"][$i]) . "<br>size: " . $file_uploaded["size"][$i] . "<br><br><hr>";
                $to_upload = TRUE;

                if($to_upload){
                    move_uploaded_file($file_uploaded["tmp_name"][$i], $target_file);
                }
            }
        
        }
    ?>
</body>
</html>