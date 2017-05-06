package org.xsris.addons.xsroster.entity.identity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.joda.time.DateTime;
import org.xsris.addons.xsroster.entity.metadata.Gender;
import org.xsris.addons.xsroster.entity.metadata.Gender.GenderType;

@MappedSuperclass
@TypeDef(name = "Gender", defaultForType = Gender.class, typeClass = GenderType.class)
public class Person extends Identity {

	private static final long serialVersionUID = -4314479973228797493L;

	private Name name;
	private DateTime dateOfBirth;
	private String placeOfBirth;
	private DateTime deceasedDate;
	private Gender gender;
	private String shortcut;
	private byte[] signature;
	private byte[] avatar;

	@Lob
	@Basic
	@Column(name = "AVATAR")
	public byte[] getAvatar() {
		return this.avatar;
	}

	@Type(type = "DateTime")
	@Column(name = "DATE_OF_BIRTH")
	public DateTime getDateOfBirth() {
		return this.dateOfBirth;
	}

	@Type(type = "DateTime")
	@Column(name = "DECEASED_DATE")
	public DateTime getDeceasedDate() {
		return this.deceasedDate;
	}

	@Type(type = "Gender")
	@Column(name = "GENDER", length = 2)
	public Gender getGender() {
		return this.gender;
	}

	@Embedded
	public Name getName() {
		return this.name;
	}

	@Column(name = "PLACE_OF_BIRTH", length = 1000)
	public String getPlaceOfBirth() {
		return this.placeOfBirth;
	}

	@Column(name = "SHORTCUT")
	public String getShortcut() {
		return this.shortcut;
	}

	@Lob
	@Basic
	@Column(name = "SIGNATURE")
	public byte[] getSignature() {
		return this.signature;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public void setDateOfBirth(DateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setDeceasedDate(DateTime deceasedDate) {
		this.deceasedDate = deceasedDate;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

}
