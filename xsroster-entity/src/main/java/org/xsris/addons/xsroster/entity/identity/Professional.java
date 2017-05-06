package org.xsris.addons.xsroster.entity.identity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.xsris.addons.xsroster.entity.namecode.Specialism;
import org.xsris.addons.xsroster.entity.organization.Department;

@Entity
@Table(name = "PROFESSIONAL")
public class Professional extends Person {

	private static final long serialVersionUID = 382647422571317479L;

	private Boolean autoCreated = false;
	private Boolean external = false;
	private Set<Department> departments = new HashSet<Department>(0);
	private Set<Specialism> specialisms = new HashSet<Specialism>(0);

	@Column(name = "AUTO_CREATED")
	public Boolean getAutoCreated() {
		return this.autoCreated;
	}

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "PROFESSIONAL_ID")
	@Override
	public Set<CommunicationChannel> getCommunicationChannels() {
		return this.communicationChannels;
	}

	@ManyToMany
	@JoinTable(name = "PROFESSIONAL_DEPARTMENT", joinColumns = @JoinColumn(name = "PROFESSIONAL"), inverseJoinColumns = @JoinColumn(name = "DEPARTMENT"))
	public Set<Department> getDepartments() {
		return this.departments;
	}

	@Column(name = "IS_EXTERNAL")
	public Boolean getExternal() {
		return this.external;
	}

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "PROFESSIONAL_ID")
	@Override
	public Set<IdentityCode> getIdentityCodes() {
		return this.identityCodes;
	}

	@ManyToMany
	@JoinTable(name = "PROFESSIONAL_SPECIALISM", joinColumns = @JoinColumn(name = "PROFESSIONAL"), inverseJoinColumns = @JoinColumn(name = "SPECIALISM"))
	public Set<Specialism> getSpecialisms() {
		return this.specialisms;
	}

	public void setAutoCreated(Boolean autoCreated) {
		this.autoCreated = autoCreated;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public void setExternal(Boolean external) {
		this.external = external;
	}

	public void setSpecialisms(Set<Specialism> specialisms) {
		this.specialisms = specialisms;
	}

}
