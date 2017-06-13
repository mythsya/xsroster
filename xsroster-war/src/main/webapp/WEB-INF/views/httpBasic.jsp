<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <script type="text/javascript" src="<c:url value='/static/scripts/jquery-1.11.1.js'/>"></script>
  <script type="text/javascript" >
  var contextPath = "<%=request.getContextPath()%>"; 
  
  function doLogout(callback) {
	$.ajax({
		url: contextPath+"/logout",
		type: "get",
		success: function (data, status, xhr) {
			if(callback) callback();
		},
		error: function(xhr, msg, e) {
			if(callback) callback();
		}
	});
  }
  
  function doAuth() {
    $.ajax({
	    headers: {
	    	'Authorization': 'Basic ${authorization}'
	    },
	    url: contextPath+"/basicLogin",
	    type: "get",
	    success: function (data, status, xhr) {
	    	if (data && data.status == "success") {
	    		window.location.href = contextPath+"/home";
	    	} else {
	    		window.location.href = contextPath+"/Access_Denied";
	    	}
	    },
	    error: function(xhr, msg, e) {
	    	window.location.href = contextPath+"/Access_Denied";
	    }
	});
  }
  
  $(document).ready(function() {
	  doLogout(doAuth); 
  });
  </script>
</head>
<body>
</body>
</html>