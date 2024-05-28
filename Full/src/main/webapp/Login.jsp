<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel= "stylesheet" href="Login.css">
</head>
<body>
<p class="pp"><img class="Image" src="arrow.png" alt="Back to Welcome" onclick="location.href='Welcome.jsp'">   SignIn your Account</p><br>
    <div class="container">
        <img class="logo" src="logo.png" alt="logo">
        <form action="Login" method="post" class="Forms">
            <input class="form" name="email" type="email" placeholder="Email" required><br>
            <input class="form" name="password" type="password" placeholder="Password" required><br>
            <button type="submit">Submit</button>
        </form>
        <p class="ppp">Don't have an account<span style="color:#0094FF; cursor:pointer" onclick="location.href = 'SignUp.jsp'"> SignUp</span></p>
        
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