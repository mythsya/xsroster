package org.xsris.addons.xsroster.entity.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.jadira.usertype.dateandtime.joda.PersistentDateTime;
import org.joda.time.DateTime;

@MappedSuperclass
@TypeDef(name = "DateTime", defaultForType = DateTime.class, typeClass = PersistentDateTime.class)
public abstract class IdentifiableEntity implements Serializable {

	private static final long serialVersionUID = 4624644598386899054L;

	protected String id;

	@Id
	@Column(name = "id", length = 36)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator", parameters = {
			@Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy") })
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
