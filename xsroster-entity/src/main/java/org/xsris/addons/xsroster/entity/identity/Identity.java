package org.xsris.addons.xsroster.entity.identity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.xsris.addons.xsroster.entity.base.OptimisticLockingTrackableEntity;

@MappedSuperclass
public abstract class Identity extends OptimisticLockingTrackableEntity {

	private static final long serialVersionUID = 7192498667950149500L;

	private Boolean active = true;
	protected Set<IdentityCode> identityCodes = new HashSet<IdentityCode>(0);
	protected Set<CommunicationChannel> communicationChannels = new HashSet<CommunicationChannel>(0);

	@Column(name = "ACTIVE")
	public Boolean getActive() {
		return this.active;
	}

	@Transient
	public Set<CommunicationChannel> getCommunicationChannels() {
		return this.communicationChannels;
	}

	@Transient
	public Set<IdentityCode> getIdentityCodes() {
		return this.identityCodes;
	}

	@Transient
	public String getType() {
		return "IDT";
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setCommunicationChannels(Set<CommunicationChannel> communicationChannels) {
		this.communicationChannels = communicationChannels;
	}

	public void setIdentityCodes(Set<IdentityCode> identityCodes) {
		this.identityCodes = identityCodes;
	}

}
