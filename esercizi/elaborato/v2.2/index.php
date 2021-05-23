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
        <section class="form signup">
            <header>Realtime Chat App</header>
            <form action="singup.php" enctype="multipart/form-data">
                <div class="error-txt"></div>
                <div class="name-details">
                    <div class="field input">
                        <label>First name</label>
                        <input type="text" name="fname" placeholder="First name" required>
                    </div>
                    <div class="field input">
                        <label>Last name</label>
                        <input type="text" name="lname" placeholder="Last name" required>
                    </div>
                </div>
                <div class="field input">
                    <label>Insert your birthday</label>
                    <input type="date" name="date" required>
                </div>
                <div class="field input">
                    <label>Insert your Email</label>
                    <input type="email" name="email" placeholder="Email" required>
                </div>
                <div class="field input">
                    <label>Username</label>
                    <input type="text" name="uname" placeholder="Choose a username" required>
                </div>
                <div class="field input">
                    <label>Insert your Password</label>
                    <input type="password" name="pwd" placeholder="Password" required>
                </div>
                <div class="field image">
                    <label>Profile Image</label>
                    <input type="file"  name="imgprofile" placeholder="Profile Image" required>
                </div>
                <div class="field button">
                    <input type="submit" id="continueBtn" value="Continue to chat">
                </div>
            </form>
            <div class="link">Already signed up? <a href="login.php">Login now</a></div>
        </section>
    </div>

    <script src="javascript/signup.js"></script>
</body>
</html>