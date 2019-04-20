<header class="page-header">
    <a href="<c:url value="/admin/home"/>"
       class="nav-item ${fn:startsWith(pageContext.request.requestURI, '/admin/home') ? 'active':''}">
        <fmt:message bundle="${lang}" key="home.page.title"/>
    </a>
    <a href="<c:url value="/admin/building"/>"
       class="nav-item ${fn:startsWith(pageContext.request.requestURI, '/admin/building') ? 'active':''}">
        <fmt:message bundle="${lang}" key="building.page.title"/>
    </a>
    <security:authorize access="hasRole('MANAGER')">
        <a href="<c:url value="/admin/user"/>"
           class="nav-item ${fn:startsWith(pageContext.request.requestURI, '/admin/user') ? 'active':''}">
            <fmt:message bundle="${lang}" key="user.page.title"/>
        </a>
    </security:authorize>
</header>