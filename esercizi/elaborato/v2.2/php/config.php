<?php
    $conn = mysqli_connect("localhost", "root", "", "chat");

    if(!$conn){
        echo "Error connecting to DB: " . mysqli_connect_error();
    }

?>