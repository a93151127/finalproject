<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>客戶登入</title>
    <link rel="stylesheet" type="text/css" href="css/public.css">
</head>

<body>
<div clasds="header">ICShopping網路訂購系統</div>
<hr width="100%"/>
<%--显示错误消息--%>
<ul>
    <c:forEach var="error" items="${errors}">
        <li class="error">${error}</li>
    </c:forEach>
</ul>

<form action="Controller" method="post">
    <table width="100%" align="center">
        <tr height="40">
            <td colspan="2" align="center"><strong>請您登入</strong></td>
        </tr>
        <tr height="40">
            <td width="50%" align="right"><img src="images/3.jpg" align="absmiddle"/>&nbsp;&nbsp;廠商名稱：</td>
            <td><input type="text" name=companyName" class="textfield"/></td>
        </tr>
        <tr height="40">
            <td width="50%" align="right"><img src="images/2.jpg" align="absmiddle"/>&nbsp;&nbsp;統一編號：</td>
            <td><input type="password" name="companyNumber" class="textfield"/></td>
        </tr>
        <tr height="40">
            <td align="right">&nbsp;</td>
            <td><input type="image" src="images/login_button.jpg" onclick="document.forms[0].fn.value='login'"/>
                &nbsp;&nbsp;&nbsp;&nbsp; <a href="customer_reg.jsp"><img src="images/reg_button.jpg" border="0"/></a>
            </td>
        </tr>
    </table>
    <input type="hidden" name="action" value="login">
</form>
<%@include file="footer.jsp" %>
</body>
</html>