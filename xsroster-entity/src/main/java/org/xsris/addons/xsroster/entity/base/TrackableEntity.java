package org.xsris.addons.xsroster.entity.base;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.xsris.addons.xsroster.entity.security.SecUser;

@MappedSuperclass
public abstract class TrackableEntity extends IdentifiableEntity {

	private static final long serialVersionUID = 1918884770265819814L;

	private DateTime createdWhen;
	private SecUser createdBy;
	private DateTime modifiedWhen;
	private SecUser modifiedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_BY")
	public SecUser getCreatedBy() {
		return this.createdBy;
	}

	@Type(type = "DateTime")
	@Column(name = "CREATED_WHEN")
	public DateTime getCreatedWhen() {
		return this.createdWhen;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODIFIED_BY")
	public SecUser getModifiedBy() {
		return this.modifiedBy;
	}

	@Type(type = "DateTime")
	@Column(name = "MODIFIED_WHEN")
	public DateTime getModifiedWhen() {
		return this.modifiedWhen;
	}

	public void setCreatedBy(SecUser createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedWhen(DateTime createdWhen) {
		this.createdWhen = createdWhen;
	}

	public void setModifiedBy(SecUser modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setModifiedWhen(DateTime modifiedWhen) {
		this.modifiedWhen = modifiedWhen;
	}

}
