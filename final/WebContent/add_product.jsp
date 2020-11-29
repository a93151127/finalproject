<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>新增商品</title>
    <link rel="stylesheet" type="text/css" href="css/public.css">
    <style type="text/css">
        table {
            border-collapse: collapse;
        }

        .boder {
            border: 1px solid #5B96D0;
        }

        .col1 {
            background-color: #A6D2FF;
            text-align: right;
            padding-right: 10px;
            border: 1px solid #5B96D0;
            line-height: 50px;
        }

        .col2 {
            padding-left: 10px;
            border: 1px solid #5B96D0;
            line-height: 50px;
        }

        .textfield {
            height: 20px;
            width: 200px;
            border: 1px solid #999999;
            text-align: left;
            font-size: medium;
            line-height: 50px;
        }
    </style>

    <script>

        function verify(myform) {
            var errorMsg = "";
            if (myform.productCode.value == "") {
                errorMsg += "產品編號不能為空！\n";
            }
            if (myform.productName.value == "") {
                errorMsg += "產品名稱不能为空！\n";
            }
           
            if (myform.productBrand.value == "") {
                errorMsg += "產品品牌不能為空！\n";
            }
			if (myform.buyPrice.value == "") {
                errorMsg += "產品售價不能為空！\n";
            }
			
            
            if (errorMsg == "") {
                return true;
            } else {
                alert(errorMsg);
                return false;
            }
        }

    </script>
</head>

<body>

<br>
<hr width="100%"/>
<div class="text3" align="center">請填寫下列訊息</div>
<br>
<%--显示错误消息--%>
<ul>
    <c:forEach var="error" items="${errors}">
        <li class="error">${error}</li>
    </c:forEach>
</ul>
<form action="Controller2" method="post" onsubmit="return verify(this)" >
    <table width="60%" border="0" align="center" class="boder">
        <tr>
            <td width="35%" height="27" class="col1">產品編號：</td>
            <td class="col2"><input type="text" name="productCode"/>*
            格式 （EX:acer_001）
            </td>
        </tr>
        <tr>
            <td height="27" class="col1">產品名稱：</td>
            <td class="col2"><input type="text" name="productName"/>*
        	</td>
        </tr>
        <tr>
            <td height="27" class="col1">產品品牌：</td>
            <td class="col2"><input type="text" name="productBrand"/>*
            	
            </td>
        </tr>
        <tr>
            <td width="35%" height="27" class="col1">品牌編號：</td>
            <td class="col2"><input type="text" name="productLine"/>*</td>
        </tr>
        <tr>
            <td height="27" class="col1">產品描述：</td>
            <td class="col2"><input type="text" name="productDescription"/></td>
        </tr>
        <tr>
            <td height="27" class="col1">產品售價：</td>
            <td class="col2"><input type="text" name="buyPrice"/>*</td>
        </tr>
        <tr>
            <td height="27" class="col1">圖檔存放位置：</td>
            <td class="col2"><input type="text" name="image1"/></td>
        </tr>
        
    </table>
    <br>
    <div align="center">
        <input type="image" src="images/submit_button.jpg" />
    </div>
    <input type="hidden" name="action" value="productreg" >
    <form/>
    <%@include file="footer.jsp" %>
</body>
</html>
