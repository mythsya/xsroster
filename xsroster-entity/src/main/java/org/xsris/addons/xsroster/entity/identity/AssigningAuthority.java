package org.xsris.addons.xsroster.entity.identity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.xsris.addons.xsroster.entity.base.TrackableEntity;
import org.xsris.addons.xsroster.entity.organization.Facility;

@Entity
@Table(name = "ASSIGNING_AUTHORITY", uniqueConstraints = @UniqueConstraint(name = "UK_ASSIGNING_AUTHORITY_CODE", columnNames = {
		"CODE" }))
public class AssigningAuthority extends TrackableEntity {

	private static final long serialVersionUID = -2429133904390451222L;

	private String code;
	private String name;
	private String description;
	private Facility facility;

	@Column(nullable = false, length = 200)
	public String getCode() {
		return this.code;
	}

	@Column(name = "DESCRIPTION", length = 2000)
	public String getDescription() {
		return this.description;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FACILITY", nullable = false)
	public Facility getFacility() {
		return this.facility;
	}

	@Column(name = "NAME", length = 1000)
	public String getName() {
		return this.name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public void setName(String name) {
		this.name = name;
	}

}
