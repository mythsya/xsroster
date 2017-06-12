var isSafari = Object.prototype.toString.call(window.HTMLElement).indexOf('Constructor') > 0;
var isIE = navigator.userAgent.toLowerCase().indexOf('compatible') < 0 && /(trident)(?:.*? rv ([\w.]+)|)/.exec(navigator.userAgent.toLowerCase()) !== null;
var DOWNLOAD_DIALOG_WIDTH = 300;

var AppEnv = {};
(function() {
	function getContextPath() {
	    var pathName = document.location.pathname;
	    var index = pathName.substr(1).indexOf("/");
	    var result = pathName.substr(0,index+1);
	    return result;
	}

	AppEnv.contextPath = getContextPath();	
})();

function resetAllInputFields() {
	$("input").each(function () {
		$(this).val("");
	});
}

function setOrGetValue(o, v) {
	if (o) {
		if (v == undefined) {
			v = o.val();
		} else {
			o.val(v);
		}
	}
	return v;
}

function localizeUI() {
    function getLocalizeString(text) {
        var matchs = text.match(/(?:(@[\w\d\.]*@))/g);

        if (matchs) {
            matchs.forEach(function (item) {
                var s = getResource(item.replace(/[@]/g, ""));
                text = text.replace(item, s);
            });
        }

        return text;
    }

    $(".localize").each(function () {
        var text = $(this).text();

        $(this).text(getLocalizeString(text));
    });

    $(".localize-tooltip").each(function () {
        var text = $(this).prop("title");

        $(this).prop("title", getLocalizeString(text));
    });

    $(".localize-value").each(function () {
        var text = $(this).attr("value");

        $(this).attr("value", getLocalizeString(text));
    });
}

//resource related items
function getResource(key) {
    key = key.replace(/\./g, "_");

    return resourceMap[key];
}

function getResourceMap(src) {
    function isObject(item) {
        return typeof item === "object";
    }

    function addResourceMap(map, obj, keys) {
        if (isObject(obj)) {
            for (var p in obj) {
                var cur = obj[p];

                addResourceMap(map, cur, keys.concat(p));
            }
        } else {
            var key = keys.join("_");
            map[key] = obj;
        }
    }

    addResourceMap(resourceMap, src, []);
}
//resource related items (end)

//inspector related items
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
    if(typeof(spread) != 'undefined' && spread) spread.refresh();
}
//inspector related items (end)

//roster histroy tree related items
var histroyTreeObjId = "roster-histroy-tree-container";

function getHistroyTreeObj() {
	return $.fn.zTree.getZTreeObj(histroyTreeObjId);
}

function initZtreeNodes(cfg) {
	cfg = cfg || {};
	
	var enableEdit = (cfg.enableEdit === true || cfg.enableEdit === 'true'); 
	var showValid = (cfg.showValid === true || cfg.showValid === 'true'); 
	var showPublished = (cfg.showPublished === true || cfg.showPublished === 'true'); 
	
    //隐藏菜单
    function hideMenu() {
        $("#treeMenuContent").fadeOut("fast");
        //$("body").unbind("mousedown", onBodyDown);
    }
    
    //节点点击事件
    function onClickNode(e, treeId, treeNode) {
        var zTree = getHistroyTreeObj();
        zTree.checkNode(treeNode, !treeNode.checked, null, true);
        return false;
    }

    //节点选择事件
    function onCheck(e, treeId, treeNode) {
        var zTree = getHistroyTreeObj();
        nodes = zTree.getCheckedNodes(true),
        v = "";
        var parentid = "";
        var parentlevel = "";
        for (var i = 0, l = nodes.length; i < l; i++) {
            v += nodes[i].name + ",";
            parentid += nodes[i].id + ",";
            parentlevel += nodes[i].menu_level + ",";
        }
        if (v.length > 0) {
            v = v.substring(0, v.length - 1);
            parentid = parentid.substring(0, parentid.length - 1);
            parentlevel = parentlevel.substring(0, parentlevel.length - 1);
        }
        else {
            return;
        }

        hideMenu();
    }

    var setting = {
        check: {
            enable: true,
            chkStyle: "radio",
            radioType: "all"
        },
        view: {
            dblClickExpand: false,
            showIcon: true,
            showLine: true,
            showTitle: true
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            onClick: onClickNode,
            onCheck: onCheck
        },
        edit: {
            enable:  enableEdit,
            showRenameBtn: false,
            showRemoveBtn: false
        }
    };
    
    var params = {};
    if(showValid) params["validOnly"] = true;
    if(showPublished) params["publishedOnly"] = true;
    	
    $.getJSON(AppEnv.contextPath+"/excel/history/tree", params, function(data, status, xhr) {
    	var zNodes = data; 
        $.fn.zTree.init($("#"+histroyTreeObjId), setting, zNodes);
        
        if (typeof (autoOpenExcelId) != 'undefined' && autoOpenExcelId) {
        	selectNodeById(autoOpenExcelId);
        }
    });
    
}

