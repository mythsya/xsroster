package org.xsris.addons.xsroster.entity.configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.xsris.addons.xsroster.entity.base.TrackableEntity;
import org.xsris.addons.xsroster.entity.metadata.ConfigValueType;
import org.xsris.addons.xsroster.entity.metadata.ConfigValueType.ConfigValueTypeType;

@Entity
@Table(name = "CONFIG_KEY")
@TypeDef(name = "ConfigValueType", defaultForType = ConfigValueType.class, typeClass = ConfigValueTypeType.class)
public class ConfigKey extends TrackableEntity {

	private static final long serialVersionUID = -7363458118842379756L;
	private ConfigNamespace namespace;
	private String key;
	private String label;
	private ConfigValueType dataType;
	private Boolean showInPreferences = true;
	private Boolean active = true;
	private Boolean onSystem = false;
	private Boolean onFacility = false;
	private Boolean onDepartment = false;
	private Boolean onProfile = false;
	private Boolean onUser = false;

	@Column(name = "ACTIVE")
	public Boolean getActive() {
		return active;
	}

	@Type(type = "ConfigValueType")
	@Column(name = "DATA_TYPE", length = 6)
	public ConfigValueType getDataType() {
		return dataType;
	}

	@Column(name = "KEY", unique = true)
	public String getKey() {
		return key;
	}

	@Column(name = "LABEL", length = 1000)
	public String getLabel() {
		return label;
	}

	@ManyToOne
	@JoinColumn(name = "NAME_SPACE")
	public ConfigNamespace getNamespace() {
		return namespace;
	}

	@Column(name = "ON_DEPARTMENT")
	public Boolean getOnDepartment() {
		return onDepartment;
	}

	@Column(name = "ON_FACILITY")
	public Boolean getOnFacility() {
		return onFacility;
	}

	@Column(name = "ON_PROFILE")
	public Boolean getOnProfile() {
		return onProfile;
	}

	@Column(name = "ON_SYSTEM")
	public Boolean getOnSystem() {
		return onSystem;
	}

	@Column(name = "ON_USER")
	public Boolean getOnUser() {
		return onUser;
	}

	@Column(name = "SHOW_IN_PREFERENCES")
	public Boolean getShowInPreferences() {
		return showInPreferences;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setDataType(ConfigValueType dataType) {
		this.dataType = dataType;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setNamespace(ConfigNamespace namespace) {
		this.namespace = namespace;
	}

	public void setOnDepartment(Boolean onDepartment) {
		this.onDepartment = onDepartment;
	}

	public void setOnFacility(Boolean onFacility) {
		this.onFacility = onFacility;
	}

	public void setOnProfile(Boolean onProfile) {
		this.onProfile = onProfile;
	}

	public void setOnSystem(Boolean onSystem) {
		this.onSystem = onSystem;
	}

	public void setOnUser(Boolean onUser) {
		this.onUser = onUser;
	}

	public void setShowInPreferences(Boolean showInPreferences) {
		this.showInPreferences = showInPreferences;
	}

}
