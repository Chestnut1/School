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
            <form action="#">
                <div class="error-txt">This is an error message!</div>
                <div class="name-details">
                    <div class="field input">
                        <label>First name</label>
                        <input type="text" placeholder="First name">
                    </div>
                    <div class="field input">
                        <label>Last name</label>
                        <input type="text" placeholder="Last name">
                    </div>
                </div>
                <div class="field input">
                    <label>Insert your Email</label>
                    <input type="text" placeholder="Email">
                </div>
                <div class="field input">
                    <label>Username</label>
                    <input type="text" placeholder="Choose a username">
                </div>
                <div class="field input">
                    <label>Insert your Password</label>
                    <input type="password" placeholder="Password">
                </div>
                <div class="field image">
                    <label>Profile Image</label>
                    <input type="file" placeholder="Profile Image">
                </div>
                <div class="field button">
                    <input type="submit" value="Continue to chat">
                </div>
            </form>
            <div class="link">Already signed up? <a href="login.html">Login now</a></div>
        </section>
    </div>

    <script src="javascript/signup.js"></script>
</body>
</html>