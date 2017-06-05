package org.xsris.addons.xsroster.web.view;

public class ExcelView {
	private String id;
	private String name;
	private String tag;
	private String content;
	private String revisionId;

	public String getContent() {
		return content;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRevisionId() {
		return revisionId;
	}

	public String getTag() {
		return tag;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRevisionId(String revisionId) {
		this.revisionId = revisionId;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
