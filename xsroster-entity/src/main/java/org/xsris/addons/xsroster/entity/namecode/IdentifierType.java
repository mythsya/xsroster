package org.xsris.addons.xsroster.entity.namecode;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.xsris.addons.xsroster.entity.metadata.IdentifierTypeUsage;
import org.xsris.addons.xsroster.entity.metadata.IdentifierTypeUsage.IdentifierTypeUsageType;

@Entity
@DiscriminatorValue(value = "IDENTIFIER_TYPE")
@TypeDef(name = "IdentifierTypeUsage", defaultForType = IdentifierTypeUsage.class, typeClass = IdentifierTypeUsageType.class)
public class IdentifierType extends CommonNameCode {

	private static final long serialVersionUID = -3416564235431002926L;

	private IdentifierTypeUsage usage;

	@Type(type = "IdentifierTypeUsage")
	@Column(name = "IDENTIFIER_TYPE_USAGE", length = 100)
	public IdentifierTypeUsage getUsage() {
		return this.usage;
	}

	public void setUsage(IdentifierTypeUsage usage) {
		this.usage = usage;
	}

}
