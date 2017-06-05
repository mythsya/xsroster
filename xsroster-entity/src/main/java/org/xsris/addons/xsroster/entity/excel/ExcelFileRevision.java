package org.xsris.addons.xsroster.entity.excel;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.xsris.addons.xsroster.entity.base.TrackableEntity;

@Entity
@Table(name = "EXCEL_FILE_REV")
public class ExcelFileRevision extends TrackableEntity {

	private static final long serialVersionUID = -4863017013391827435L;

	private String name;
	private String snapshot;
	private ExcelFile excelFile;
	private byte[] excelContent;
	private String jsonContent;
	private Set<ExcelFileRevisionOutput> outputs = new HashSet<ExcelFileRevisionOutput>();
	private Boolean published = false;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "EXCEL_CONTENT")
	public byte[] getExcelContent() {
		return excelContent;
	}

	@ManyToOne
	@JoinColumn(name = "EXCEL_FILE", nullable = false)
	public ExcelFile getExcelFile() {
		return excelFile;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "JSON_CONTENT")
	public String getJsonContent() {
		return jsonContent;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "excelFileRevision")
	public Set<ExcelFileRevisionOutput> getOutputs() {
		return outputs;
	}

	@Column(name = "IS_PUBLISHED")
	public Boolean getPublished() {
		return published;
	}

	@Column(name = "SNAPSHOT_NAME", length = 100)
	public String getSnapshot() {
		return snapshot;
	}

	public void setExcelContent(byte[] excelContent) {
		this.excelContent = excelContent;
	}

	public void setExcelFile(ExcelFile excel) {
		this.excelFile = excel;
	}

	public void setJsonContent(String jsonContent) {
		this.jsonContent = jsonContent;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOutputs(Set<ExcelFileRevisionOutput> outputs) {
		this.outputs = outputs;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public void setSnapshot(String snapshot) {
		this.snapshot = snapshot;
	}

}
