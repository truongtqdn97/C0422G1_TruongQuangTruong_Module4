<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email</title>
</head>
<body>

<form:form action="/update" method="post" modelAttribute="email">
    <fieldset>
        <legend>Settings</legend>
        <label>Languages</label>
        <form:select path="language" items="${languagesList}">
        </form:select>
        <br>
        <label>Page Size</label>
        <form:select path="pageSize" items="${pageSizesList}">
        </form:select>
        <br>
        <label>Spam Filters</label>
        <form:checkbox path="spamFilter" /> Enable spams filter
        <br>
        <label>Signature</label>
        <form:textarea path="signature"/>
        <br>
        <input type="submit" value="Update">
        <input type="reset" value="Cancel">
    </fieldset>
</form:form>

</body>
</html>
