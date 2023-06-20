<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ndl22
  Date: 12/4/2022
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="item" items="${model.listResult}">
    <h1>${item.idAuthor}</h1>
</c:forEach>

<c:forEach var="item" items="${catalogs}">
    <h1>${item.idCatalog}</h1>
</c:forEach>
<c:forEach var = "i" begin = "1" end = "5">
    Item <c:out value = "${i}"/><p>
    </c:forEach>
</body>
</html>
