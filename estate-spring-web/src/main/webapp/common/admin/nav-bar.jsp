<header class="page-header">
    <a href="<c:url value="/admin/building"/>"
       class="nav-item ${fn:startsWith(pageContext.request.requestURI, '/admin/building') ? 'active':''}">Quản lý
        toà nhà</a>
    <a href="<c:url value="/admin/user"/>"
       class="nav-item ${fn:startsWith(pageContext.request.requestURI, '/admin/user') ? 'active':''}">Quản lý người dùng</a>
</header>