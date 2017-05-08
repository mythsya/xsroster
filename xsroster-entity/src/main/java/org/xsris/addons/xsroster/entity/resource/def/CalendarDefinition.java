package org.xsris.addons.xsroster.entity.resource.def;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.xsris.addons.xsroster.entity.base.OptimisticLockingTrackableEntity;

@Entity
@Table(name = "CALENDAR_DEFINITION", uniqueConstraints = @UniqueConstraint(name = "UK_CALENDAR_DEF_CODE", columnNames = {
		"CODE" }))
public class CalendarDefinition extends OptimisticLockingTrackableEntity {

	private static final long serialVersionUID = 7337060175328766818L;

	private String code;
	private String name;
	private String nameSoundex;
	private String description;
	private Boolean autoCreated = false;
	private Boolean active = true;

	@Column(name = "ACTIVE")
	public Boolean getActive() {
		return this.active;
	}

	@Column(name = "AUTO_CREATED")
	public Boolean getAutoCreated() {
		return this.autoCreated;
	}

	@Column(name = "CODE", nullable = false, length = 200)
	public String getCode() {
		return this.code;
	}

	@Column(name = "DESCRIPTION", length = 2000)
	public String getDescription() {
		return this.description;
	}

	@Column(name = "NAME", nullable = false, length = 1000)
	public String getName() {
		return this.name;
	}

	@Column(name = "NAME_SOUNDEX", length = 1000)
	public String getNameSoundex() {
		return this.nameSoundex;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setAutoCreated(Boolean autoCreated) {
		this.autoCreated = autoCreated;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNameSoundex(String nameSoundex) {
		this.nameSoundex = nameSoundex;
	}
}
