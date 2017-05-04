package org.xsris.addons.xsroster.entity.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.xsris.addons.xsroster.entity.base.OptimisticLockingEntity;

@Entity
@Table(name = "SEC_USER_DOMAIN")
public class SecUserDomain extends OptimisticLockingEntity {

	private static final long serialVersionUID = 6457740889445564786L;

	private SecUser user;
	private SecDomain domain;
	private String externalLoginName;
	private String externalId;

	@ManyToOne
	@JoinColumn(name = "DOMAIN_ID", nullable = false)
	public SecDomain getDomain() {
		return this.domain;
	}

	@Column(name = "EXTERNAL_ID")
	public String getExternalId() {
		return this.externalId;
	}

	@Column(name = "EXTERNAL_LOGIN_NAME")
	public String getExternalLoginName() {
		return this.externalLoginName;
	}

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	public SecUser getUser() {
		return this.user;
	}

	public void setDomain(SecDomain domain) {
		this.domain = domain;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public void setExternalLoginName(String externalLoginName) {
		this.externalLoginName = externalLoginName;
	}

	public void setUser(SecUser user) {
		this.user = user;
	}

}
