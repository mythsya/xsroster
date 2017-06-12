<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <title>排班计划表</title>
  <link rel="stylesheet" href="<c:url value='/static/css/font-awesome.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/bootstrap-3.3.7.min.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/formValidation.min.css'/>">
  
  <link rel="stylesheet" href="<c:url value='/static/css/gc.spread.sheets.10.1.0.css'/>" type="text/css"/>
  <link rel="stylesheet" href="<c:url value='/static/css/gc.spread.sheets.excel2013white.10.1.0.css'/>" type='text/css' title="spread-theme">
  
  <link rel="stylesheet" href="<c:url value='/static/css/inspector.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/insp-table-format.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/insp-slicer-format.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/insp-conditional-formatting.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/colorpicker.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/borderpicker.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/insp-spread.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/excel.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/ztree-metro-style.css'/>">
  <script type="text/javascript">
  var autoOpenExcelId = "${id}";
  </script>
  <script type="text/javascript" src="<c:url value='/static/scripts/jquery-1.11.1.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/jquery-ui-1.10.3.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/bootstrap-3.3.7.min.js'/>"></script>
  
  <script type="text/javascript" src="<c:url value='/static/scripts/formValidation.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/formValidation.popular.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/formValidation.bootstrap.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/formValidation.zh_CN.js'/>"></script>
  
  <script type="text/javascript" src="<c:url value='/static/scripts/gc.spread.sheets.all.10.1.0.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/gc.spread.excelio.10.1.0.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/gc.spread.sheets.print.10.1.0.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/jquery.ztree.all.3.5.28.min.js'/>"></script>

  <script type="text/javascript" src="<c:url value='/static/scripts/FileSaver-1.3.2.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/resources.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/common-util.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/excel-common.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/excel-crud.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/excel.js'/>"></script>
  
</head>
<body class="unselectable">
<c:import url="/static/excel-editor.html" />
</body>
</html>