package org.xsris.addons.xsroster.entity.organization;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.xsris.addons.xsroster.entity.base.OptimisticLockingTrackableEntity;
import org.xsris.addons.xsroster.entity.namecode.ModalityType;

@Entity
@Table(name = "MODALITY", uniqueConstraints = { @UniqueConstraint(name = "UK_MODALITY_CODE", columnNames = { "CODE" }),
		@UniqueConstraint(name = "UK_MODALITY_NAME_AETITLE", columnNames = { "NAME", "AETITLE" }) })
public class Modality extends OptimisticLockingTrackableEntity {

	private static final long serialVersionUID = 2036528575765921721L;
	private String code;
	private String name;
	private String nameSoundex;
	private String description;
	private Boolean autoCreated = false;
	private Boolean active = true;
	private Boolean useAsDefault = false;
	private String aeTitle;
	private String callingAeTitle;
	private ModalityType modalityType;
	private Facility facility;
	private Department department;
	private Set<Room> rooms = new HashSet<Room>(0);

	@Column(name = "ACTIVE")
	public Boolean getActive() {
		return this.active;
	}

	@Column(name = "AETITLE", length = 200)
	public String getAeTitle() {
		return this.aeTitle;
	}

	@Column(name = "AUTO_CREATED")
	public Boolean getAutoCreated() {
		return this.autoCreated;
	}

	@Column(name = "CALLING_AETITLE", length = 200)
	public String getCallingAeTitle() {
		return this.callingAeTitle;
	}

	@Column(name = "CODE", nullable = false, length = 200)
	public String getCode() {
		return this.code;
	}

	@ManyToOne
	@JoinColumn(name = "DEPARTMENT")
	public Department getDepartment() {
		return this.department;
	}

	@Column(name = "DESCRIPTION", length = 2000)
	public String getDescription() {
		return this.description;
	}

	@ManyToOne
	@JoinColumn(name = "FACILITY")
	public Facility getFacility() {
		return this.facility;
	}

	@ManyToOne
	@JoinColumn(name = "MODALITY_TYPE")
	public ModalityType getModalityType() {
		return this.modalityType;
	}

	@Column(name = "NAME", nullable = false, length = 1000)
	public String getName() {
		return this.name;
	}

	@Column(name = "NAME_SOUNDEX", length = 1000)
	public String getNameSoundex() {
		return this.nameSoundex;
	}

	@ManyToMany(mappedBy = "modalities")
	public Set<Room> getRooms() {
		return this.rooms;
	}

	@Column(name = "USE_AS_DEFAULT")
	public Boolean getUseAsDefault() {
		return this.useAsDefault;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setAeTitle(String aeTitle) {
		this.aeTitle = aeTitle;
	}

	public void setAutoCreated(Boolean autoCreated) {
		this.autoCreated = autoCreated;
	}

	public void setCallingAeTitle(String callingAeTitle) {
		this.callingAeTitle = callingAeTitle;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public void setModalityType(ModalityType modalityType) {
		this.modalityType = modalityType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNameSoundex(String nameSoundex) {
		this.nameSoundex = nameSoundex;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public void setUseAsDefault(Boolean useAsDefault) {
		this.useAsDefault = useAsDefault;
	}

}
