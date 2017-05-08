package org.xsris.addons.xsroster.entity.resource.def;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;
import org.xsris.addons.xsroster.entity.base.IdentifiableEntity;
import org.xsris.addons.xsroster.entity.identity.Professional;
import org.xsris.addons.xsroster.entity.namecode.BodyPart;
import org.xsris.addons.xsroster.entity.namecode.BodyPartGroup;
import org.xsris.addons.xsroster.entity.namecode.ModalityType;
import org.xsris.addons.xsroster.entity.namecode.Specialism;
import org.xsris.addons.xsroster.entity.organization.Company;
import org.xsris.addons.xsroster.entity.organization.Department;
import org.xsris.addons.xsroster.entity.organization.Facility;
import org.xsris.addons.xsroster.entity.organization.Modality;
import org.xsris.addons.xsroster.entity.organization.Room;

@Entity
@DiscriminatorValue(value = "P")
public class PredefinedResourceDefinition extends ResourceDefinition {

	private static final long serialVersionUID = -5411628708623168277L;

	private IdentifiableEntity ref;

	@Any(metaColumn = @Column(name = "REF_TYPE"))
	@AnyMetaDef(idType = "string", metaType = "string", metaValues = {
			@MetaValue(targetEntity = Professional.class, value = "PF"),
			@MetaValue(targetEntity = Company.class, value = "CM"),
			@MetaValue(targetEntity = Facility.class, value = "FT"),
			@MetaValue(targetEntity = Modality.class, value = "MD"),
			@MetaValue(targetEntity = Room.class, value = "RM"),
			@MetaValue(targetEntity = ModalityType.class, value = "MT"),
			@MetaValue(targetEntity = Specialism.class, value = "SP"),
			@MetaValue(targetEntity = Department.class, value = "DP"),
			@MetaValue(targetEntity = BodyPart.class, value = "BP"),
			@MetaValue(targetEntity = BodyPartGroup.class, value = "BG"),
			@MetaValue(targetEntity = CalendarDefinition.class, value = "CD") })
	@JoinColumn(name = "REF_ID")
	public IdentifiableEntity getRef() {
		return ref;
	}

	public void setRef(IdentifiableEntity ref) {
		this.ref = ref;
	}
}
