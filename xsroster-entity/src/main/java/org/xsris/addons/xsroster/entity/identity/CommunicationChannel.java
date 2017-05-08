package org.xsris.addons.xsroster.entity.identity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.xsris.addons.xsroster.entity.base.IdentifiableEntity;
import org.xsris.addons.xsroster.entity.namecode.CommunicationType;
import org.xsris.addons.xsroster.entity.organization.Company;
import org.xsris.addons.xsroster.entity.organization.Department;
import org.xsris.addons.xsroster.entity.organization.Facility;

@Entity
@Table(name = "COMMUNICATION_CHANNEL")
public class CommunicationChannel extends IdentifiableEntity {

	private static final long serialVersionUID = 7413557915393571955L;

	private Identity identity;
	private DateTime validFrom;
	private DateTime validTill;
	private Boolean preferred = false;
	private Boolean defaultForDataType = false;
	private String alias;
	private String comments;
	private String street;
	private String streetnr;
	private String municipality;
	private String country;
	private String town;
	private String telephoneNumber;
	private String mobileNumber;
	private String email;
	private String zipCode;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String addressLine4;
	private String printer;
	private String instantMessagingAccount;
	private CommunicationType communicationType;

	@Column(name = "ADDRESS_LINE1", length = 1000)
	public String getAddressLine1() {
		return this.addressLine1;
	}

	@Column(name = "ADDRESS_LINE2", length = 500)
	public String getAddressLine2() {
		return this.addressLine2;
	}

	@Column(name = "ADDRESS_LINE3", length = 500)
	public String getAddressLine3() {
		return this.addressLine3;
	}

	@Column(name = "ADDRESS_LINE4", length = 500)
	public String getAddressLine4() {
		return this.addressLine4;
	}

	@Column(name = "ALIAS")
	public String getAlias() {
		return this.alias;
	}

	@Column(name = "COMMENTS", length = 2000)
	public String getComments() {
		return this.comments;
	}

	@ManyToOne
	@JoinColumn(name = "COMMUNICATION_TYPE")
	public CommunicationType getCommunicationType() {
		return this.communicationType;
	}

	@Column(name = "COUNTRY", length = 100)
	public String getCountry() {
		return this.country;
	}

	@Column(name = "DAFAULT_FOR_DATA_TYPE")
	public Boolean getDefaultForDataType() {
		return this.defaultForDataType;
	}

	@Column(name = "EMAIL", length = 100)
	public String getEmail() {
		return this.email;
	}

	@Any(metaColumn = @Column(name = "IDENTITY_TYPE"))
	@AnyMetaDef(idType = "long", metaType = "char", metaValues = {
			@MetaValue(targetEntity = Patient.class, value = "T"),
			@MetaValue(targetEntity = Professional.class, value = "F"),
			@MetaValue(targetEntity = Company.class, value = "C"),
			@MetaValue(targetEntity = Facility.class, value = "A"),
			@MetaValue(targetEntity = Department.class, value = "D") })
	@JoinColumn(name = "IDENTITY_ID")
	public Identity getIdentity() {
		return this.identity;
	}

	@Column(name = "INSTANT_MESSAGING", length = 100)
	public String getInstantMessagingAccount() {
		return this.instantMessagingAccount;
	}

	@Column(name = "MOBILE_NUMBER", length = 50)
	public String getMobileNumber() {
		return this.mobileNumber;
	}

	@Column(name = "MUNICIPALITY", length = 100)
	public String getMunicipality() {
		return this.municipality;
	}

	@Column(name = "PREFERRED")
	public Boolean getPreferred() {
		return this.preferred;
	}

	@Column(name = "PRINTER")
	public String getPrinter() {
		return this.printer;
	}

	@Column(name = "STREET", length = 500)
	public String getStreet() {
		return this.street;
	}

	@Column(name = "STREET_NR", length = 50)
	public String getStreetnr() {
		return this.streetnr;
	}

	@Column(name = "TELEPHONE_NUMBER", length = 50)
	public String getTelephoneNumber() {
		return this.telephoneNumber;
	}

	@Column(name = "TOWN")
	public String getTown() {
		return this.town;
	}

	@Type(type = "DateTime")
	@Column(name = "VALID_FROM")
	public DateTime getValidFrom() {
		return this.validFrom;
	}

	@Type(type = "DateTime")
	@Column(name = "VALID_TILL")
	public DateTime getValidTill() {
		return this.validTill;
	}

	@Column(name = "ZIP_CODE", length = 50)
	public String getZipCode() {
		return this.zipCode;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setCommunicationType(CommunicationType communicationType) {
		this.communicationType = communicationType;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setDefaultForDataType(Boolean defaultForDataType) {
		this.defaultForDataType = defaultForDataType;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public void setInstantMessagingAccount(String instantMessagingAccount) {
		this.instantMessagingAccount = instantMessagingAccount;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public void setPreferred(Boolean preferred) {
		this.preferred = preferred;
	}

	public void setPrinter(String printer) {
		this.printer = printer;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setStreetnr(String streetnr) {
		this.streetnr = streetnr;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public void setValidFrom(DateTime validFrom) {
		this.validFrom = validFrom;
	}

	public void setValidTill(DateTime validTill) {
		this.validTill = validTill;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
