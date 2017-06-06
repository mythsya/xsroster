var spreadNS = GC.Spread.Sheets;
var DataValidation = spreadNS.DataValidation;
var ConditionalFormatting = spreadNS.ConditionalFormatting;
var ComparisonOperators = ConditionalFormatting.ComparisonOperators;
var Calc = GC.Spread.CalcEngine;
var ExpressionType = Calc.ExpressionType;
var SheetsCalc = spreadNS.CalcEngine;
var Sparklines = spreadNS.Sparklines;
var isSafari = Object.prototype.toString.call(window.HTMLElement).indexOf('Constructor') > 0;
var isIE = navigator.userAgent.toLowerCase().indexOf('compatible') < 0 && /(trident)(?:.*? rv ([\w.]+)|)/.exec(navigator.userAgent.toLowerCase()) !== null;
var DOWNLOAD_DIALOG_WIDTH = 300;

var spread, excelIO;
var tableIndex = 1, pictureIndex = 1;
var fbx, isShiftKey = false;

var resourceMap = {},
    conditionalFormatTexts = {};

var fileImporterHandlers = {}; 


$(document).ready(function() {

	getResourceMap(uiResource);

    localizeUI();
	
	$("#fileSelector").change(processFileSelected);
	
    $("#addpicture").click(function () {
        $("#fileSelector").data("action", this.id);
        $("#fileSelector").click();
    });
    
    fileImporterHandlers["addpicture"] = handler4AddPicture;
    
    initZtreeNodes({
    	enableEdit: true
    });
    
    $("#doPrint").click(function() {
    	spread.print();
    });
    
    $("#toggleInspector").click(toggleInspector);
});



//single-field prompt dialog related items
function showSinglePromptDialog(cfg) {
	var $dlg = $("#singleFieldPromptDialog");
	var $formId = "singleFieldPromptForm";
	
	var $dialog = showModal({
		title: cfg.title || getResource("dialog.prompt"),
		width: cfg.width || 500,
		content: $dlg.children(),
		onShown: function(dlg, e) {
			var $form = $("#"+$formId, dlg);
			$form.removeData("valid");
		},
		onOk:  function(dlg, e) {
			var $form = $("#"+$formId, dlg);
			if ($form && $form.data('formValidation')) {
				if($form.data('formValidation').validate().isValid()) {
					$form.data("valid", true);
					var $field = $("#prompt-single-field", $form);
					if (cfg.onOk) cfg.onOk(dlg, $field);
					return;
				}
			}
			$form.data("valid", false);
			return { canceled : true };
		},
		onCancel: function(dlg, e) {
			var $form = $("#"+$formId, dlg);
			$form.data("valid", false);
			if (cfg.onCancel) cfg.onCancel(dlg, $form);
		},
		onClose: function(parent, e) {
			var $form = $("#"+$formId, parent);	
			var $field = $("#prompt-single-field", $form);	
			if (cfg.onClose) cfg.onClose(parent, $field, $form.data("valid"));
			
			if ($form && $form.data('formValidation')) {				
				$form.data('formValidation').resetForm(true).destroy();
			}
		}
	});
	
	$("#"+$formId, $dialog).formValidation({
		framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            "promptSingleField": {
                row: '.col-xs-12',
                validators: {
                    notEmpty: {
                        message: getResource("dialog.promptRequired")
                    }
                }
            }
        }
	});
	
	return $dialog;
}
//single-field prompt dialog related items (end)

