package org.xsris.addons.xsroster.entity.namecode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "SPECIALISM")
public class Specialism extends CommonNameCode {

	private static final long serialVersionUID = -2496731288472733521L;

}
