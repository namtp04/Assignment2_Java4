<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/22/2024
  Time: 1:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 class="text-center">Form người dùng</h1>
<form name="userForm" action="" method="post" onsubmit="return validateForm()">
    <c:if test="${empty user1}">
        <p>ID: <input type="text" class="form-control" name="id" value="${user1.id}"></p>
        <p>Password: <input type="password" class="form-control" name="password" value="${user1.password}"></p>
    </c:if>

    <p>Email: <input type="email" class="form-control" name="email" value="${user1.email}"></p>
    <p>Fullname: <input type="text" class="form-control" name="fullname" value="${user1.fullname}"></p>
    <p><div class="form-check">
    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" name="admin" ${user1.admin?"checked":""}>
    <label class="form-check-label" for="flexCheckDefault">
        Admin
    </label>
</div></p>
    <button type="submit" class="btn btn-success">${user1 !=null ?"Update":"Save"}</button>
    <c:if test="${!empty user1}">
        <a href="../user/view" class="btn btn-secondary">Back to save</a>
    </c:if>
</form>

<script>

    function validateForm() {
        var id = document.forms["userForm"]["id"].value;
        var password = document.forms["userForm"]["password"].value;
        var email = document.forms["userForm"]["email"].value;
        var fullname = document.forms["userForm"]["fullname"].value;
        if (id.trim() === "") {
            alert("Vui lòng nhập id người dùng");
            return false;
        }
        if (password.trim() === "") {
            alert("Vui lòng nhập mật khẩu");
            return false;
        }
        if(!/\d/.test(password.trim()) || !/[a-zA-Z]/.test(password.trim())){
            alert("Mật khẩu chứa ít nhất 1 số và 1 chữ cái");
            return false;
        }
        if(password.trim().length<6){
            alert("Mật khẩu lớn hơn 6");
            return false;
        }
        if (email.trim() === "") {
            alert("Vui lòng nhập email người dùng");
            return false;
        }
        if (fullname.trim() === "") {
            alert("Vui lòng nhập tên người dùng");
            return false;
        }
        return true;
    }
</script>

</body>
</html>
