package org.xsris.addons.xsroster.entity.excel;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.xsris.addons.xsroster.entity.base.TrackableEntity;
import org.xsris.addons.xsroster.entity.metadata.OutputFormat;

@Entity
@Table(name = "EXCEL_FILE_REV_OUTPUT")
public class ExcelFileRevisionOutput extends TrackableEntity {

	private static final long serialVersionUID = -4431506343388884885L;

	public static final int INCLUDE_ALL_SHEETS = -1;
	private int sheetIndex = ExcelFileRevisionOutput.INCLUDE_ALL_SHEETS;
	private String sheetName;
	private byte[] data;
	private ExcelFileRevision excelFileRevision;
	private OutputFormat format;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "DATA_CONTENT")
	public byte[] getData() {
		return data;
	}

	@ManyToOne
	@JoinColumn(name = "EXCEL_FILE_REV")
	public ExcelFileRevision getExcelFileRevision() {
		return excelFileRevision;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "DATA_FORMAT", length = 20)
	public OutputFormat getFormat() {
		return format;
	}

	@Column(name = "SHEET_INDEX")
	public int getSheetIndex() {
		return sheetIndex;
	}

	@Column(name = "SHEET_NAME")
	public String getSheetName() {
		return sheetName;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public void setExcelFileRevision(ExcelFileRevision rev) {
		this.excelFileRevision = rev;
	}

	public void setFormat(OutputFormat format) {
		this.format = format;
	}

	public void setSheetIndex(int sheetIndex) {
		this.sheetIndex = sheetIndex;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
}
