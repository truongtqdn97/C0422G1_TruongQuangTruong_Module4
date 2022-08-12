<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/08/22
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>
    CURRENCY CONVERTER
</h1>
<form action="/convert">
    <label>USD:</label>
    <input type="number" name="usd" value="${usd}">
    <input type="submit" value="Convert">
</form>

<label>VND:</label>
<input type="number" value="${vnd}">

</body>
</html>
