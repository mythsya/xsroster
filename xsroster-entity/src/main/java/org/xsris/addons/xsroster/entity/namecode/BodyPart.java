package org.xsris.addons.xsroster.entity.namecode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "BODY_PART")
public class BodyPart extends CommonNameCode {

	private static final long serialVersionUID = -5142565934041920710L;

	protected BodyPartGroup parent;

	@ManyToOne
	@JoinColumn(name = "PARENT")
	public BodyPartGroup getParent() {
		return this.parent;
	}

	public void setParent(BodyPartGroup parent) {
		this.parent = parent;
	}
}
