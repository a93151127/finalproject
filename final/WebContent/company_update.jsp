<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>會員編輯</title>
</head>

<body>
<form action="Controller2" method="post">

<table width="30%" border="1" align="center">
<c:forEach var="list" items="${list}" varStatus="status">
    <tbody>
    <tr>
        <td width="30%">廠商ID：</td>
        <td><input type="text" name="companyId" value="${list.companyId}"/>勿修改</td>
    </tr>
    <tr>
        <td>廠商名稱：</td>
        <td><input type="text" name="companyName" value="${list.companyName}" /></td>
    </tr>
    <tr>
        <td>廠商電話：</td>
        <td><input type="text" name="companyTel" value="${list.companyTel}"/></td>
    </tr>
    <tr>
        <td>廠商地址：</td>
        <td><input type="text" name="companyAddress" value="${list.companyAddress}"/></td>
    </tr>
    <tr>
        <td>統一編號：</td>
        <td><input type="text" name="companyNumber" value="${list.companyNumber}"/></td>
    </tr>
    <tr>
        <td>負責人：</td>
        <td><input type="text" name="companyPeople" value="${list.companyPeople}"/></td>
    </tr>
    <tr>
        <td>電子郵件：</td>
        <td><input type="text" name="email" value="${list.email}"/></td>
    </tr>
    </tbody>
</table>
<div align="center">
        <input type="image" src="images/submit_button.jpg" />
    </div>
    <input type="hidden" name="action" value="companyUpdate" >
</c:forEach>
<p>&nbsp;</p>
</form>
</body>
</html>