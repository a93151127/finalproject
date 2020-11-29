<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>刪除錯誤</title>
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
<div class="header">ICShopping網路訂購系統</div>
<hr width="100%" />

<div align="center" >
  <p class="text7"> 此辦公室編號仍有職員存在 </p>
  <p class="text7"> 無法刪除！ </p>
   <p class="text7">
       <a href="main2.jsp">返回主頁面</a>
  </p>

</div>
<%@include file="footer.jsp" %>

</body>
</html>