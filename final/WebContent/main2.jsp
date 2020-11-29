
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
<jsp:include page="goods_header2.jsp" flush="true" >
    <jsp:param name="image" value="list.jpg" />
</jsp:include>
<div class="header">ICShopping後台管理系統</div>
<hr width="100%"/>
<div>
    <p class="text1"><img src="images/4.jpg" align="absmiddle"/><h2>訂單管理</h2></p>
	<p class="text2"><a href="Controller2?action=orderlist">訂單列表</a></p>
	<p class="text2"><a href="Controller2?action=ordersdetaillist">訂單明細列表</a></p>
</div>
<hr width="100%"/>
<div>
    <p class="text1"><img src="images/4.jpg" align="absmiddle"/><h2>商品管理<h2></p>
    <p class="text2"><a href="Controller2?action=list">商品列表</a></p>
	<p class="text2"><a href="Controller2?action=productreg">新增商品</a></p>
</div>
<hr width="100%"/>
<div>
    <p class="text1"><img src="images/4.jpg" align="absmiddle"/><h2>員工管理<h2></p>
    <p class="text2"><a href="Controller2?action=employeelist">職員列表</a></p>
	<p class="text2"><a href="Controller2?action=employeereg">新增職員</a></p>
	<p class="text2"><a href="Controller2?action=officelist">辦公室列表</a></p>
	<p class="text2"><a href="Controller2?action=officereg">新增辦公室</a></p>
</div>
<hr width="100%"/>
<div>
    <p class="text1"><img src="images/4.jpg" align="absmiddle"/><h2>會員管理<h2></p>
    <p class="text2"><a href="Controller2?action=companylist">會員列表</a></p>
    <p class="text2"><a href="Controller2?action=columnlist">留言板列表</a></p>
</div>
<div class="footer">
    <hr width="100%"/>
    Copyright © ICShopping 2020. All Rights Reserved
</div>
</body>
</html>