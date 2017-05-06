package org.xsris.addons.xsroster.entity.organization;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.xsris.addons.xsroster.entity.identity.CommunicationChannel;
import org.xsris.addons.xsroster.entity.identity.Identity;
import org.xsris.addons.xsroster.entity.identity.IdentityCode;
import org.xsris.addons.xsroster.entity.metadata.DepartmentType;
import org.xsris.addons.xsroster.entity.metadata.DepartmentType.DepartmentTypeType;

@Entity
@Table(name = "DEPARTMENT")
@TypeDef(name = "DepartmentType", defaultForType = DepartmentType.class, typeClass = DepartmentTypeType.class)
public class Department extends Identity {

	private static final long serialVersionUID = 5214135421968551528L;

	private String name;
	private String nameSoundex;
	private Facility facility;
	private Department parent;
	private Boolean isExternal = false;
	private Boolean isRequesting = true;
	private Boolean isPerforming = false;
	private Boolean isER = false;
	private Boolean canBeCurrent = true;
	private byte[] logo;
	private DepartmentType departmentType;

	@Column(name = "CAN_BE_CURRENT")
	public Boolean getCanBeCurrent() {
		return this.canBeCurrent;
	}

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "DEPARTMENT_ID")
	@Override
	public Set<CommunicationChannel> getCommunicationChannels() {
		return this.communicationChannels;
	}

	@Type(type = "DepartmentType")
	@Column(name = "DEPARTMENT_TYPE", length = 2)
	public DepartmentType getDepartmentType() {
		return this.departmentType;
	}

	@ManyToOne
	@JoinColumn(name = "FACILITY")
	public Facility getFacility() {
		return this.facility;
	}

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "DEPARTMENT_ID")
	@Override
	public Set<IdentityCode> getIdentityCodes() {
		return this.identityCodes;
	}

	@Column(name = "IS_ER")
	public Boolean getIsER() {
		return this.isER;
	}

	@Column(name = "IS_EXTERNAL")
	public Boolean getIsExternal() {
		return this.isExternal;
	}

	@Column(name = "IS_PERFORMING")
	public Boolean getIsPerforming() {
		return this.isPerforming;
	}

	@Column(name = "IS_REQUESTING")
	public Boolean getIsRequesting() {
		return this.isRequesting;
	}

	@Lob
	@Basic
	@Column(name = "LOGO")
	public byte[] getLogo() {
		return this.logo;
	}

	@Column(name = "NAME", length = 1000)
	public String getName() {
		return this.name;
	}

	@Column(name = "NAME_SOUNDEX", length = 1000)
	public String getNameSoundex() {
		return this.nameSoundex;
	}

	@ManyToOne
	@JoinColumn(name = "PARENT")
	public Department getParent() {
		return this.parent;
	}

	public void setCanBeCurrent(Boolean canBeCurrent) {
		this.canBeCurrent = canBeCurrent;
	}

	public void setDepartmentType(DepartmentType departmentType) {
		this.departmentType = departmentType;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public void setIsER(Boolean isER) {
		this.isER = isER;
	}

	public void setIsExternal(Boolean isExternal) {
		this.isExternal = isExternal;
	}

	public void setIsPerforming(Boolean isPerforming) {
		this.isPerforming = isPerforming;
	}

	public void setIsRequesting(Boolean isRequesting) {
		this.isRequesting = isRequesting;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNameSoundex(String nameSoundex) {
		this.nameSoundex = nameSoundex;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}
}