function getSelectedHistroyTreeNodes() {
	var zTree = getHistroyTreeObj(),
	nodes = zTree.getCheckedNodes(true);
	
	return nodes;
}

function checkHistroyTreeNodeSelected() {
	var zTree = getHistroyTreeObj(),
    	nodes = zTree.getCheckedNodes(true);

	if (!nodes || nodes.length <= 0 || nodes[0].isParent) {
		return false;
	}
	return true;	
}

function checkRosterExists(name ,tag) {
	var zTree = getHistroyTreeObj();
	var parentNodes = zTree.getNodesByParam("id", tag, null);	
	if (parentNodes && parentNodes.length > 0) {
		for(var i=0; i<parentNodes.length; i++) {
			var childNodes = zTree.getNodesByParam("name", name, parentNodes[i]);
			if (childNodes && childNodes.length > 0) {
				return true;
			}
		}
	}
	return false;
}

function removeAllTransientNodes() {
	var zTree = getHistroyTreeObj();
	var nodes = zTree.getNodesByParam("transient", true, null);	
	for(var i=0; i<nodes.length; i++) {
		zTree.removeNode(nodes[i]);
	}
}

function appendNewRoster(name, tag, clearTransient) {
	var zTree = getHistroyTreeObj();
	if (clearTransient === true || clearTransient === 'true') {
		//removeAllTransientNodes();
	}
	
	var parentNodes = zTree.getNodesByParam("id", tag, null);	
	if (!parentNodes || parentNodes.length <= 0) {
		parentNodes = zTree.addNodes(null, 0, {"id":tag,"name":tag,"isParent":true,"open":true}, true);
	}
	var pNode = parentNodes[0];	
	var newNodes = zTree.addNodes(pNode, 0, {"id":"","name":name,"isParent":false,"open":true, "transient": true, "iconSkin":"transient"}, true);
	zTree.expandNode(pNode, true, true, true);
	return newNodes;
}

function selectNodeById(id) {
	var zTree = getHistroyTreeObj();
	var nodes = zTree.getNodesByParam("id", id, null);	

	if (nodes && nodes.length >0) {
		zTree.checkNode(nodes[0], true, true);
	}
}
//roster histroy tree related items (end)

//current roster id related items
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
//current roster id related items (end)

//dialog related items
function showModal(cfg) {
    cfg = cfg || {};

    var title = cfg.title, 
      width = cfg.width || 500, 
      content = cfg.content,
      callback = cfg.callback || function() {},
      hideClose = (cfg.hideClose === true || cfg.hideClose === 'true'),
      hideOk = (cfg.hideOk === true || cfg.hideOk === 'true'),
      hideCancel = (cfg.hideCancel === true || cfg.hideCancel === 'true'),
      hideHeader = (cfg.hideHeader === true || cfg.hideHeader === 'true'),
      hideFooter = (cfg.hideFooter === true || cfg.hideFooter === 'true'),
      buttonsYESNO = (cfg.buttonsYESNO === true || cfg.buttonsYESNO === 'true');
      
  
    var onOk = cfg.onOk || callback,
      onCancel = cfg.onCancel || callback,
      onClose = cfg.onClose || function() {},
      onShown = cfg.onShown || function() {};

    var $dialog = $("#modalTemplate"),
      $header = $(".modal-header", $dialog),
      $closeIcon = $(".close", $dialog),
      $body = $(".modal-body", $dialog),
      $footer =$(".modal-footer", $dialog),
      $okbtn = $(".modal-ok-btn", $dialog),
      $cancelbtn = $(".modal-cancel-btn", $dialog);

    function hide(el, flag) {
        if (flag) el.hide();
        else el.show();
    }

    hide($header, hideHeader);
    hide($closeIcon, hideClose);
    hide($footer, hideFooter);
    hide($okbtn, hideOk);
    hide($cancelbtn, hideCancel);
    
    if (buttonsYESNO) {
    	$okbtn.text(getResource("dialog.yes"));
    	$cancelbtn.text(getResource("dialog.no"));
    } else {
    	$okbtn.text(getResource("dialog.ok"));
    	$cancelbtn.text(getResource("dialog.cancel"));
    }

    $(".modal-title", $dialog).text(title);
    $dialog.data("content-parent", content.parent());
    $body.append(content);

    $okbtn.off("click");
    $okbtn.on("click", function (e) {
        var result = onOk($dialog, e);
        // return an object with  { canceled: true } to tell not close the modal, otherwise close the modal
        if (!(result && result.canceled)) {
          $dialog.modal("hide");
        }
    });
  
    $cancelbtn.off("click");
    $cancelbtn.on("click", function (e) {
        var result = onCancel($dialog, e);
        // return an object with  { canceled: true } to tell not close the modal, otherwise close the modal
        if (!(result && result.canceled)) {
            $dialog.modal("hide");
        }
    });
    
    $dialog.off("shown.bs.modal");
    $dialog.on("shown.bs.modal", function (e) {    	
    	onShown($dialog, e);
    });

    $dialog.off("hidden.bs.modal");
    $dialog.on("hidden.bs.modal", function (e) {
        var $originalParent = $dialog.data("content-parent");
        if ($originalParent) {
            $originalParent.append($body.children());
        }        
        onClose($originalParent, e);
    });

    // set width of the dialog
    $(".modal-dialog", $dialog).css({width: width});

    $dialog.modal("show");
    
    return $dialog;
}
// dialog related items (end)

