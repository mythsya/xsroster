package org.xsris.addons.xsroster.entity.resource.def;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.xsris.addons.xsroster.entity.base.OptimisticLockingTrackableEntity;

@Entity
@Table(name = "RESOURCE_LAYOUT")
public class ResourceLayout extends OptimisticLockingTrackableEntity {

	private static final long serialVersionUID = 5567141433356656185L;

	private String code;
	private String title;
	private List<ResourceDefinition> rowHeaders;
	private List<ResourceDefinition> colHeaders;

}
