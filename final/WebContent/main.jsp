
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>ICShopping網路訂購系統</title>
    <link rel="stylesheet" type="text/css" href="css/public.css">
    <style type="text/css">
        a:link {
            font-size: 18px;
            color: #DB8400;
            text-decoration: none;
            font-weight: bolder;
        }

        a:visited {
            font-size: 18px;
            color: #DB8400;
            text-decoration: none;
            font-weight: bolder;
        }

        a:hover {
            font-size: 18px;
            color: #DB8400;
            text-decoration: underline;
            font-weight: bolder;
        }
    </style>
</head>

<body>
<jsp:include page="goods_header.jsp" flush="true" >
    <jsp:param name="image" value="list.jpg" />
</jsp:include>
<div class="header">ICShopping網路訂購系統</div>
<hr width="100%"/>
<div>
    <p class="text1"><img src="images/4.jpg" align="absmiddle"/> <a href="Controller?action=list">商品列表</a></p>
    <p class="text2"> 您可以從產品列表中瀏覽感興趣的產品並進行購買 </p>
</div>
<hr width="100%"/>
<div>
    <p class="text1"><img src="images/mycar1.jpg" align="absmiddle"/> <a href="Controller?action=cart">購物車</a></p>
    <p class="text2"> 您可以把感興趣的商品暫時放在購物車中 </p>
</div>
<hr width="100%"/>
<div>
    <p class="text1"><img src="images/4.jpg" align="absmiddle"/> <a href="main3.jsp">顧客留言</a></p>
    <p class="text2"> 您可以把您的意見留在這裡 </p>
</div>
<div class="footer">
    <hr width="100%"/>
    Copyright © ICShopping 2020. All Rights Reserved
</div>
</body>
</html>
