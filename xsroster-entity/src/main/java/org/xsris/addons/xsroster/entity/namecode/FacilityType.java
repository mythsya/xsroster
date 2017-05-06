package org.xsris.addons.xsroster.entity.namecode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "FACILITY_TYPE")
public class FacilityType extends CommonNameCode {

	private static final long serialVersionUID = 8305485549528994163L;

}
