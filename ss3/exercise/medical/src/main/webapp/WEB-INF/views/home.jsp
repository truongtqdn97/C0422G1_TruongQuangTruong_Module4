<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<h1 style="text-align: center">Danh sách tờ khai</h1>
<button class="btn btn-success">
    <a href="/show-form" class="text-light text-decoration-none">Thêm tờ khai</a>
</button>
<c:if test="${msgCreate!=null}">
    <p class="text-success" style="text-align: center">${msgCreate}</p>
</c:if>
<c:if test="${msgUpdate!=null}">
    <p class="text-success" style="text-align: center">${msgUpdate}</p>
</c:if>
<table class="table table-striped">
    <thead>
    <tr class="table-info">
        <th scope="col">STT</th>
        <th scope="col">Họ và tên</th>
        <th scope="col">Năm sinh</th>
        <th scope="col">Giới tính</th>
        <th scope="col">Quốc tịch</th>
        <th scope="col">CMND</th>
        <th scope="col">Phương tiện di chuyển</th>
        <th scope="col">Ngày khởi hành</th>
        <th scope="col">Ngày kết thúc</th>
        <th scope="col">Nơi đi qua</th>
        <th scope="col">Chỉnh sửa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${medicalList}" var="medical" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${medical.name}</td>
            <td>${medical.year}</td>
            <td>${medical.gender}</td>
            <td>${medical.nation}</td>
            <td>${medical.idCard}</td>
            <td>${medical.vehicle}</td>
            <td>${medical.startDay}/${medical.startMonth}/${medical.startYear}</td>
            <td>${medical.endDay}/${medical.endMonth}/${medical.endYear}</td>
            <td>${medical.city}</td>
            <td><a href="/updateForm/${medical.medicalId}">Sửa</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
