<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/7/2024
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .bg-signup {
            position: relative;
            width: 100%;
            min-height: auto;
            background-position: right 0px top 0px;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            background-size: cover;
            -o-background-size: cover;
        }

        .signup-form {
            border: 1px solid #DDD;
            border-radius: 4px;
            max-width: 400px;
            padding: 20px;
            margin-top: 100px;
            margin-left: auto;
            margin-right: auto;
        }

    </style>
</head>
<body>
<div class="bg-signup">
    <div class="signup-form">
        <h3>Login</h3>
        <br>
        <form method="post">
            <div class="mb-3">
                <label class="form-label">Username:</label>
                <input name="usname" type="text" class="form-control"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Password:</label>
                <input name="password" type="password" class="form-control"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Fullname:</label>
                <input name="fullname" type="text" class="form-control"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Email:</label>
                <input name="email" type="email" class="form-control"/>
            </div>
            <div class="mb-3">
                <input name="admin" type="checkbox" class="form-input-check"/>
                <label class="form-label">Admin</label>

            </div>
            <div>
                <span id="error" style="color:red">${message}</span>
            </div>
            <br>
            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Signup</button>
            </div>
        </form>
        <p class="text-center"><a href="/assignment2_war_exploded/login">Login</a></p>
    </div>
</div>
</body>
</html>
