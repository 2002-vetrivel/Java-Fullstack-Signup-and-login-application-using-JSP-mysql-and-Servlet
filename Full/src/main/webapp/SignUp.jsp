<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
<link rel="stylesheet" href="SignUp.css">
</head>
<body>
    <p class="pp"><img class="Image" src="arrow.png" alt="Back to Welcome" onclick="location.href='Welcome.jsp'">SignUp your new Account</p><br>
    <div class="container">
        <img class="logo" src="logo.png" alt="logo">
        <form action="SignUp" method="post" class="Forms">
            <input class="form" name="name" type="text" placeholder="Name" required><br>
            <input class="form" name="email" type="email" placeholder="Email" required><br>
            <input class="form" name="password" type="password" placeholder="Password" required><br>
            <input class="form" name="confirm_password" type="password" placeholder="Confirm Password" required><br>
            <button type="submit">Submit</button>
        </form>
        <p class="ppp">Already have an account<span style="color:#0094FF; cursor:pointer" onclick="location.href = 'Login.jsp'"> Login</span></p>
        
        <% 
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
        %>
        <p style="color:red"><%= errorMessage %></p>
        <% 
        } 
        %>
        
        <% 
        String success = (String) request.getAttribute("success");
        if (success != null) {
        %>
        <p style="color:green"><%= success %></p>
        <% 
        } 
        %>
    </div>
</body>
</html>
