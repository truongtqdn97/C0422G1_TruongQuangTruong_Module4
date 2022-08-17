<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tờ khai y tế</title>
    <style>
        span{
            color: red;
        }
    </style>
</head>
<body>

<h3 style="text-align: center">TỜ KHAI Y TẾ</h3>
<h5 style="text-align: center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT
    ĐỂ PHÒNG CHÓNG DỊCH BỆNH TRUYỀN NHIỄM
</h5>
<p style="text-align: center;color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam
    và có thể xử lý hình sự
</p>

<form:form action="/send" method="post" modelAttribute="medical">
    <div>Họ tên (ghi chữ IN HOA) <span>(*)</span> </div>
    <div>
        <form:input path="name"/>
    </div>
    <div>
        <table>
            <tr>
                <th>Năm sinh<span>(*)</span></th>
                <th>Giới tính<span>(*)</span> </th>
                <th>Quốc tịch<span>(*)</span></th>
            </tr>
            <tr>
                <td>
                    <form:select path="year" items="${yearOfBirth}"/>
                </td>
                <td>
                    <form:select path="gender" items="${genderList}"/>
                </td>
                <td>
                    <form:select path="nation" items="${nationList}"/>
                </td>
            </tr>
        </table>
    </div>
    <div>
        Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span>(*)</span>
    </div>
    <div>
        <form:input path="idCard"/>
    </div>
    <div>
        Thông tin đi lại <span>(*)</span>
    </div>
    <div>
        <form:radiobuttons path="vehicle" items="${vehicleList}"/>
    </div>
    <div>
        <table>
            <tr>
                <th>Số hiệu phương tiện</th>
                <th>Số ghế</th>
            </tr>
            <tr>
                <td>
                    <form:input path="vehicleId" />
                </td>
                <td>
                    <form:input path="seat"/>
                </td>
            </tr>
        </table>
    </div>
    <div>
        <table>
            <tr>
                <th colspan="3">Ngày khởi hành <span>(*)</span></th>
                <th colspan="3">Ngày kết thúc <span>(*)</span></th>
            </tr>
            <tr>
                <td>
                    <form:select path="startDay" items="${dayList}"/>
                </td>
                <td>
                    <form:select path="startMonth" items="${monthList}"/>
                </td>
                <td>
                    <form:select path="startYear" items="${yearList}"/>
                </td>
                <td>
                    <form:select path="endDay" items="${dayList}"/>
                </td>
                <td>
                    <form:select path="endMonth" items="${monthList}"/>
                </td>
                <td>
                    <form:select path="endYear" items="${yearList}"/>
                </td>
            </tr>
        </table>
    </div>
    <div>
        Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào? <span>(*)</span>
    </div>
    <div>
        <form:input path="city"/>
    </div>

</form:form>

</body>
</html>
