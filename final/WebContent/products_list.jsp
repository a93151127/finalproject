<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>商品列表</title>
</head>
<link rel="stylesheet" type="text/css" href="css/public.css">
<style type="text/css">
    table {
        border-collapse: collapse;
    }

    /*商品列表第1列*/
    .col1 {
        padding-top: 5px;
        border-top: 1px dashed #666666;
        text-align: center;
        text-indent: 40px
    }

    /*商品列表第2列*/
    .col2 {
        padding-top: 5px;
        border-top: 1px dashed #666666;
        text-align: center;
    }

    /*商品列表第3列*/
    .col3 {
        padding-top: 5px;
        border-top: 1px dashed #666666;
        text-align: center;
    }
    .col4 {
        padding-top: 5px;
        border-top: 1px dashed #666666;
        text-align: center;
    }
    .col5 {
        padding-top: 5px;
        border-top: 1px dashed #666666;
        text-align: right;
    }
    .col6 {
        padding-top: 5px;
        border-top: 1px dashed #666666;
        text-align: right;
    }.col7 {
        padding-top: 5px;
        border-top: 1px dashed #666666;
        text-align: center;
    }
</style>
<body>
<jsp:include page="goods_header2.jsp" flush="true" >
    <jsp:param name="image" value="list.jpg" />
</jsp:include>
<hr width="100%"/>
<div class="text3" align="center">商品列表</div>
<br>
<table width="100%" border="0" align="center">
    <tr bgcolor="#b4c8ed">
        <th width='5%'>編號</th>
        <th width="15%">產品名稱</th>
        <th width="10%">產品品牌</th>
		<th >產品描述</th>
		<th width='5%'>售價</th>
		<th width='15%'>圖檔存放位置</th>
		<th width="10%">操作</th>
    </tr>
    <c:forEach var="goods" items="${goodsList}" varStatus="status">
        <tr
                <c:if test="${status.index % 2 == 0}">
                    bgcolor='#ffffff'
                </c:if>
                <c:if test="${status.index % 2 != 0}">
                    bgcolor='#edf8ff'
                </c:if>
        >
            <td class="col1">${goods.productCode}</td>
            <td class="col2">${goods.productName}</td>
            <td class="col3">${goods.productBrand}</td>
			<td class="col4">${goods.productDescription}</td>
			<td class="col5">${goods.buyPrice}</td>
			<td class="col6">${goods.image1}</td>
			<td class="col7">
			<a href="Controller2?action=productFindFind&productCode=${goods.productCode}">編輯</a>
            <a href="Controller2?action=productDel&productCode=${goods.productCode}">刪除</a>
			</td>
        </tr>
    </c:forEach>

</table>

<hr/>
<div align="center">
    <ul class="pagination">

        <li><a href="Controller2?action=paging&page=prev">«</a></li>
        <c:forEach var="page" begin="1" end="${totalPageNumber}">
            <li><a
                    <c:if test="${page == currentPage}">
                        class="active"
                    </c:if>
                    href="Controller2?action=paging&page=${page}">${page}</a></li>
        </c:forEach>
        <li><a href="Controller2?action=paging&page=next">»</a></li>
    </ul>
</div>

<%@include file="footer.jsp" %>

</body>
</html>
