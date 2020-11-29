<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>新增辦公室</title>
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
            if (myform.city.value == "") {
                errorMsg += "辦公室城市不能為空！\n";
            }
            if (myform.officeAddress.value == "") {
                errorMsg += "辦公室地址不能为空！\n";
            }
           
            if (myform.postalCode.value == "") {
                errorMsg += "郵遞區號不能為空！\n";
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
            <td width="35%" height="27" class="col1">辦公室城市：</td>
            <td class="col2"><input type="text" name="city"/>*</td>
        </tr>
        <tr>
            <td height="27" class="col1">辦公室地址：</td>
            <td class="col2"><input type="text" name="officeAddress"/>*

        	</td>
        </tr>
        <tr>
            <td height="27" class="col1">郵遞區號：</td>
            <td class="col2"><input type="text" name="postalCode"/>
            	格式 （EX:242）
            </td>
        </tr>
        
    </table>
    <br>
    <div align="center">
        <input type="image" src="images/submit_button.jpg" />
    </div>
    <input type="hidden" name="action" value="officereg" >
    <form/>
    <%@include file="footer.jsp" %>
</body>
</html>
