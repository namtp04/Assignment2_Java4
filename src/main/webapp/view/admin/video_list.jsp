<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/24/2024
  Time: 12:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:if test="${not empty sessionScope.username}">
    <%@include file="/view/theme/navAdmin.jsp"%>
    <h1 class="text-center">Danh sách Video</h1>
    <div class="container">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Title</th>
                <th scope="col">Mô tả</th>
                <th scope="col">Active</th>
                <th scope="col">Image</th>
                <th scope="col">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${empty lstMovie}">
                    <tr>
                        <td colspan="6">No item found</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${lstMovie}" var="mv">
                        <tr>
                            <td>${mv.id}</td>
                            <td style="width: 150px;">${mv.title}</td>
                            <td style="width: 350px;">${mv.description}</td>
                            <td>${mv.active?"Yes":"No"}</td>
                            <td>
                                <img src="${mv.poster}" height="620px">
                            </td>
                            <td width="200px">
                                <a href="update?id=${mv.id}" class="btn btn-info">Update</a>
                                <a onclick="return confirm('Bạn có chắc muốn xóa không?')" href="delete?id=${mv.id}" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
        <a href="../movie/add" class="btn btn-success">Thêm mới</a>
    </div>
</c:if>

</body>
</html>
