package org.xsris.addons.xsroster.entity.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.xsris.addons.xsroster.entity.base.IdentifiableEntity;

@Entity
@Table(name = "SEC_PASSWORD")
public class SecPassword extends IdentifiableEntity {

	private static final long serialVersionUID = -8276722436814050857L;

	private SecUser user;
	private String password;
	private DateTime dateOfCreation;
	private DateTime dateOfExpiration;

	@Type(type = "DateTime")
	@Column(name = "DATE_OF_CREATION", nullable = false)
	public DateTime getDateOfCreation() {
		return this.dateOfCreation;
	}

	@Type(type = "DateTime")
	@Column(name = "DATE_OF_EXPIRATION")
	public DateTime getDateOfExpiration() {
		return this.dateOfExpiration;
	}

	@Column(name = "PASSWORD", length = 1000)
	public String getPassword() {
		return this.password;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	public SecUser getUser() {
		return this.user;
	}

	public void setDateOfCreation(DateTime dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public void setDateOfExpiration(DateTime dateOfExpiration) {
		this.dateOfExpiration = dateOfExpiration;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUser(SecUser user) {
		this.user = user;
	}

}
