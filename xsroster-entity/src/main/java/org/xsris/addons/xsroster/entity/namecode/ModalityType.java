package org.xsris.addons.xsroster.entity.namecode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "MODALITY_TYPE")
public class ModalityType extends CommonNameCode {

	private static final long serialVersionUID = 6020953399614913323L;

}
