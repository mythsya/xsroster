package org.xsris.addons.xsroster.web.view;

import java.util.ArrayList;
import java.util.List;

public class ExcelView {
	public static class ExcelSheetView {
		private String id;
		private int index;
		private String name;

		public ExcelSheetView() {

		}

		public ExcelSheetView(String id, int idx, String name) {
			this.id = id;
			this.index = idx;
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public int getIndex() {
			return index;
		}

		public String getName() {
			return name;
		}

		public void setId(String id) {
			this.id = id;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	private String id;
	private String name;
	private String tag;
	private String content;
	private String revisionId;
	private List<ExcelSheetView> sheets = new ArrayList<ExcelSheetView>();

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

	public List<ExcelSheetView> getSheets() {
		return sheets;
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

	public void setSheets(List<ExcelSheetView> sheets) {
		this.sheets = sheets;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
