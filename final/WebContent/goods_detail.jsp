<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>商品資訊</title>
    <link rel="stylesheet" type="text/css" href="css/public.css">
    <style type="text/css">
        .title {
            font-size: 20px;
            color: #FF6600;
            font-style: italic;
        }
    </style>
</head>
<body>
<jsp:include page="goods_header.jsp" flush="true" >
    <jsp:param name="image" value="info.jpg" />
</jsp:include>
<hr width="100%"/>
<div class="text3" align="center">${goods.productDescription}</div>
<table width="100%" border="0" align="center">
    <tr>
        <td width="40%" align="right">
            <div><img src="goods_images/${goods.image1}" width="360px" height="360px"/></div>
            <br></td>
        <td>
            <div align="center" class="text4">一 口 價：<span class="title">${goods.buyPrice}元</span></div>
            <br>
            <table width="80%" height="200" border="0">
                <tbody>
                <tr>
                    <td width="25%" class="text5">產品品牌：</td>
                    <td width="25%" class="text6">${goods.productBrand}</td>
                    <td width="25%" class="text5">產品名稱：</td>
                    <td width="25%" class="text6">${goods.productName}</td>
                </tr>
                <tr>
                    <td class="text5">產品售價：</td>
                    <td class="text6">${goods.buyPrice}</td>
                    <td class="text5">        </td>
                </tr>
                
                </tbody>
            </table>
            <br>
            <br>
            <div><a href="Controller?action=add&pagename=detail&id=${goods.productCode}&name=${goods.productName}&price=${goods.buyPrice}"><img src="images/button.jpg"/></a></div>
        </td>
    </tr>
</table>
<%@include file="footer.jsp" %>
</body>
</html>
