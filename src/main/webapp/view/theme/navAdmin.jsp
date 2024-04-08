<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${not empty sessionScope.username}">

</c:if>
<c:if test="${not empty sessionScope.username}">
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary p-0">
        <div class="navbar-nav">
            <a class='nav-item nav-link ${requestURI.contains("/movie")?"active":""}' href="../movie/list">Video</a>

            <a class='nav-item nav-link ${requestURI.contains("/user")?"active":""}' href="../user/view">User</a>

        </div>
        <ul class="navbar-nav ms-auto">
            <li class="nav-item">
                <c:if test="${not empty sessionScope.username}">
                    <a class="nav-link disabled text-white" aria-disabled="true">${sessionScope.username}<i
                            class="bi bi-person-circle"></i></a>
                </c:if>
            </li>
            <li class="nav-item dropdown no-arrow">
                <c:if test="${not empty sessionScope.username}">
                    <a class="nav-link active" href="/assignment2_war_exploded/login">
                        Log out
                    </a>
                </c:if>

                <c:if test="${empty sessionScope.username}">
                    <a class="nav-link active" href="/assignment2_war_exploded/login">
                        Log in
                    </a>
                </c:if>
            </li>

        </ul>
    </nav>
</c:if>