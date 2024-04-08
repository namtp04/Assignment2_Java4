<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/22/2024
  Time: 1:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js "
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r "
            crossorigin="anonymous "></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js "
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+ "
            crossorigin="anonymous "></script>
    <title>Title</title>
</head>
<body>
<%@include file="/view/theme/navAdmin.jsp"%>
<div class="container">
    <div class="row mt-5">
        <div class="col-md-4">
            <%@include file="user_form.jsp"%>
        </div>
        <div class="col-md-1">
            <div style="border-right: 1px solid gray; height: 100%;"></div>
        </div>
        <div class="col-md-7">
            <%@include file="user_list.jsp"%>
        </div>
    </div>

</div>

</body>
</html>
