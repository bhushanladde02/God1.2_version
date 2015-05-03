<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="hi" xml:lang="en">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<head>
 
<style>
table,td
{
border:1px solid black;
}
</style>
</head>
<body onload="myFunction1()">

<p>Add News :</p>
<input type="text" id="headerText" name="headerText" placeholder="Title" style="width:100%"/><br/>

<textarea rows="4" cols="50" id="newsDetails" name="newsDetails" style="width:100%;resize: none;" placeholder="Share your news details..."></textarea>

<button onclick="myFunction()">Share News</button> <font color="red" size="2%"><u>For any unauthorized or illegal or bad content will be taken as strict action</u> </font>
<div id="myTable" style="width:100%">
</div>


<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-49582601-2', 'onine.in');
  ga('send', 'pageview');

</script>
<script>
function myFunction()
{
var table = document.getElementById("myTable");
var headerText=document.getElementById("headerText").value;
var newsDetails=document.getElementById("newsDetails").value;
if(headerText!='' && newsDetails!=''){
	table.innerHTML='';

	$.ajax({
		type: 'post',
        url: '/Shiva/ShivaPersist',
        data: {
        	headerText:headerText,
        	newsDetails:newsDetails
        },        
        success: function(data){
            console.log(data);
        	table.innerHTML='<table style=\"width:100%;\">'+data+'</table>';
        	document.getElementById("headerText").value='';
        	document.getElementById("newsDetails").value='';
        	        	
           	//table.innerHtml="<table style=\"width:100%\">"+data+"</table>";
        },
        error:function(){
            alert("failure");
           
        }  
    });

//var row = table.insertRow(0);
//var cell1 = row.insertCell(0);

//cell1.innerHTML ="<b>"+headerText+":</b><br/>"+newsDetails+"";


}
}

function myFunction1()
{
var table = document.getElementById("myTable");
var headerText=document.getElementById("headerText").value;
var newsDetails=document.getElementById("newsDetails").value;
if(headerText=='' || newsDetails==''){
	table.innerHTML='';

	$.ajax({
		type: 'post',
        url: '/Shiva/ShivaPersist',
        data: {
        	headerText:headerText,
        	newsDetails:newsDetails
        },        
        success: function(data){
            console.log(data);
        	table.innerHTML='<table style=\"width:100%;\">'+data+'</table>';
        	document.getElementById("headerText").value='';
        	document.getElementById("newsDetails").value='';
        	        	
           	//table.innerHtml="<table style=\"width:100%\">"+data+"</table>";
        },
        error:function(){
            alert("failure");
           
        }  
    });

//var row = table.insertRow(0);
//var cell1 = row.insertCell(0);

//cell1.innerHTML ="<b>"+headerText+":</b><br/>"+newsDetails+"";


}
}
</script>

</body>
</html>
