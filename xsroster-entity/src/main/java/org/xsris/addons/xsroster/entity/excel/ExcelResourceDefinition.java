package org.xsris.addons.xsroster.entity.excel;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.xsris.addons.xsroster.entity.base.OptimisticLockingTrackableEntity;

// @Entity
// @Table(name = "EXCEL_RESOURCE_DEFINITION")
public class ExcelResourceDefinition extends OptimisticLockingTrackableEntity {

	private static final long serialVersionUID = 397333560727649555L;
	private ExcelFileRevision excelFileRevision;

	@ManyToOne
	@JoinColumn(name = "EXCEL_FILE_REV")
	public ExcelFileRevision getExcelFileRevision() {
		return excelFileRevision;
	}

	public void setExcelFileRevision(ExcelFileRevision excelFileRevision) {
		this.excelFileRevision = excelFileRevision;
	}
}
