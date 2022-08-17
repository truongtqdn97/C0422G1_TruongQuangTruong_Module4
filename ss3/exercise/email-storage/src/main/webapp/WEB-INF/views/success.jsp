<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display</title>
</head>
<body>

<div>
    Language: ${email.language}
</div>
<div>
    Page Size: ${email.pageSize}
</div>
<div>
    Spam filter:
    <c:if test="${email.spamFilter==true}">
        <span>Enable</span>
    </c:if>
    <c:if test="${email.spamFilter==false}">
        <span>Disable</span>
    </c:if>
</div>
<div>
    Signature: ${email.signature}
</div>

</body>
</html>
