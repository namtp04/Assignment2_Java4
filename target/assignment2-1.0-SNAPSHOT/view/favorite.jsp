<%@ include file="theme/navbar.jsp"%>
<div class="container mt-3">
<form>
    <div class="row">
        <div class="col-9">
            <input class="form-control" placeholder="Enter keyword to search" name="keyword" value="${param.keyword}">
        </div>
        <div class="col-3">
            <button class="btn btn-primary">Search</button>
        </div>
    </div>
</form>
<ul class="list-unstyled row">
        <c:forEach items="${itemsFV}" var="vd">
            <li class="col-4">
                <a href="detail?id=${vd.video.id}" class="text-decoration-none">
                    <div class="card">
                        <c:if test="${vd.video.poster != null}">
                            <img class="card-img-top" src="${vd.video.poster}" alt="" height="620px">
                        </c:if>
                        <c:if test="${vd.video.poster == null}">
                            <img class="card-img-top" src="https://img.myloview.com/stickers/social-media-video-icon-outline-social-media-video-vector-icon-for-web-design-isolated-on-white-background-700-247279065.jpg" alt="">
                        </c:if>
                        <div class="card-body">
                            <h5 class="card-title">${vd.video.title}</h5>
                        </div>
                    </div>
                </a>
            </li>
        </c:forEach>
</ul>
    <c:if test="${itemsFV.size() == 0}">
    <div class="mt-2">No video found</div>
    </c:if>
</div>
