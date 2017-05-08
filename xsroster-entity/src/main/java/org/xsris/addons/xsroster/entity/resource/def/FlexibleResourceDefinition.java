package org.xsris.addons.xsroster.entity.resource.def;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "F")
public class FlexibleResourceDefinition extends ResourceDefinition {

	private static final long serialVersionUID = -7622917208361972697L;

}
