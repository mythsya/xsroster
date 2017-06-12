<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <title>用户登录</title>
  <link rel="stylesheet" href="<c:url value='/static/css/font-awesome.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/bootstrap-3.3.7.min.css'/>">
  <link rel="stylesheet" href="<c:url value='/static/css/formValidation.min.css'/>">
  
  <script type="text/javascript" src="<c:url value='/static/scripts/jquery-1.11.1.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/bootstrap-3.3.7.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/static/scripts/md5.js'/>"></script>
  <script type="text/javascript" >
	function beforeSubmit() {
		var $pwd = $("#inputPassword");
		$pwd.val(b64_md5($pwd.val()));
		return true;
	}
  </script>
</head>
<body>
  <div class="container-fluid">
    <div class="row" style="height:60px;"></div>
    <div class="row">
      <div class="col-sm-1  col-md-2 col-lg-3"></div>
      <div class="col-xs-12  col-sm-10 col-md-8 col-lg-6">
        <div class="panel panel-info">
          <div class="panel-heading">用户登录</div>
          <div class="panel-body">
          	<c:url var="loginUrl" value="/login" />
            <form action="${loginUrl}" method="post" class="form-horizontal" onsubmit="return beforeSubmit();">
			  <c:if test="${param.error != null}">
                <div class="alert alert-danger">
                  <p>无效的用户名或密码！</p>
                </div>
              </c:if>
              <c:if test="${param.logout != null}">
                <div class="alert alert-success">
                  <p>您已经成功登出系统。</p>
                </div>
              </c:if>
              <input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />
              <div class="form-group">
                <label for="inputUsername" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-8">
                  <input type="text" class="form-control" id="inputUsername" name="username" placeholder="USER" required>
                </div>
                
              </div>
              <div class="form-group">
                <label for="inputPassword" class="col-sm-2 control-label">密 码</label>
                <div class="col-sm-8">
                  <input type="password" class="form-control" id="inputPassword" name="password" placeholder="PASSWORD" required>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-8">
                  <button type="submit" class="btn  btn-primary btn-block">登 &nbsp; 录</button>
                </div>
              </div>
            </form>
          </div>
        </div>
        </div>
      <div class="col-sm-1  col-md-2 col-lg-3"></div>
    </div>
  </div>
</body>
</html>