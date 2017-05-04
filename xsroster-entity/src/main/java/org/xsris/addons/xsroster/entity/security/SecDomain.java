package org.xsris.addons.xsroster.entity.security;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.xsris.addons.xsroster.entity.base.OptimisticLockingEntity;

@Entity
@Table(name = "SEC_DOMAIN")
public class SecDomain extends OptimisticLockingEntity {

	private static final long serialVersionUID = 3418660887234894353L;

	private String code;
	private String name;
	private Long sequence;
	private Set<SecExternalRole> externalRoles = new HashSet<SecExternalRole>();
	private Set<SecUserDomain> userDomains = new HashSet<SecUserDomain>();

	@Column(name = "CODE")
	public String getCode() {
		return this.code;
	}

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "domain")
	public Set<SecExternalRole> getExternalRoles() {
		return this.externalRoles;
	}

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	@Column(name = "SEQUENCE", precision = 38, scale = 0, columnDefinition = "NUMBER(38,0)")
	public Long getSequence() {
		return this.sequence;
	}

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "domain")
	public Set<SecUserDomain> getUserDomains() {
		return this.userDomains;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setExternalRoles(Set<SecExternalRole> externalRoles) {
		this.externalRoles = externalRoles;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public void setUserDomains(Set<SecUserDomain> userDomains) {
		this.userDomains = userDomains;
	}

}
