package org.xsris.addons.xsroster.web.view;

import org.xsris.addons.xsroster.common.HelperUtils;

public class JsonResult {
	public static final String STATUS_SUCCESS = "success";
	public static final String STATUS_ERROR = "error";

	public static final JsonResult error() {
		return new JsonResult(JsonResult.STATUS_ERROR, "", "");
	}

	public static final JsonResult error(String code, String message) {
		return new JsonResult(JsonResult.STATUS_ERROR, code, message);
	}

	public static final JsonResult error(String code, String message, String rootCause) {
		return new JsonResult(JsonResult.STATUS_ERROR, code, message, rootCause);
	}

	public static final JsonResult error(String code, String message, Throwable t) {
		return new JsonResult(JsonResult.STATUS_ERROR, code, message, t);
	}

	public static final JsonResult success() {
		return new JsonResult(JsonResult.STATUS_SUCCESS, "", "");
	}

	public static final JsonResult success(String code, String message) {
		return new JsonResult(JsonResult.STATUS_SUCCESS, code, message);
	}

	private String status;
	private String code;
	private String message;
	private String rootCause;

	public JsonResult() {
	}

	public JsonResult(String status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public JsonResult(String status, String code, String message, String rootCause) {
		this.status = status;
		this.code = code;
		this.message = message;
		this.rootCause = rootCause;
	}

	public JsonResult(String status, String code, String message, Throwable t) {
		this.status = status;
		this.code = code;
		this.message = message;
		if (t != null) {
			this.rootCause = HelperUtils.getPrintStackTrace(t);
		}
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getRootCause() {
		return rootCause;
	}

	public String getStatus() {
		return status;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
