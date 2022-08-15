<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 15/08/22
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>

<form action="/translate">
    <label>ENG:</label>
    <input type="text" name="eng" value="${eng}">
    <label>VIE:</label>
    <input type="text" name="vie" value="${vie}">
    <input type="submit" value="translate">
</form>

</body>
</html>
