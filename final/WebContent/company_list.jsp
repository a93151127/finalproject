<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>會員列表</title>
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
    
        text-indent: 40px
    }

    /*商品列表第2列*/
    .col2 {
        padding-top: 5px;
        border-top: 1px dashed #666666;
        text-align: right;
    }

    /*商品列表第3列*/
    .col3 {
        padding-top: 5px;
        border-top: 1px dashed #666666;
        text-align: right;
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
    }
    .col7 {
        padding-top: 5px;
        border-top: 1px dashed #666666;
        text-align: right;
    }.col8 {
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
<div class="text3" align="center">會員列表</div>
<br>
<table width="100%" border="0" align="center">
    <tr bgcolor="#b4c8ed">
        <th width='5%'>編號</th>
        <th width="10%">名稱</th>
        <th width="10%">電話</th>
		<th width='10%'>地址</th>
		<th >郵件</th>
		<th width="10%">統一編號</th>
		<th width="10%">負責人姓名</th>
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
            <td class="col1">${goods.companyId}</td>
            <td class="col2">${goods.companyName}</td>
            <td class="col3">${goods.companyTel}</td>
			<td class="col4">${goods.companyAddress}</td>
			<td class="col5">${goods.email}</td>
			<td class="col6">${goods.companyNumber}</td>
			<td class="col7">${goods.companyPeople}</td>
			<td class="col8">
			<a href="Controller2?action=companyFind&companyId=${goods.companyId}">編輯</a>
            <a href="Controller2?action=companyDel&companyId=${goods.companyId}">刪除</a>  
			</td>
        </tr>
    </c:forEach>

</table>

<hr/>
<div align="center">
    <ul class="pagination">

        <li><a href="Controller2?action=companypaging&page=prev">«</a></li>
        <c:forEach var="page" begin="1" end="${totalPageNumber}">
            <li><a
                    <c:if test="${page == currentPage}">
                        class="active"
                    </c:if>
                    href="Controller2?action=companypaging&page=${page}">${page}</a></li>
        </c:forEach>
        <li><a href="Controller2?action=companypaging&page=next">»</a></li>
    </ul>
</div>

<%@include file="footer.jsp" %>

</body>
</html>
