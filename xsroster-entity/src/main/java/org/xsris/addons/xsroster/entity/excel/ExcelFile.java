package org.xsris.addons.xsroster.entity.excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.xsris.addons.xsroster.entity.base.OptimisticLockingTrackableEntity;

@Entity
@Table(name = "EXCEL_FILE")
public class ExcelFile extends OptimisticLockingTrackableEntity {

	private static final long serialVersionUID = 4199222537695429740L;

	private String name;
	private ExcelFileRevision currentRevision;

	@OneToOne
	@JoinColumn(name = "CURRENT_REVISION", nullable = false)
	public ExcelFileRevision getCurrentRevision() {
		return currentRevision;
	}

	@Column(name = "NAME", nullable = false, length = 200)
	public String getName() {
		return name;
	}

	public void setCurrentRevision(ExcelFileRevision currentRevision) {
		this.currentRevision = currentRevision;
	}

	public void setName(String name) {
		this.name = name;
	}

}
