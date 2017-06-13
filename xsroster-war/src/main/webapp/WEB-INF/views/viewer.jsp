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
  
  <link rel="stylesheet" href="<c:url value='/static/css/inspector.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/insp-table-format.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/insp-slicer-format.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/insp-conditional-formatting.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/colorpicker.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/borderpicker.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/insp-spread.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/excel.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/viewer.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/ztree-metro-style.css'/>">
  <script type="text/javascript">
  var autoOpenExcelId = "${id}";
  var autoOpenLatest = true;
  </script>
  <script type="text/javascript" src="<c:url value='/static/scripts/jquery-1.11.1.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/bootstrap-3.3.7.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/jquery.ztree.all.3.5.28.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/resources.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/common-util.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/viewer.js'/>"></script>
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
                        <div style="width:10px;"></div>
						<button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="doExport"
                                title="@toolBar.export.title@">
                            <span class="fa fa-file-excel-o fa-2x"></span>
                        </button>
                        <!-- -
                        <div style="width:10px;"></div>
                        <button type="button" class="btn btn-default btn-toolbar localize-tooltip" id="doPrint"
                                title="@toolBar.printTitle@">
                            <span class="fa fa-print fa-2x"></span>
                        </button>
                         -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="toolbar-middle-section">

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

<div class="content-container">
	<div id="inner-content-container">
        <table id="formulaBar" style="width: 100%; ">
            <tbody>
            <tr>
                <td style="width: 100%; border-left: 1px solid #ccc;">
                    <ul id="excel-sheet-nav" class="nav nav-tabs nav-tabs-narrow" role="tablist">						
						<li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Sheet1</a></li>
					</ul>
                </td>
            </tr>
            </tbody>
        </table>
        <div class="spread-container" id="controlPanel" style="height: 99%; bottom: 0;">
            <div id="excel-tab-content" class="tab-content" style="height:100%; ">
            	 <div role="tabpanel" class="tab-pane active" id="home"></div>
            </div>
        </div>
	</div>
	<div class="insp-container">
		<div>
			<ul class="nav nav-tabs nav-justified">
				<li class="insp-cate-tab">
                    <a href="#rosterHistroyTreeTab" data-toggle="tab" class="localize">@tabs.rosterHistroy@</a>
                </li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="rosterHistroyTreeTab">
                    <div class="insp-pane">
                        <div class="insp-group-layout" style="height:99%;">
                            <div class="insp-group expanded" style="height:60%;">
                                <ul id="roster-histroy-tree-container" class="ztree" style="margin:1px; height:auto; border: 1px solid #ccc; min-height:300px; height:99%;"></ul>
                            </div>
                            <div class="insp-group expanded">
                                <div class="insp-group-content" style="height:20px;">
                                </div>
                            </div>
                            <div class="insp-group expanded">
                                <div class="insp-group-content">
                                    <div>
                                        <div class="insp-row">
                                            <div>
                                                <div class="insp-buttons insp-inline-row">
                                                   	<div class="insp-inline-row-item content">
                                                        <div class="item">
                                                            <button id="doOpenSelectedRoster" class="button btn btn-lg btn-primary localize" id="sortAZ">@histroyTab.general.openButtonTitle@</button>
                                                        </div>
                                                    </div>
                                                    <div class="insp-inline-row-item content" style="height:20px;"></div>
                                                   	<div class="insp-inline-row-item content">
                                                        <div class="item">
                                                            <button id="doExportSelectedRoster" class="button btn btn-lg btn-success localize" id="sortAZ">@toolBar.export.title@</button>
                                                        </div>
                                                    </div>        
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
			</div>
		</div>
	</div>
</div>

<div id="downloadDialog" title="Download" class="hidden">
    <div>
        <div class="insp-row">
            <div>
                <div class="insp-text insp-inline-row">
                    <a id="download" class="title insp-inline-row-item insp-col-6 localize" data-contextmenu="true">@toolBar.download@</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalTemplate" role="dialog" data-backdrop="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"></h4>
            </div>
            <div class="modal-body">
            </div>
            <div class="modal-footer">
                <button type="button" class="modal-ok-btn btn btn-primary localize"  style="width:80px;" id="dialogConfirm">&nbsp; @dialog.ok@ &nbsp;</button>
                <button type="button" class="modal-cancel-btn btn btn-default localize" style="width:80px;" data-dismiss="modal">@dialog.cancel@</button>
            </div>
        </div>
    </div>
</div>

<div id="confirmationDiaglog" class="hidden">
    <div>
        <div class="insp-row">
            <div>
                <div class="insp-text insp-inline-row">
                    <span id="confirmationDiaglogText" class="title insp-inline-row-item insp-col-6 localize" style="font-size:14px; width:100%;">@removeSheetDialog.confirmTitle@</span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>