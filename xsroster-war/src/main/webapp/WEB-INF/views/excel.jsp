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
  
  <script type="text/javascript" src="<c:url value='/static/scripts/browser.js'/>"></script>
  <script type="text/javascript">
  var autoOpenExcelId = "${id}";
  var autoOpenLatest = false;
  if(!BrowserDetect.isCompatibleBrowser()) {
	  window.location.href = "<%=request.getContextPath()%>/excel/viewer";
  }
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
<div class="toolbar" id="toolbar">
    <div class="toolbar-left-section">
        <div class="toolbar-spread">
            <div class="sample-head-text">&nbsp;</div>
        </div>
        <div class="btn-group" role="group" aria-label="toolbar" style="margin-top: 10px;margin-left:10px;">
            <div>
                <div class="insp-row">
                    <div>
                    	<span class="label label-default" style="font-size:12px;">${user.getUsername()}</span>
                    	<button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="doLogout"
                                title="@toolBar.logout.title@">
                            <span class="glyphicon glyphicon-log-out fa-2x"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="doConfig"
                                title="@toolBar.configTitle@">
                            <span class="fa fa-gear fa-2x"></span>
                        </button>
                        
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="doCreate"
                                title="@toolBar.create.title@">
                            <span class="fa fa-pencil-square-o fa-2x"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="doSave"
                                title="@toolBar.save.title@">
                            <span class="fa fa-save fa-2x"></span>
                        </button>
                        <!-- 
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="doTag"
                                title="@toolBar.tag.title@">
                            <span class="fa fa-tags fa-2x"></span>
                        </button>
                        -->
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="doPublish"
                                title="@toolBar.publish.title@">
                            <span class="fa fa-send fa-2x"></span>
                        </button>
                        <!-- 
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="doPrint"
                                title="@toolBar.printTitle@">
                            <span class="fa fa-print fa-2x"></span>
                        </button>
                         -->
                        <div style="width:20px;"></div>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="doImport"
                                title="@toolBar.import.title@">
                            <span class="fa fa-cloud-upload fa-2x"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="doExport"
                                title="@toolBar.export.title@">
                            <span class="fa fa-file-excel-o fa-2x"></span>
                        </button>
                        <div style="width:20px;"></div>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="doClear"
                                title="@toolBar.clear.title@">
                            <span class="fa fa-eraser fa-2x"></span>
                        </button>
                        
                        <div class="insp-dropdown-list insp-inline-row v-middle localize-tooltip"
                             data-list-ref="zoomList" data-name="zoomSpread" title="@toolBar.zoom.title@" style="width:70px;">
                            <div class="dropdown insp-inline-row-item btn btn-default insp-text-right insp-col-12 btn-zoom btn-hover">
                                <div style="width: 100%; height: 100%">
                                    <span class="display btn-zoom-text"></span><span class="caret"></span>
                                </div>
                            </div>
                        </div>
                        
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="toolbar-middle-section">
        <div class="btn-group" role="group" aria-label="toolbar" style="margin-top: 10px;">
            <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="addtable"
                    title="@toolBar.insertTable@">
                <span class="fa fa-table fa-2x"></span>
            </button>
            <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="addpicture"
                    title="@toolBar.insertPicture@">
                <span class="fa fa-picture-o fa-2x"></span>
            </button>
            <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="addcomment"
                    title="@toolBar.insertComment@">
                <span class="fa fa-comments fa-2x"></span>
            </button>
            <div class="btn-group" role="group">
                <button type="button" class="btn btn-default btn-toolbar dropdown-toggle localize-tooltip"
                        data-toggle="dropdown" aria-expanded="false" title="@toolBar.insertSparkline@">
                    <span class="fa fa-bar-chart-o fa-2x"></span>
                </button>
                <ul class="dropdown-menu" role="menu" id="sparklineextypes">
                    <li>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="lineSparkline"
                                title="@sparklineDialog.sparklineExType.values.line@">
                            <span class="ui-icon sparkline-line"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="columnSparkline"
                                title="@sparklineDialog.sparklineExType.values.column@">
                            <span class="ui-icon sparkline-column"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="winlossSparkline"
                                title="@sparklineDialog.sparklineExType.values.winLoss@">
                            <span class="ui-icon sparkline-winloss"></span>
                        </button>
                    </li>
                    <li>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="pieSparkline"
                                title="@sparklineDialog.sparklineExType.values.pie@">
                            <span class="ui-icon sparkline-pie"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="areaSparkline"
                                title="@sparklineDialog.sparklineExType.values.area@">
                            <span class="ui-icon sparkline-area"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="scatterSparkline"
                                title="@sparklineDialog.sparklineExType.values.scatter@">
                            <span class="ui-icon sparkline-scatter"></span>
                        </button>
                    </li>
                    <li>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="spreadSparkline"
                                title="@sparklineDialog.sparklineExType.values.spread@">
                            <span class="ui-icon sparkline-spread"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="stackedSparkline"
                                title="@sparklineDialog.sparklineExType.values.stacked@">
                            <span class="ui-icon sparkline-stacked"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="boxplotSparkline"
                                title="@sparklineDialog.sparklineExType.values.boxplot@">
                            <span class="ui-icon sparkline-boxplot"></span>
                        </button>
                    </li>
                    <li>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="cascadeSparkline"
                                title="@sparklineDialog.sparklineExType.values.cascade@">
                            <span class="ui-icon sparkline-cascade"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="paretoSparkline"
                                title="@sparklineDialog.sparklineExType.values.pareto@">
                            <span class="ui-icon sparkline-pareto"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="bulletSparkline"
                                title="@sparklineDialog.sparklineExType.values.bullet@">
                            <span class="ui-icon sparkline-bullet"></span>
                        </button>
                    </li>
                    <li>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="hbarSparkline"
                                title="@sparklineDialog.sparklineExType.values.hbar@">
                            <span class="ui-icon sparkline-hbar"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="vbarSparkline"
                                title="@sparklineDialog.sparklineExType.values.vbar@">
                            <span class="ui-icon sparkline-vbar"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="variSparkline"
                                title="@sparklineDialog.sparklineExType.values.variance@">
                            <span class="ui-icon sparkline-variance"></span>
                        </button>
                    </li>
                    <li>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="monthSparkline"
                                title="@sparklineDialog.sparklineExType.values.month@">
                            <span class="ui-icon sparkline-hbar"></span>
                        </button>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="yearSparkline"
                                title="@sparklineDialog.sparklineExType.values.year@">
                            <span class="ui-icon sparkline-vbar"></span>
                        </button>
                    </li>
                </ul>
            </div>
            <button type="button" class="btn btn-default btn-toolbar localize-tooltip hidden" id="addslicer"
                    title="@toolBar.insertSlicer@">
                <span class="fa fa-filter fa-2x"></span>
            </button>
        </div>
    </div>
    <div class="toolbar-right-section">
        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="toggleInspector"
                title="@toolBar.hideInspector@">
            <span class="fa fa-angle-right fa-2x"></span>
        </button>        
    </div>
    <div style="position:absolute; color: #fff; min-width: 250px; right: 0; top:1px; font-size:14pt;">
    	<input type="hidden" id="current_roster_name" name="roster.name" value=""/>
    	<input type="hidden" id="current_roster_id" name="roster.id" value=""/>
    	<input type="hidden" id="current_roster_tag" name="roster.tag" value=""/>
    	<span id="current_roster_name_lbl" class="localize" style="display: inline-block; width:100%; height: 48px; text-align:center; padding-top:10px;">@toolBar.newexcel.tempname@</span>
    </div>
</div>

<c:import url="/static/excel-editor.html" />
</body>
</html>