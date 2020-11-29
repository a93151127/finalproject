<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>辦公室編輯</title>
</head>

<body>
<form action="Controller2" method="post">

<table width="30%" border="1" align="center">
<c:forEach var="list" items="${list}" varStatus="status">
    <tbody>
    <tr>
        <td width="30%">辦公室編號：</td>
        <td><input type="text" name="officeCode" value="${list.officeCode}"/>勿修改</td>
    </tr>
    <tr>
        <td>所在地城市：</td>
        <td><input type="text" name="city" value="${list.city}" /></td>
    </tr>
    <tr>
        <td>辦公室地址：</td>
        <td><input type="text" name="officeAddress" value="${list.officeAddress}"/></td>
    </tr>
    <tr>
        <td>郵遞區號：</td>
        <td><input type="text" name="postalCode" value="${list.postalCode}"/></td>
    </tr>
    </tbody>
</table>
<div align="center">
        <input type="image" src="images/submit_button.jpg" />
    </div>
    <input type="hidden" name="action" value="officeUpdate" >
</c:forEach>
<p>&nbsp;</p>
</form>
</body>
</html>