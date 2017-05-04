package org.xsris.addons.xsroster.entity.security;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.xsris.addons.xsroster.entity.base.OptimisticLockingEntity;

@Entity
@Table(name = "SEC_EXTERNAL_ROLE")
public class SecExternalRole extends OptimisticLockingEntity {

	private static final long serialVersionUID = 7686610498307754132L;

	private SecDomain domain;
	private String guid;
	private String name;
	private Set<SecRole> roles = new HashSet<SecRole>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOMAIN_ID", nullable = false)
	public SecDomain getDomain() {
		return this.domain;
	}

	@Column(name = "GUID")
	public String getGuid() {
		return this.guid;
	}

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "externalRoles", fetch = FetchType.LAZY)
	public Set<SecRole> getRoles() {
		return this.roles;
	}

	public void setDomain(SecDomain domain) {
		this.domain = domain;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRoles(Set<SecRole> roles) {
		this.roles = roles;
	}

}
