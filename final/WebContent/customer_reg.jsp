<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>客戶註冊</title>
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
            if (myform.companyName.value == "") {
                errorMsg += "廠商名稱不能為空！\n";
            }
            if (myform.companyTel.value == "") {
                errorMsg += "廠商電話不能为空！\n";
            }
            if (myform.companyNumber.value != myform.companyNumber2.value) {
                errorMsg += "两次输入的統一編號不一致！\n";
            }
            if (myform.companyAddress.value == "") {
                errorMsg += "廠商地址不能为空！\n";
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
<div><img src="images/reg.jpg" align="absmiddle"/></div>
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
<form action="Controller" method="post" onsubmit="return verify(this)" >
    <table width="60%" border="0" align="center" class="boder">
        <tr>
            <td width="35%" height="27" class="col1">廠商名稱：</td>
            <td class="col2"><input type="text" name="companyName"/>*</td>
        </tr>
        <tr>
            <td height="27" class="col1">廠商電話：</td>
            <td class="col2"><input type="text" name="companyTel"/>*
        		格式（EX:29921234）
        	</td>
        </tr>
        <tr>
            <td height="27" class="col1">統一編號：</td>
            <td class="col2"><input type="password" name="companyNumber"/>*
            	格式 （EX:12345678）
            </td>
        </tr>
        <tr>
            <td height="27" class="col1">再次統一編號：</td>
            <td class="col2"><input type="password" name="companyNumber2"/>*</td>
        </tr>
        <tr>
            <td height="27" class="col1">廠商地址：</td>
            <td class="col2"><input type="text" name="companyAddress"/>*</td>
        </tr>
        <tr>
            <td height="27" class="col1">負責人：</td>
            <td class="col2"><input type="text" name="companyPeople"/></td>
        </tr>
        <tr>
            <td height="27" class="col1">電子郵件：</td>
            <td class="col2"><input type="text" name="email"/></td>
        </tr>
    </table>
    <br>
    <div align="center">
        <input type="image" src="images/submit_button.jpg" />
    </div>
    <input type="hidden" name="action" value="reg" >
    <form/>
    <%@include file="footer.jsp" %>
</body>
</html>
