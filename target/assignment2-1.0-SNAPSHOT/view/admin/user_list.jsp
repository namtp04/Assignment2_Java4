
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/22/2024
  Time: 12:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<h1 class="text-center">Danh sách người dùng</h1>
<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Password</th>
            <th scope="col">Email</th>
            <th scope="col">Fullname</th>
            <th scope="col">Role</th>
            <th scope="col">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lst}" var="us">
            <tr>
                <td>${us.id}</td>
                <td>${us.password}</td>
                <td>${us.email}</td>
                <td>${us.fullname}</td>
                <td>${us.admin?"admin":"user"}</td>
                <td>
                    <a href="update?id=${us.id}" class="btn btn-info">Update</a>
                    <a href="" class="btn btn-warning">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
