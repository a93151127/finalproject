<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>員工編輯</title>
</head>

<body>
<form action="Controller2" method="post">

<table width="30%" border="1" align="center">
<c:forEach var="list" items="${list}" varStatus="status">
    <tbody>
    <tr>
        <td width="30%">員工ID：</td>
        <td><input type="text" name="employeeId" value="${list.employeeId}"/>勿修改</td>
    </tr>
    <tr>
        <td>員工姓名：</td>
        <td><input type="text" name="employeeName" value="${list.employeeName}" /></td>
    </tr>
    <tr>
        <td>員工電話：</td>
        <td><input type="text" name="employeeTel" value="${list.employeeTel}"/></td>
    </tr>
    <tr>
        <td>電子郵件：</td>
        <td><input type="text" name="email" value="${list.email}"/></td>
    </tr>
    <tr>
        <td>員工職務：</td>
        <td><input type="text" name="jobTitle" value="${list.jobTitle}"/></td>
    </tr>
    <tr>
        <td>辦公室編號：</td>
        <td><input type="text" name="officeCode" value="${list.officeCode}"/></td>
    </tr>
    
    </tbody>
</table>
<div align="center">
        <input type="image" src="images/submit_button.jpg" />
    </div>
    <input type="hidden" name="action" value="employeeUpdate" >
</c:forEach>
<p>&nbsp;</p>
</form>
</body>
</html>