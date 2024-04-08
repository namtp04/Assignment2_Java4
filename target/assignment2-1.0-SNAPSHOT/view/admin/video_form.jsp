<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/24/2024
  Time: 12:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js "
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r "
            crossorigin="anonymous "></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js "
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+ "
            crossorigin="anonymous "></script>
</head>
<body>
<%@include file="/view/theme/navAdmin.jsp"%>
<c:choose>
    <c:when test="${empty movie1}">
        <h1 class="text-center">Add Movie</h1>
    </c:when>
    <c:otherwise>
        <h1 class="text-center">Update Movie</h1>
    </c:otherwise>
</c:choose>
<div class="container">
    <form name="userForm" action="" method="post" onsubmit="return validateForm()">
        <c:if test="${empty movie1}">
            <p>ID: <input type="text" class="form-control" name="id" value="${movie1.id}"><span id="error-id" class="error-message" style="display: none; color: red;">Vui lòng nhập ID</span></p>
        </c:if>
        <p>Title: <input type="text" class="form-control" name="title" value="${movie1.title}"><span id="error-title" class="error-message" style="display: none;  color: red;">Vui lòng nhập Tiêu đề</span></p>
        <p>Mô tả: <textarea class="form-control" name="mota" rows="6">${movie1.description}</textarea></p>
        <p>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault"
                   name="active" ${movie1.active?"checked":""}>
            <label class="form-check-label" for="flexCheckDefault">
                Active
            </label>
        </div>
        </p>
        <p>Ảnh: <input type="text" class="form-control" name="image" value="${movie1.poster}"><span id="error-image" class="error-message" style="display: none;  color: red;">Vui lòng nhập Đường dẫn Ảnh</span></p>

        <button type="submit" class="btn btn-success">${movie1 !=null ?"Update":"Save"}</button>
        <a href="../movie/list" class="btn btn-secondary">Back to view list</a>
    </form>

</div>

<script>

    function validateForm() {
        var id = document.forms["userForm"]["id"].value.trim();
        var title = document.forms["userForm"]["title"].value.trim();
        var image = document.forms["userForm"]["image"].value.trim();

        var isValid = true;


        if (id === "") {
            document.getElementById("error-id").style.display = "block";
            isValid = false;
        } else {
            document.getElementById("error-id").style.display = "none";
        }


        if (title === "") {
            document.getElementById("error-title").style.display = "block";
            isValid = false;
        } else {
            document.getElementById("error-title").style.display = "none";
        }


        if (image === "") {
            document.getElementById("error-image").style.display = "block";
            isValid = false;
        } else {
            document.getElementById("error-image").style.display = "none";
        }

        return isValid;
    }
</script>

</body>
</html>
