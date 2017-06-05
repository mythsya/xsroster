package org.xsris.addons.xsroster.entity.excel;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;
import org.xsris.addons.xsroster.entity.accesscontrol.PermissionSet;
import org.xsris.addons.xsroster.entity.base.OptimisticLockingTrackableEntity;
import org.xsris.addons.xsroster.entity.identity.Identity;
import org.xsris.addons.xsroster.entity.identity.Patient;
import org.xsris.addons.xsroster.entity.identity.Professional;
import org.xsris.addons.xsroster.entity.organization.Company;
import org.xsris.addons.xsroster.entity.organization.Department;
import org.xsris.addons.xsroster.entity.organization.Facility;

@Entity
@Table(name = "EXCEL_FILE", uniqueConstraints = @UniqueConstraint(name = "UK_EXCEL_FILE_TAGNAME", columnNames = { "TAG",
		"NAME" }))
public class ExcelFile extends OptimisticLockingTrackableEntity {

	private static final long serialVersionUID = 4199222537695429740L;

	private String name;
	private ExcelFileRevision currentRevision;
	private Boolean valid = true;
	private Identity owner;
	private PermissionSet permissionSet;
	private String tag;
	private Set<ExcelFileRevision> revisions = new HashSet<ExcelFileRevision>();

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CURRENT_REVISION", nullable = true)
	public ExcelFileRevision getCurrentRevision() {
		return currentRevision;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	@Any(metaColumn = @Column(name = "OWNER_TYPE"))
	@AnyMetaDef(idType = "string", metaType = "char", metaValues = {
			@MetaValue(targetEntity = Patient.class, value = "T"),
			@MetaValue(targetEntity = Professional.class, value = "F"),
			@MetaValue(targetEntity = Company.class, value = "C"),
			@MetaValue(targetEntity = Facility.class, value = "A"),
			@MetaValue(targetEntity = Department.class, value = "D") })
	@JoinColumn(name = "OWNER_ID")
	public Identity getOwner() {
		return owner;
	}

	@OneToOne
	@JoinColumn(name = "PERMISSION_SET", nullable = true)
	public PermissionSet getPermissionSet() {
		return permissionSet;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "excelFile")
	public Set<ExcelFileRevision> getRevisions() {
		return revisions;
	}

	@Column(name = "TAG", length = 50)
	public String getTag() {
		return tag;
	}

	@Column(name = "VALID")
	public Boolean getValid() {
		return valid;
	}

	public void setCurrentRevision(ExcelFileRevision currentRevision) {
		this.currentRevision = currentRevision;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(Identity owner) {
		this.owner = owner;
	}

	public void setPermissionSet(PermissionSet permissionSet) {
		this.permissionSet = permissionSet;
	}

	public void setRevisions(Set<ExcelFileRevision> revisions) {
		this.revisions = revisions;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

}
