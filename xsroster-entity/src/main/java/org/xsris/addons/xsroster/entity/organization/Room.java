package org.xsris.addons.xsroster.entity.organization;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.xsris.addons.xsroster.entity.base.OptimisticLockingTrackableEntity;

@Entity
@Table(name = "ROOM", uniqueConstraints = @UniqueConstraint(name = "UK_ROOM_CODE", columnNames = { "CODE" }))
public class Room extends OptimisticLockingTrackableEntity {

	private static final long serialVersionUID = 8297252229076763916L;
	private String code;
	private String name;
	private String nameSoundex;
	private String description;
	private Boolean autoCreated = false;
	private Boolean active = true;
	private Set<Facility> facilities = new HashSet<Facility>(0);
	private Set<Department> departments = new HashSet<Department>(0);
	private Set<Modality> modalities = new HashSet<Modality>(0);

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

	@ManyToMany
	@JoinTable(name = "ROOM_DEPARTMENT", joinColumns = @JoinColumn(name = "ROOM"), inverseJoinColumns = @JoinColumn(name = "DEPARTMENT"))
	public Set<Department> getDepartments() {
		return this.departments;
	}

	@Column(name = "DESCRIPTION", length = 2000)
	public String getDescription() {
		return this.description;
	}

	@ManyToMany
	@JoinTable(name = "ROOM_FACILITY", joinColumns = @JoinColumn(name = "ROOM"), inverseJoinColumns = @JoinColumn(name = "FACILITY"))
	public Set<Facility> getFacilities() {
		return this.facilities;
	}

	@ManyToMany
	@JoinTable(name = "ROOM_MODALITY", joinColumns = @JoinColumn(name = "ROOM"), inverseJoinColumns = @JoinColumn(name = "MODALITY"))
	public Set<Modality> getModalities() {
		return this.modalities;
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

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFacilities(Set<Facility> facilities) {
		this.facilities = facilities;
	}

	public void setModalities(Set<Modality> modalities) {
		this.modalities = modalities;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNameSoundex(String nameSoundex) {
		this.nameSoundex = nameSoundex;
	}

}
