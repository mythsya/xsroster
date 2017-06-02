package org.xsris.addons.xsroster.entity.configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.xsris.addons.xsroster.entity.base.TrackableEntity;

@Entity
@Table(name = "CONFIG_NAME_SPACE")
public class ConfigNamespace extends TrackableEntity {

	private static final long serialVersionUID = -7781019277574227845L;
	private String name;
	private String label;
	private Boolean showInPreferences = true;
	private Boolean active = true;

	@Column(name = "ACTIVE")
	public Boolean getActive() {
		return active;
	}

	@Column(name = "LABEL", length = 1000)
	public String getLabel() {
		return label;
	}

	@Column(name = "NAME", unique = true)
	public String getName() {
		return name;
	}

	@Column(name = "SHOW_IN_PREFERENCES")
	public Boolean getShowInPreferences() {
		return showInPreferences;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setShowInPreferences(Boolean showInPreferences) {
		this.showInPreferences = showInPreferences;
	}
}
