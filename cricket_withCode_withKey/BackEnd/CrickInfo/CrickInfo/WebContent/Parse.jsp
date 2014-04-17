<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function showHint()
{
	alert("in showHint");
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function()
  	{
  		if (xmlhttp.readyState==4 && xmlhttp.status==200)
    	{
  	    	alert("status got");
  	    	alert("resp: "+xmlhttp.responseText);
    		//parseData(xmlhttp.responseText);
    	}
  	}
  	var url="http://www.espncricinfo.com/netstorage/682939.json?xhr=1";
  	//alert("URL: "+url);
	xmlhttp.open("GET",url,true);
	xmlhttp.send();
}

function parseData(jsonData){
	var obj = JSON.parse(jsonData);

alert("innegs: "+obj.innings);
	
}
	

</script>

</head>
<body>





</body>
</html>