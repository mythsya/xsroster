package org.xsris.addons.xsroster.entity.namecode;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "BODY_PART_GROUP")
public class BodyPartGroup extends CommonNameCode {

	private static final long serialVersionUID = -3456909409333343622L;

	protected Set<BodyPart> children = new HashSet<BodyPart>(0);

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	public Set<BodyPart> getChildren() {
		return this.children;
	}

	public void setChildren(Set<BodyPart> children) {
		this.children = children;
	}

}
