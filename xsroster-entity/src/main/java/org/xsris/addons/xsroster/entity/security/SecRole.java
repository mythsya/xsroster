package org.xsris.addons.xsroster.entity.security;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.xsris.addons.xsroster.entity.base.OptimisticLockingEntity;

@Entity
@Table(name = "SEC_ROLE")
public class SecRole extends OptimisticLockingEntity {

	private static final long serialVersionUID = 9186698232607960383L;

	private String code;
	private String name;
	private String description;
	private Boolean active = true;
	private Set<SecUser> users = new HashSet<SecUser>();
	private Set<SecExternalRole> externalRoles = new HashSet<SecExternalRole>();

	@Column(name = "ACTIVE")
	public Boolean getActive() {
		return this.active;
	}

	@Column(name = "CODE")
	public String getCode() {
		return this.code;
	}

	@Column(name = "DESCRIPTION", length = 4000)
	public String getDescription() {
		return this.description;
	}

	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "SEC_ROLE_MAPPING", inverseJoinColumns = @JoinColumn(name = "EXTERNAL_ROLE_ID"), joinColumns = @JoinColumn(name = "ROLE_ID"))
	public Set<SecExternalRole> getExternalRoles() {
		return this.externalRoles;
	}

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "roles", fetch = FetchType.LAZY)
	public Set<SecUser> getUsers() {
		return this.users;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExternalRoles(Set<SecExternalRole> externalRoles) {
		this.externalRoles = externalRoles;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsers(Set<SecUser> users) {
		this.users = users;
	}

}
