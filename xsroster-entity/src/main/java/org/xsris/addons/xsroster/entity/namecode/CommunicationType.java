package org.xsris.addons.xsroster.entity.namecode;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.xsris.addons.xsroster.entity.metadata.CommunicationDataType;
import org.xsris.addons.xsroster.entity.metadata.CommunicationDataType.CommunicationDataTypeType;

@Entity
@DiscriminatorValue(value = "COMMUNICATION_TYPE")
@TypeDef(name = "CommunicationDataType", defaultForType = CommunicationDataType.class, typeClass = CommunicationDataTypeType.class)
public class CommunicationType extends CommonNameCode {

	private static final long serialVersionUID = -309610545371118034L;

	private CommunicationDataType dataType;

	@Type(type = "CommunicationDataType")
	@Column(name = "DATA_TYPE", length = 50)
	public CommunicationDataType getDataType() {
		return this.dataType;
	}

	public void setDataType(CommunicationDataType dataType) {
		this.dataType = dataType;
	}

}
