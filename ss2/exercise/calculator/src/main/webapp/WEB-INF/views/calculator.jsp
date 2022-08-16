<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 16/08/22
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator Online</title>
</head>
<body>

<form action="/calculate" method="post">
    <input type="number" placeholder="Enter number 1" name="num1" value="${num1}">
    <input type="number" placeholder="Enter number 2" name="num2" value="${num2}">
    <input type="text" placeholder="result" name="result" value="${result}">
    <br>
    <input type="submit" value="add" name="operator">
    <input type="submit" value="subtract" name="operator">
    <input type="submit" value="multiply" name="operator">
    <input type="submit" value="divide" name="operator">
</form>

</body>
</html>
