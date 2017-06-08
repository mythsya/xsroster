var resourceMap = {},
    conditionalFormatTexts = {};

$(document).ready(function() {
	
	$(window).unload(function() {
		resetAllInputFields();
	});
	
    getResourceMap(uiResource);

    localizeUI();
    
    initZtreeNodes({
    	showValid: true,
    	showPublished: true
    });
    
    $("#doExport").click(function () {
        exportToExcel();
    });
    
    $("#doPrint").click(function(e) {
    	printExcel();
    });
    
    $("#toggleInspector").click(toggleInspector);
    
    $("#doOpenSelectedRoster").click(function(e) {
    	openSelectedRoster(e, $(this));
    });
    
    $("#doExportSelectedRoster").click(function(e) {
    	exportSelectedRoster(e, $(this));
    });
    
    $('#excel-sheet-nav a').click(function (e) {
		e.preventDefault();
		$(this).tab('show');
	});
    
});

function openSelectedRoster(e, $self) {
	if(!checkHistroyTreeNodeSelected()) {
		showAlertDialog({
        	message: getResource("histroyTab.dialog.mustSelectOne")
        });
		return false;
	}
	
	var checked = getSelectedHistroyTreeNodes(),
		nodeId = checked[0].id;
	
	doOpenRosterById(nodeId, function(data, status, xhr) {		
		if (status == 'success' && data.id) {
		    valCurrentRosterId(data.id);
			valCurrentRosterTag(data.tag);
			valCurrentRosterName(data.name, true);
			
			if(data.sheets && data.sheets.length > 0) {				
				$(".tab-pane iframe").off('load');
				
				var liElems = "", tabElems = "";
				for(var i=0; i<data.sheets.length; i++) {					
					var active = (i==0?'active':''), sheetId=data.sheets[i].id, sheetName = data.sheets[i].name;
					liElems += '<li role="presentation" class="'+active+'"><a href="#'+sheetId+'" aria-controls="'+sheetId+'" role="tab" data-toggle="tab">'+sheetName+'</a></li>';
					tabElems += '<div role="tabpanel" class="tab-pane '+active+'" id="'+sheetId+'"><iframe src="'+AppEnv.contextPath+'/excel/svg/'+sheetId+'" width="100%"></iframe></div>';
				}
				var $nav = $("#excel-sheet-nav"), $tab = $("#excel-tab-content");
				$nav.empty();
				$nav.append(liElems);
				
				$tab.empty();
				$tab.append(tabElems);
			
				$(".tab-pane iframe").on('load', function(e) {
					var iframe = $(e.target);					
					iframe.height(iframe.parent().parent().height()-30);
				});
			}
		} else {
			alert("Can not load excel file!");
		}
	});

}

function doExportExcel(id) {
	var url = AppEnv.contextPath+"/excel/xlsx/"+id;
	
	$('<form method="POST" action="'+url+'"></form>').appendTo('body').submit().remove();
}

function exportSelectedRoster(e, $self) {
	if(!checkHistroyTreeNodeSelected()) {
		showAlertDialog({
        	message: getResource("histroyTab.dialog.mustSelectOne")
        });
		return false;
	}
	
	var checked = getSelectedHistroyTreeNodes(),
	nodeId = checked[0].id;
	
	doExportExcel(nodeId);
}

function exportToExcel() {
	var currentId = valCurrentRosterId();
	if (!currentId) {
		showAlertDialog({
        	message: getResource("toolBar.export.dialog.noValidRoster")
        });
		return false;
	}
	
	doExportExcel(currentId);
}

function printExcel() {
	var iframes = $("#excel-tab-content .tab-pane iframe");
	
	for(var i=0; i<iframes.length; i++) {
		console.info(iframes[i].contentWindow);
		iframes[i].contentWindow.focus();
		iframes[i].contentWindow.print();
	}
}