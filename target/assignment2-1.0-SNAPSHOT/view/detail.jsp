<%@ include file="theme/navbar.jsp" %>
<div class="container mt-3">
    <div class="d-flex">
        <h3 style="flex:1">${video.title}</h3>

    </div>
    <iframe width="100%" height="600px" src="https://www.youtube.com/embed/${video.id}" allowfullscreen></iframe>
    <div class="text-center mt-5">
        <c:if test="${usn1!=null}">
            <c:if test="${fvn!=null}">
                <a class="btn btn-sm border-primary" href="delete?idx=${fv.id}">Remove from favorite list</a>
            </c:if>
            <form action="" method="post">
                <c:if test="${fvn==null}">
                    <button class="btn btn-sm border-primary">Add to favorite list</button>
                </c:if>
            </form>
        </c:if>
    </div>
</div>