//new roster prompt dialog related items
function showNewRosterPromptDialog(cfg, initialValues) {
	var $dlg = $("#newRosterPromptDialog");
	var $formId = "newRosterPromptForm";
	
	var $dialog = showModal({
		title: cfg.title || getResource("dialog.prompt"),
		width: cfg.width || 400,
		content: $dlg.children(),
		onShown: function(dlg, e) {
			var $form = $("#"+$formId, dlg);
			$form.removeData("valid");
			
			var $name = $("#new-roster-prompt-name", $form), $select = $("#new-roster-prompt-tag", $form);
			if ($select) {
				$select.empty();
				var now = new Date(), y = now.getFullYear(), m = now.getMonth();
				$select.append("<option value='"+y+"' selected>"+y+"</option>");
				if (m >= 10) {
					$select.append("<option value='"+(y+1)+"' selected>"+(y+1)+"</option>");
				}
			}
		},
		onOk:  function(dlg, e) {
			var $form = $("#"+$formId, dlg);
			if ($form && $form.data('formValidation')) {
				if($form.data('formValidation').validate().isValid()) {
					$form.data("valid", true);
					var $name = $("#new-roster-prompt-name", $form), $tag = $("#new-roster-prompt-tag", $form);
					if (cfg.onOk) cfg.onOk(dlg, {name: $name, tag: $tag});
					return;
				}
			}
			$form.data("valid", false);
			return { canceled : true };
		},
		onCancel: function(dlg, e) {
			var $form = $("#"+$formId, dlg);
			$form.data("valid", false);
			if (cfg.onCancel) cfg.onCancel(dlg, $form);
		},
		onClose: function(parent, e) {
			var $form = $("#"+$formId, parent);	
			var $name = $("#new-roster-prompt-name", $form), $tag = $("#new-roster-prompt-tag", $form);
			if (cfg.onClose) cfg.onClose(parent, {valid: $form.data("valid"), name: $name, tag: $tag});
			
			if ($form && $form.data('formValidation')) {				
				$form.data('formValidation').resetForm(true).destroy();
			}
		}
	});
	
	$("#"+$formId, $dialog).formValidation({
		framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            "newRosterPromptName": {
                validators: {
                    notEmpty: {
                        message: getResource("dialog.promptRequired")
                    },
                    callback: {
                    	message: getResource("histroyTab.dialog.mustUniqueName"),
                    	callback: function(value, validator, $field) {
                    		var $form = $("#"+$formId, $dialog);	
                    		var $tag = $("#new-roster-prompt-tag", $form);
                    		return !checkRosterExists(value, $tag.val());
                    	}
                    }
                }
            },
        	"newRosterPromptTag": {
                validators: {
                    notEmpty: {
                        message: getResource("dialog.promptRequired")
                    }
                }
        	}
        }
	});
	
	if (initialValues) {
		var $form = $("#"+$formId, $dialog);
		var $name = $("#new-roster-prompt-name", $form), $tag = $("#new-roster-prompt-tag", $form);
		if (initialValues.name) $name.val(initialValues.name);
		if (initialValues.tag) $tag.val(initialValues.tag);
	}
	
	return $dialog;
}
//new roster prompt dialog related items (end)

//image file import handler related items
function handler4AddPicture(file, action) {
	if (!/image\/\w+/.test(file.type)) {
        alert(getResource("messages.imageFileRequired"));
        return false;
    }
    var reader = new FileReader();
    reader.onload = function () {
        switch (action) {
            case "addpicture":
                addPicture(this.result);
                break;
        }
    };
    reader.readAsDataURL(file);
    return true;
}

function processFileSelected() {
    var file = this.files[0],
        action = $(this).data("action");

    if (!file) return false;

    // clear to make sure change event occures even when same file selected again
    $("#fileSelector").val("");
    
    if (fileImporterHandlers[action]) {
    	fileImporterHandlers[action](file, action);
    }
}
//image file import handler related items (end)

// excel/jons import/export related items
function importFile(file) {
    var fileName = file.name;
    var index = fileName.lastIndexOf('.');
    var fileExt = fileName.substr(index + 1).toLowerCase();
    if (fileExt === 'json' || fileExt === 'ssjson') {
        importSpreadFromJSON(file);
    } else if (fileExt === 'xlsx') {
        importSpreadFromExcel(file);
    }
}

function importSpreadFromExcel(file, options) {
    function processPasswordDialog() {
        importSpreadFromExcel(file, {password: getTextValue("txtPassword")});
        setTextValue("txtPassword", "");
    }

    var PASSWORD_DIALOG_WIDTH = 300;
    excelIO.open(file, function (json) {
        importJson(json);
    }, function (e) {
        if (e.errorCode === 0) {
            alert(getResource("messages.invalidImportFile"));
        } else if (e.errorCode === 1) {
            $("#passwordError").hide();            
            showModal({
            	title: uiResource.passwordDialog.title,
            	width: PASSWORD_DIALOG_WIDTH,
            	content: $("#passwordDialog").children(),
            	callback: processPasswordDialog
            });
        } else if (e.errorCode === 2) {
            $("#passwordError").show();            
            showModal({
            	title: uiResource.passwordDialog.title,
            	width: PASSWORD_DIALOG_WIDTH,
            	content: $("#passwordDialog").children(),
            	callback: processPasswordDialog
            });
        }
    }, options);
}


function importSpreadFromJSON(file) {
    function importSuccessCallback(responseText) {
        var spreadJson = JSON.parse(responseText);
        importJson(spreadJson);
    }

    var reader = new FileReader();
    reader.onload = function () {
        importSuccessCallback(this.result);
    };
    reader.readAsText(file);
    return true;
}

function importJson(spreadJson) {
    function updateActiveCells() {
        for (var i = 0; i < spread.getSheetCount(); i++) {
            var sheet = spread.getSheet(i);
            columnIndex = sheet.getActiveColumnIndex(),
                rowIndex = sheet.getActiveRowIndex();
            if (columnIndex !== undefined && rowIndex !== undefined) {
                spread.getSheet(i).setActiveCell(rowIndex, columnIndex);
            } else {
                spread.getSheet(i).setActiveCell(0, 0);
            }
        }
    }

    if (spreadJson.version && spreadJson.sheets) {
        spread.unbindAll();
        spread.fromJSON(spreadJson);
        attachSpreadEvents(true);
        updateActiveCells();
        spread.focus();
        fbx.workbook(spread);
        onCellSelected();
        syncSpreadPropertyValues();
        syncSheetPropertyValues();
    } else {
        alert(getResource("messages.invalidImportFile"));
    }
}

