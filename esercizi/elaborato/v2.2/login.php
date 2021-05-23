<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chat</title>

    <link rel="stylesheet" href="style.css">
    <script src="https://kit.fontawesome.com/47307b47fe.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="wrapper">
        <section class="form login">
            <header>Realtime Chat App</header>
            <form action="#">
                <div class="error-txt"></div>
                <div class="field input">
                    <label>Username</label>
                    <input type="text" name="uname" placeholder="Insert your username">
                </div>
                <div class="field input">
                    <label>Password</label>
                    <input type="password" name="pwd" placeholder="Insert your password">
                </div>
                <div class="field button">
                    <input type="submit" value="Continue to chat">
                </div>
            </form>
            <div class="link">not yet signed up? <a href="index.php">Signup now</a></div>
        </section>
    </div>

    <script src="javascript/login.js"></script>
</body>
</html>