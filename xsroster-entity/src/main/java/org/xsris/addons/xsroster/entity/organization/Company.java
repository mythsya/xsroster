package org.xsris.addons.xsroster.entity.organization;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.xsris.addons.xsroster.entity.identity.CommunicationChannel;
import org.xsris.addons.xsroster.entity.identity.Identity;
import org.xsris.addons.xsroster.entity.identity.IdentityCode;

@Entity
@Table(name = "FACILITY")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING, length = 2)
@DiscriminatorValue(value = "C")
public class Company extends Identity {

	private static final long serialVersionUID = -8330345387862210652L;

	private String name;
	private String nameSoundex;
	private String website;
	private byte[] logo;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "FACILITY_ID")
	@Override
	public Set<CommunicationChannel> getCommunicationChannels() {
		return this.communicationChannels;
	}

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "FACILITY_ID")
	@Override
	public Set<IdentityCode> getIdentityCodes() {
		return this.identityCodes;
	}

	@Lob
	@Basic
	@Column(name = "LOGO")
	public byte[] getLogo() {
		return this.logo;
	}

	@Column(name = "NAME", length = 1000)
	public String getName() {
		return this.name;
	}

	@Column(name = "NAME_SOUNDEX", length = 1000)
	public String getNameSoundex() {
		return this.nameSoundex;
	}

	@Column(name = "WEBSITE", length = 1000)
	public String getWebsite() {
		return this.website;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNameSoundex(String nameSoundex) {
		this.nameSoundex = nameSoundex;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