function getFileName() {
    function to2DigitsString(num) {
        return ("0" + num).substr(-2);
    }

    var date = new Date();
    return [
        "export",
        date.getFullYear(), to2DigitsString(date.getMonth() + 1), to2DigitsString(date.getDate()),
        to2DigitsString(date.getHours()), to2DigitsString(date.getMinutes()), to2DigitsString(date.getSeconds())
    ].join("");
}

function exportToJSON() {
    var json = spread.toJSON({includeBindingSource: true}),
        text = JSON.stringify(json);
    var fileName = getFileName();
    if (isSafari) {        
        showModal({
        	title: uiResource.toolBar.downloadTitle,
        	width: DOWNLOAD_DIALOG_WIDTH,
        	content: $("#downloadDialog").children(),
        	callback: function () {
                $("#downloadDialog").hide();
            }
        });
        var link = $("#download");
        link[0].href = "data:text/plain;" + text;
    } else {
        saveAs(new Blob([text], {type: "text/plain;charset=utf-8"}), fileName + ".json");
    }
}

function exportToExcel() {
    var fileName = getFileName();
    var json = spread.toJSON({includeBindingSource: true});
    excelIO.save(json, function (blob) {
        if (isSafari) {
            var reader = new FileReader();
            reader.onloadend = function () {                
                showModal({
                	title: uiResource.toolBar.downloadTitle,
                	width: DOWNLOAD_DIALOG_WIDTH,
                	content: $("#downloadDialog").children(),
                	callback: function () {
                        $("#downloadDialog").hide();
                    }
                });
                var link = $("#download");
                link[0].href = reader.result;
            };
            reader.readAsDataURL(blob);
        } else {
            saveAs(blob, fileName + ".xlsx");
        }
    }, function (e) {
        alert(e);
    });
}
//excel/jons import/export related items (end)

// inspector related items
var _floatInspector = false;

function adjustInspectorDisplay() {
    var $inspectorContainer = $(".insp-container"),
        $contentContainer = $("#inner-content-container"),
        toggleInspectorClasses;

    if (_floatInspector) {
        $inspectorContainer.draggable("enable");
        $inspectorContainer.addClass("float-inspector");
        $contentContainer.addClass("float-inspector");
        toggleInspectorClasses = ["fa-angle-down", "fa-angle-up"];
        $("#inner-content-container").css({right: 0});
    } else {
        $inspectorContainer.draggable("disable");
        $inspectorContainer.removeClass("float-inspector");
        $inspectorContainer.css({left: "auto", top: 0});
        $contentContainer.removeClass("float-inspector");
        toggleInspectorClasses = ["fa-angle-left", "fa-angle-right"];
    }

    // update toggleInspector
    var classIndex = ($(".insp-container:visible").length > 0) ? 1 : 0;
    $("#toggleInspector > span")
        .removeClass("fa-angle-left fa-angle-right fa-angle-up fa-angle-down")
        .addClass(toggleInspectorClasses[classIndex]);
}

function processMediaQueryResponse(mql) {
    if (mql.matches) {
        if (!_floatInspector) {
            _floatInspector = true;
            adjustInspectorDisplay();
        }
    } else {
        if (_floatInspector) {
            _floatInspector = false;
            adjustInspectorDisplay();
        }
    }
}

function toggleInspector() {
    if ($(".insp-container:visible").length > 0) {
        $(".insp-container").hide();
        if (!_floatInspector) {
            $("#inner-content-container").css({right: 0});
            $("span", this).removeClass("fa-angle-right fa-angle-up fa-angle-down").addClass("fa-angle-left");
        } else {
            $("#inner-content-container").css({right: 0});
            $("span", this).removeClass("fa-angle-right fa-angle-left fa-angle-up").addClass("fa-angle-down");
        }

        $(this).attr("title", uiResource.toolBar.showInspector);
    } else {
        $(".insp-container").show();
        if (!_floatInspector) {
            $("#inner-content-container").css({right: "301px"});
            $("span", this).removeClass("fa-angle-left fa-angle-up fa-angle-down").addClass("fa-angle-right");
        } else {
            $("#inner-content-container").css({right: 0});
            $("span", this).removeClass("fa-angle-right fa-angle-left fa-angle-down").addClass("fa-angle-up");
        }

        $(this).attr("title", uiResource.toolBar.hideInspector);
    }
    spread.refresh();
}
//inspector related items (end)
