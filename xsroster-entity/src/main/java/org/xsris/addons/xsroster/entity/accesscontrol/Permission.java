package org.xsris.addons.xsroster.entity.accesscontrol;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.xsris.addons.xsroster.entity.base.IdentifiableEntity;

@Entity
@Table(name = "AC_PERMISSION")
public class Permission extends IdentifiableEntity {

	private static final long serialVersionUID = -1138924837516842949L;

	private PermissionSet permissionSet;

	@ManyToOne
	@JoinColumn(name = "PERMISSION_SET")
	public PermissionSet getPermissionSet() {
		return permissionSet;
	}

	public void setPermissionSet(PermissionSet permissionSet) {
		this.permissionSet = permissionSet;
	}
}
