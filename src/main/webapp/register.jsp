<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="register.css">
</head>
<body>
    <div class="container">
        <h2>Register</h2>
        <form action="register" method="POST">
            <label for="username">Username:</label>
            <input type="text" id="username" name="user_name" required>

            <label for="email">Email Address:</label>
            <input type="email" id="email" name="email_id" required>

            <label for="registerPassword">Password:</label>
            <input type="password" id="registerPassword" name="pass_word" required>

            <label for="mobile">Mobile Number:</label>
            <input type="tel" id="mobile" name="mobile" required pattern="[0-9]{10}">

            <label for="age">Age:</label>
            <input type="number" id="age" name="age" required min="1">

            <button type="submit" >Register</button>
        </form>
        <p id="register-message"></p>
        <p>Already registered? <a href="login_page.jsp">Login here</a></p>
    </div>
</body>
</html>
