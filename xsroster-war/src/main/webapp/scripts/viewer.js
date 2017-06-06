var resourceMap = {},
    conditionalFormatTexts = {};

$(document).ready(function() {
	
    getResourceMap(uiResource);

    localizeUI();
    
    initZtreeNodes({
    	showValid: true,
    	showPublished: true
    });
    
    $("#toggleInspector").click(toggleInspector);
    
    $("#doOpenSelectedRoster").click(function(e) {
    	openSelectedRoster(e, $(this));
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
			var spreadJson = JSON.parse(data.content);
		    //importJson(spreadJson);
		    valCurrentRosterId(data.id);
			valCurrentRosterTag(data.tag);
			valCurrentRosterName(data.name, true);
		} else {
			alert("Can not load excel file!");
		}
		
	});

}
