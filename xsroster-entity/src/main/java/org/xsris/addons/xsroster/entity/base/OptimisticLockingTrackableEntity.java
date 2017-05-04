package org.xsris.addons.xsroster.entity.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class OptimisticLockingTrackableEntity extends TrackableEntity {

	private static final long serialVersionUID = 811264831172380336L;

	private Long version = 0L;

	@Version
	@Column(precision = 38, scale = 0, columnDefinition = "NUMBER(38,0)")
	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
