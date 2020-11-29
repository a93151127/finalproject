<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>  
    <title>留言板界面</title>
  </head>
	<script type ="text/javaScript"> 
         function refresh()
         {
             var img=document.getElementById("imgValidationCode");
             img.src="ValidationCode";
         }
         
     </script>
  <body>
	
  <div style="margin-top:100px;font-family:Microsoft YaHei">
   <h1 align="center">這里是留言板主界面</h1>
   <form action="Controller" method="post" onsubmit="return true">
  <table border="1" align="center">
  <caption align="center">所有留言信息</caption>
  
  <tr>
  		<th>廠商名稱</th>
  		<th>統一編號</th>
  		<th>留言標題</th>
  		<th>留言內容</th>
  </tr>
  
  <tr>
  	
  <td><input type="text" name="companyName" value=""/></td>
  <td><input type="text" name="companyNumber" value=""/></td>
  <td><input type="text" name="title" value=""/></td> 
  <td><input type="text" name="content" value=""/></td>
  </tr>
 
  </table>
  <table align="center">
  <tr> 
     <td>
         驗證碼：
     </td> 
     <td> 
         <input type="text" id ="validationCode_id" name="validationCode" style="width:60px;margin-top:10px"/>   
         <img id="imgValidationCode" src="ValidationCode"/> 
         <input type ="button" value="刷新" onclick="refresh()"/>
                  
      </td> 
  </tr>
  </table>
 	 <div align="center">
        <input type="image" src="images/submit_button.jpg" />
    </div>
    <input type="hidden" name="action" value="comment">
    </div>
    <div align="center">
    <a href="main.jsp"> 返回首頁</a>
    </div>
    </form>
  </body>
</html>