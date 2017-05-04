package org.xsris.addons.xsroster.entity.identity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENT")
public class Patient extends Person {

	private static final long serialVersionUID = 2105350175789221716L;

	private Boolean isVIP = false;
	private String vipType;
	private String ssn;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "PATIENT_ID")
	@Override
	public Set<CommunicationChannel> getCommunicationChannels() {
		return this.communicationChannels;
	}

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "PATIENT_ID")
	@Override
	public Set<IdentityCode> getIdentityCodes() {
		return this.identityCodes;
	}

	@Column(name = "IS_VIP")
	public Boolean getIsVIP() {
		return this.isVIP;
	}

	@Column(name = "SSN", length = 100)
	public String getSsn() {
		return this.ssn;
	}

	@Column(name = "VIP_TYPE", length = 20)
	public String getVipType() {
		return this.vipType;
	}

	public void setIsVIP(Boolean isVIP) {
		this.isVIP = isVIP;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setVipType(String vipType) {
		this.vipType = vipType;
	}

}
