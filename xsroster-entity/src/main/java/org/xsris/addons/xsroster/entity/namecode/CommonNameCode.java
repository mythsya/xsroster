package org.xsris.addons.xsroster.entity.namecode;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.xsris.addons.xsroster.entity.base.TrackableEntity;

@Entity
@Table(name = "COMMON_NAMECODE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING, length = 50)
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public abstract class CommonNameCode extends TrackableEntity {

	private static final long serialVersionUID = -2898296300542028146L;

	protected String code;
	protected String name;
	protected String nameSoundex;
	protected String description;
	protected Boolean autoCreated = false;
	protected Boolean active = true;
	protected Integer orderNumber;
	protected String category;
	protected String category2;
	protected String category3;
	protected byte[] icon;
	protected String hl7Field;
	protected String hl7Type;
	protected String hl7Code;

	@Column(name = "ACTIVE")
	public Boolean getActive() {
		return this.active;
	}

	@Column(name = "AUTO_CREATED")
	public Boolean getAutoCreated() {
		return this.autoCreated;
	}

	@Column(name = "CATEGORY")
	public String getCategory() {
		return this.category;
	}

	@Column(name = "CATEGORY2")
	public String getCategory2() {
		return this.category2;
	}

	@Column(name = "CATEGORY3")
	public String getCategory3() {
		return this.category3;
	}

	@Column(name = "CODE", nullable = false, length = 200)
	public String getCode() {
		return this.code;
	}

	@Column(name = "DESCRIPTION", length = 2000)
	public String getDescription() {
		return this.description;
	}

	@Column(name = "HL7_CODE")
	public String getHl7Code() {
		return this.hl7Code;
	}

	@Column(name = "HL7_FIELD")
	public String getHl7Field() {
		return this.hl7Field;
	}

	@Column(name = "HL7_TYPE")
	public String getHl7Type() {
		return this.hl7Type;
	}

	@Lob
	@Basic
	@Column(name = "ICON")
	public byte[] getIcon() {
		return this.icon;
	}

	@Column(name = "NAME", nullable = false, length = 1000)
	public String getName() {
		return this.name;
	}

	@Column(name = "NAME_SOUNDEX", length = 1000)
	public String getNameSoundex() {
		return this.nameSoundex;
	}

	@Column(name = "ORDER_NR")
	public Integer getOrderNumber() {
		return this.orderNumber;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setAutoCreated(Boolean autoCreated) {
		this.autoCreated = autoCreated;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public void setCategory3(String category3) {
		this.category3 = category3;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHl7Code(String hl7Code) {
		this.hl7Code = hl7Code;
	}

	public void setHl7Field(String hl7Field) {
		this.hl7Field = hl7Field;
	}

	public void setHl7Type(String hl7Type) {
		this.hl7Type = hl7Type;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNameSoundex(String nameSoundex) {
		this.nameSoundex = nameSoundex;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

}
