$(document).ready(function() {
	$(window).unload(function() {
		valCurrentRosterId("");
		valCurrentRosterName("", true);
	});
	
	$("#current_roster_name_lbl").on("dblclick", function(e) {
		editCurrentRosterName(e, $(this));
	});
	
    $("#doImport").click(function (e) {
    	importExistingExcel(e, $(this));
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

function valCurrentRosterId(v) {
	return setOrGetValue($("#current_roster_id"), v);
}

function valCurrentRosterTag(v) {
	return setOrGetValue($("#current_roster_tag"), v);
}

function valCurrentRosterName(v, forceSync) {
	var v2 = setOrGetValue($("#current_roster_name"), v);
	
	if (forceSync === true || forceSync === 'true') {
		$("#current_roster_name_lbl").text(v2);
	}
	
	return v2;
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

function importExistingExcel(e, $self) {	
	showConfirmDialog({
		message: getResource("toolBar.import.remindSaveCurrentEdit"),
		onClose: function(parent, confirmed) {
			if (confirmed === true) {
				$("#fileSelector").data("action", $self.attr("id"));
			    $("#fileSelector").click();
			}
		}
	});
}

function handler4ImportExcel(file, action) {
	if (!/application\/vnd.openxmlformats-officedocument.spreadsheetml.sheet/.test(file.type)) {            
        showAlertDialog({
        	message: getResource("toolBar.import.xlsxFileRequired")
        });
        return false;
    }
	
	var initName = file.name.substring(0, file.name.lastIndexOf("."));
	showNewRosterPromptDialog({
		width: 400,
		title: getResource("toolBar.newexcel.prompt.title"),
		onOk: function(dlg, fields) {
		},
		onClose: function(dlg, fields) {
			var name = fields.name.val(), tag = fields.tag.val();
			if (fields.valid===true && name && tag) {
				importSpreadFromExcel(file);
				valCurrentRosterId("");
				valCurrentRosterTag(tag);
				valCurrentRosterName(name, true);
				appendNewRoster(name, tag, true);				
			}
		}
	}, {
		name: initName
	});	

    return true;
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
	    	var formData = new FormData();
	    	formData.append("id", valCurrentRosterId());
	    	formData.append("name", valCurrentRosterName());
	    	formData.append("tag", valCurrentRosterTag());
	    	formData.append("path", "");
	    	formData.append("jsonCotent", jsonText);
	    	formData.append("xlsxContent", blob);
	    	
	    	$.ajax({
	    		url: AppEnv.contextPath+"/excel/save",
	    		type: 'POST',
	    		data: formData,
	    		cache: false,
	    		processData: false,
	    		contentType: false,
	    		success: function(data, status) {
	    			$dlg.modal("hide");
	    			initZtreeNodes();
	    			if (data.status == 'success') {
	    				alert(getResource("toolBar.save.dialog.success"));
	    			} else {
	    				alert(getResource("toolBar.save.dialog.failure"));
	    			}
	    		}, 
	    		error: function(xhr, msg, e) {
	    			$dlg.modal("hide");
	    			alert(msg);
	    		}
	    	});
	    });
	}
	
	var rosterTag=valCurrentRosterTag(), rosterName = valCurrentRosterName();
	if (!rosterTag || !rosterName || rosterName == getResource("toolBar.newexcel.tempname")) {		
		showNewRosterPromptDialog({
			width: 400,
			title: getResource("toolBar.newexcel.prompt.title"),
			onClose: function(dlg, fields) {
				var name = fields.name.val(), tag = fields.tag.val();
				if (fields.valid===true && name && tag) {
					valCurrentRosterTag(tag);
					valCurrentRosterName(name, true);
					appendNewRoster(name, tag, true);
					doSave();
				}
			}
		}, {
			name: rosterName,
			tag: rosterTag
		});
	} else {
		doSave();
	}
}

function publishCurrentRoster(e, $self) {
	function doPublish() {
		var $dlg = showProgressDialog({
			width: 400,
			onClose: function() {}
		});
	    	
    	$.ajax({
    		url: AppEnv.contextPath+"/excel/publish",
    		type: 'POST',
    		data: { id : valCurrentRosterId()},
    		cache: false,
    		processData: true,	    		
    		success: function(data, status, xhr) {
    			$dlg.modal("hide");
    			if (data.status == 'success') {
    				alert(getResource("toolBar.publish.dialog.success"));
    			} else {
    				alert(getResource("toolBar.publish.dialog.failure"));
    			}
    		}, 
    		error: function(xhr, msg, e) {
    			$dlg.modal("hide");
    			alert(msg);
    		}
    	});

	}
	
	if(!valCurrentRosterId()) {
		showAlertDialog({
        	message: getResource("toolBar.publish.dialog.noValidRoster")
        });
		return false;
	}
	
	showConfirmDialog({
		width: 400,
		message: getResource("toolBar.publish.dialog.confirmPublish"),
		buttonsYESNO: true,
		onClose: function(parent, confirmed) {
			if (confirmed === true || confirmed === 'true') {
				doPublish();
			}
		}
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
	
	showConfirmDialog({
		message: getResource("histroyTab.dialog.remindSaveCurrentEdit"),
		onClose: function(parent, confirmed) {
			if (confirmed === true) {
				var checked = getSelectedHistroyTreeNodes(),
					nodeId = checked[0].id;
				doOpenRosterById(nodeId, function(data, status, xhr) {
					
					if (status == 'success' && data.id) {
						var spreadJson = JSON.parse(data.content);
					    importJson(spreadJson);
					    valCurrentRosterId(data.id);
						valCurrentRosterTag(data.tag);
						valCurrentRosterName(data.name, true);
					} else {
						alert("Can not load excel file!");
					}
					
				});
			}
		}
	});
}

function delSelectedRoster(e, $self) {
	if(!checkHistroyTreeNodeSelected()) {
		showAlertDialog({
        	message: getResource("histroyTab.dialog.mustSelectOne")
        });
		return false;
	}
}

function doCreateNewRoster($self, callback, initialValues) {
	showConfirmDialog({
		message: getResource("histroyTab.dialog.remindSaveCurrentEdit"),
		onClose: function(parent, confirmed) {
			if (confirmed === true) {
				showNewRosterPromptDialog({
					width: 400,
					title: getResource("toolBar.newexcel.prompt.title"),
					onOk: function(dlg, fields) {
					},
					onClose: function(dlg, fields) {
						var name = fields.name.val(), tag = fields.tag.val();
						if (fields.valid===true && name && tag) {
							valCurrentRosterTag(tag);
							valCurrentRosterName(name, true);
							appendNewRoster(name, tag, true);
							callback(name, tag);
						}
					}
				}, initialValues);	
			}
		}
	});
}

function createNewRoster(e, $self) {
	doCreateNewRoster($self, function(name, tag) {
		valCurrentRosterId("");
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
	var selected = getSelectedHistroyTreeNodes();
	var nodeId = selected[0].id, nodeName = selected[0].name;
	doCreateNewRoster($self, function(name, tag) {
		doOpenRosterById(nodeId, function(data, status, xhr) {
			if (status == 'success' && data.id) {
				var spreadJson = JSON.parse(data.content);
			    importJson(spreadJson);
			    valCurrentRosterId("");
			} else {
				alert("Can not load excel file!");
			}
		});
	}, {name: nodeName+"_copy"});
}



