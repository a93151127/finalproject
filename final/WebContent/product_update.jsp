<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>產品編輯</title>
</head>

<body>
<form action="Controller2" method="post">

<table width="30%" border="1" align="center">
<c:forEach var="list" items="${list}" varStatus="status">
    <tbody>
    <tr>
        <td width="30%">產品編號：</td>
        <td><input type="text" name="productCode" value="${list.productCode}"/>勿修改</td>
    </tr>
    <tr>
        <td>產品名稱：</td>
        <td><input type="text" name="productName" value="${list.productName}" /></td>
    </tr>
    <tr>
        <td>產品線編號：</td>
        <td><input type="text" name="productLine" value="${list.productLint}"/></td>
    </tr>
    <tr>
        <td>產品描述：</td>
        <td><input type="text" name="productDescription" value="${list.productDescription}"/></td>
    </tr>
    <tr>
        <td>產品售價：</td>
        <td><input type="text" name="buyPrice" value="${list.buyPrice}"/></td>
    </tr>
    <tr>
        <td>圖檔位置：</td>
        <td><input type="text" name="image1" value="${list.image1}"/></td>
    </tr>
    <tr>
        <td>產品品牌：</td>
        <td><input type="text" name="productBrand" value="${list.productBrand}"/></td>
    </tr>
    </tbody>
</table>
<div align="center">
        <input type="image" src="images/submit_button.jpg" />
    </div>
    <input type="hidden" name="action" value="productUpdate" >
</c:forEach>
<p>&nbsp;</p>
</form>
</body>
</html>