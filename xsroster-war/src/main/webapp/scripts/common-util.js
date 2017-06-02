var AppEnv = {};

function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    return result;
}

AppEnv.contextPath = getContextPath();

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