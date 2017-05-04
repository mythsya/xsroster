package org.xsris.addons.xsroster.entity.security;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.xsris.addons.xsroster.entity.base.IdentifiableEntity;

@Entity
@Table(name = "SEC_TOKEN")
public class SecToken extends IdentifiableEntity {

	private static final long serialVersionUID = -3202513761894037204L;

	private SecUser user;
	private String object;
	private DateTime dateOfExpiration;

	@Type(type = "DateTime")
	@Column(name = "DATE_OF_EXPIRATION")
	public DateTime getDateOfExpiration() {
		return this.dateOfExpiration;
	}

	@Lob
	@Basic
	@Column(name = "OBJECT")
	public String getObject() {
		return this.object;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	public SecUser getUser() {
		return this.user;
	}

	public void setDateOfExpiration(DateTime dateOfExpiration) {
		this.dateOfExpiration = dateOfExpiration;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public void setUser(SecUser user) {
		this.user = user;
	}
}
