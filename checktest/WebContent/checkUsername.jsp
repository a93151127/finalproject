<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function showHint(str)
	{
  		if(str.length==0)
    	{ 
    		document.getElementById("txtHint").innerHTML="";
    		return;
    	}

  		xmlHttp=GetXmlHttpObject()
  
  		if(xmlHttp==null)
    	{
    		alert ("連線失敗！");
    		return;
    	}
  
		var url="Controller4";
		url=url+"?username="+str;
		xmlHttp.onreadystatechange= stateChanged;
		xmlHttp.open("GET",url,true);
		xmlHttp.send(null);
	}
	
	function GetXmlHttpObject()
	{
  		var xmlHttp=null;
  		try
    	{
    		// Firefox, Opera 8.0+, Safari
    		xmlHttp=new XMLHttpRequest();
    	}
  		catch(e)
    	{
    		// Internet Explorer
    		try
      		{
      			xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
      		}
    		catch(e)
      		{
      			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      		}
    	}
  		return xmlHttp;
	}
	function stateChanged() 
	{ 
  		if(xmlHttp.readyState==4)
  		{ 
  			document.getElementById("txtHint").innerHTML=xmlHttp.responseText;
  		}
	}
</script>
</head>
<body>
	<form> 
		帳號:<br/>
		<input type="text" id="username" onkeyup="showHint(this.value)"/>
	</form>

	<p>訊息顯示區: <span id="txtHint"></span></p>
</body>
</html>