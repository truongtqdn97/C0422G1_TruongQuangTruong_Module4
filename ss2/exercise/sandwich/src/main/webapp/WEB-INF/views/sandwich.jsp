<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 16/08/22
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>

<h1>Sandwich Condiments</h1>
<form action="/save">
<c:forEach items="${condiments}" var="condiment">
    <input type="checkbox" name="condimentInput" value="${condiment}"> ${condiment}
</c:forEach>
    <input type="checkbox" name="condimentInput" value="" checked hidden>
    <br>
    <input type="submit" value="Choose">
</form>

<ul>
<c:forEach items="${condimentsChosen}" var="condiment">
    <li>${condiment}</li>
</c:forEach>
</ul>

</body>
</html>
