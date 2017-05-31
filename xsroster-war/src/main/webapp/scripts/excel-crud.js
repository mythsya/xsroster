$(document).ready(function() {
	$("#current_roster_name_lbl").on("dblclick", function(e) {
		editCurrentRosterName(e, $(this));
	});
	
    $("#doImport").click(function () {
        $("#fileSelector").data("action", this.id);
        $("#fileSelector").click();
    });
    
    fileImporterHandlers["doImport"] = handler4ImportExcel;
    
    $("#doCreate").click(function(e) {
    	createNewRoster(e, $(this));
    });
	
	$("#doSave").click(function(e) {
		saveCurrentRoster(e, $(this));
	});
	
	$("#doPublish").click(function(e) {
		publishCurrentRoster(e, $(this));
	});
	
    $("#doTag").click(function(e) {
    	tagCurrentRoster(e, $(this));
    });
    
    $("#doOpenSelectedRoster").click(function(e) {
    	openSelectedRoster(e, $(this));
    });
    
    $("#doDelSelectedRoster").click(function(e) {
    	delSelectedRoster(e, $(this));
    });
    
    $("#doCreateNewRoster").click(function(e) {
    	createNewRoster(e, $(this));
    });
    
	$("#doCopyCreateNewRoster").click(function(e) {
		copyCreateNewRoster(e, $(this));
	});
});

function valCurrentRosterName(v, forceSync) {
	if (v) {
		$("#current_roster_name").val(v);
		if (forceSync === true || forceSync === 'true') {
			$("#current_roster_name_lbl").text(v);
		}
	} else {
		v = $("#current_roster_name").val();
	}
	return v;
}

function editCurrentRosterName(e, $self) {
	var oldval = $self.text();
	var tmpEditId = "current_roster_name_lbl_tmp_edit";
	var input = "<input type='text' id='"+tmpEditId+"' style='background: transparent; border: 0 none;' value='"+oldval+"' />";
	$self.text(''); 
	$self.append(input);
	$self.off("dblclick");
	
	function confirmCurrentRosterNameEdit(e, $this) {
		if ($this.val() != '') oldval = $this.val();
		$this.closest('span').text(oldval);
		valCurrentRosterName(oldval);
		$self.on("dblclick", function(e) {
			editCurrentRosterName(e, $self);
		});
	}
	
	var $edit = $("#"+tmpEditId);	
	if ($edit) {
		$edit.focus();
		$edit.blur(function(e) {
			confirmCurrentRosterNameEdit(e, $(this));
		});
		$edit.keydown(function(e) {
			if (e.keyCode == 13) {
				confirmCurrentRosterNameEdit(e, $(this));
			}
		});
	}
}

function saveCurrentRoster(e, $self) {
	function doSave() {
		var $dlg = showProgressDialog({
			width: 400,
			onClose: function() {}
		});
		
	    var json = spread.toJSON({includeBindingSource: true});
	    var jsonText = JSON.stringify(json);
	    excelIO.save(json, function (blob) {
	    	console.info(jsonText);
	    	console.info(blob);
	    });
	}
	
	var rosterName = valCurrentRosterName();
	if (rosterName == "" || rosterName == getResource("toolBar.newexcel.tempname")) {		
		showSinglePromptDialog({
			width: 400,
			title: getResource("toolBar.save.prompt.title"),
			onOk: function(dlg, field) {
			},
			onClose: function(dlg, field) {
				var fv = field.val();
				if (fv) {
					valCurrentRosterName(fv, true);
					doSave();
				}
			}
		});
	} else {
		doSave();
	}
}

function publishCurrentRoster(e, $self) {
	showConfirmDialog({		
		width: 400,
		message: getResource("toolBar.publish.confirmMessage"),
		buttonsYESNO: true
	});
}

function tagCurrentRoster(e, $self) {
	showSinglePromptDialog({
		width: 400,
		title: getResource("toolBar.tag.prompt.title")
	});
}

function openSelectedRoster(e, $self) {
	if(!checkHistroyTreeNodeSelected()) {
		showAlertDialog({
        	message: getResource("histroyTab.dialog.mustSelectOne")
        });
		return false;
	}
}

function delSelectedRoster(e, $self) {
	if(!checkHistroyTreeNodeSelected()) {
		showAlertDialog({
        	message: getResource("histroyTab.dialog.mustSelectOne")
        });
		return false;
	}
}

function doCreateNewRoster($self, callback) {
	showSinglePromptDialog({
		width: 400,
		title: getResource("toolBar.save.prompt.title"),
		onOk: function(dlg, field) {
		},
		onClose: function(dlg, field) {
			var fv = field.val();
			if (fv) {
				valCurrentRosterName(fv, true);
				callback(fv);
			}
		}
	});	
}

function createNewRoster(e, $self) {
	doCreateNewRoster($self, function(name) {
		spread.clearSheets();
		var sheet = new GC.Spread.Sheets.Worksheet('Sheet1');
		spread.addSheet(0, sheet);
	});
}

function copyCreateNewRoster(e, $self) {
	if(!checkHistroyTreeNodeSelected()) {
		showAlertDialog({
        	message: getResource("histroyTab.dialog.mustSelectOne")
        });
		return false;
	}
	
	doCreateNewRoster($self, function(name) {
		
	});
}

function handler4ImportExcel(file, action) {
	if (!/application\/vnd.openxmlformats-officedocument.spreadsheetml.sheet/.test(file.type)) {            
        showAlertDialog({
        	message: getResource("toolBar.import.xlsxFileRequired")
        });
        return false;
    }
    return importSpreadFromExcel(file);
}