// progress dialog related items
var progressTimer, progressValue = 0;
function showProgressDialog(cfg) {
	var $dialog = showModal({
		title: cfg.title || getResource("dialog.waitingNow"),
		width: cfg.width || 400,
		content: $("#progressBarDialog").children(),
		hideFooter: true,
		onClose: function($parent, e) {
			resetTimer($parent);
		}
	});
	
	function resetTimer($parent) {
		progressValue = 0;
		if (progressTimer) clearTimeout(progressTimer);		
		$(".progress-bar", $parent).css("width", "0%");
	}
	
	function incrementTimer() {
		progressValue += 1;
		$(".progress-bar", $dialog).css("width", progressValue+"%");
		if (progressValue >= 100) {
			clearTimeout(progressTimer);
		} else {
			progressTimer = setTimeout(incrementTimer, 100);
		}
	}
	
	resetTimer($dialog);
	incrementTimer();
	
	return $dialog;
}
//progress dialog related items (end)

//confirmation dialog related items
function showConfirmDialog(cfg) {
	var $dlg = $("#confirmationDiaglog");
	if (cfg.message) {
		$("#confirmationDiaglogText", $dlg).text(cfg.message);
	}
	var $dialog = showModal({
		title: cfg.title || getResource("dialog.confirm"),
		width: cfg.width || 400,
		buttonsYESNO: !(cfg.buttonsYESNO === false || cfg.buttonsYESNO === 'false'),
		content: $dlg.children(),
		onShown: function(dlg, e) {
			$dialog.removeData("confirmed");
		},
		onOk: function(dlg, e) {
			$dialog.data("confirmed", true);
			if(cfg.onOk) cfg.onOk(dlg, e);
		},
		onCancel: function(dlg, e) {
			$dialog.data("confirmed", false);
			if(cfg.onCancel) cfg.onCancel(dlg, e);
		},
		onClose: function(parent, e) {
			if(cfg.onClose) cfg.onClose(parent, $dialog.data("confirmed"));
		}
	});
	return $dialog;
}
//confirmation dialog related items (end)

//alert dialog related items
function showAlertDialog(cfg) {
	var $dlg = $("#confirmationDiaglog");
	if (cfg.message) {
		$("#confirmationDiaglogText", $dlg).text(cfg.message);
	}
	var $dialog = showModal({
		title: cfg.title || getResource("dialog.alert"),
		width: cfg.width || 400,
		content: $dlg.children(),
		hideCancel: true,
		onOk: cfg.onOk,		
		onClose: cfg.onClose
	});
	return $dialog;
}
//alert dialog related items (end)

//roster related items
function doOpenRosterById(id, callback) {
	$.ajax({
		url: AppEnv.contextPath+"/excel/open",
		type: 'POST',
		data: {id: id},
		dataType: 'json',
		cache: false,
		processData: true,		    		
		success: function(data, status, xhr) {
			if (callback) callback(data, status, xhr);
		}, 
		error: function(xhr, msg, e) {
			alert(msg);
		}
	});
}
//roster related items (end)

//file download related items
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

function downloadExcelFile(blob, fileName) {    
    
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
        saveAs(blob, fileName);
    }

}
//file download related items (end)