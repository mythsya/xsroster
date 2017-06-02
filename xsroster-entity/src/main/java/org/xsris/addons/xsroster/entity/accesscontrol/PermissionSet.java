package org.xsris.addons.xsroster.entity.accesscontrol;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.xsris.addons.xsroster.entity.base.TrackableEntity;

@Entity
@Table(name = "AC_PERMISSION_SET")
public class PermissionSet extends TrackableEntity {

	private static final long serialVersionUID = 6021433121483739607L;
	private String code;
	private String description;
	private Boolean active = true;
	private Set<Permission> permissions = new HashSet<Permission>();

	@Column(name = "ACTIVE")
	public Boolean getActive() {
		return active;
	}

	@Column(name = "CODE", unique = true)
	public String getCode() {
		return code;
	}

	@Column(name = "DESCRIPTION", length = 1000)
	public String getDescription() {
		return description;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "permissionSet")
	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
}
