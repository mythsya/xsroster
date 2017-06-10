<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <title>AccessDenied page</title>
</head>
<body>
  <strong>${user}</strong>, You are not authorized to access this page
  <a href="<c:url value="/logout" />">Logout</a>
</body>
</html>