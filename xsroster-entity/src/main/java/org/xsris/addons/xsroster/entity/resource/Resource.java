package org.xsris.addons.xsroster.entity.resource;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.TypeDef;
import org.jadira.usertype.dateandtime.joda.PersistentDateTime;
import org.joda.time.DateTime;

@MappedSuperclass
@TypeDef(name = "DateTime", defaultForType = DateTime.class, typeClass = PersistentDateTime.class)
public abstract class Resource implements Serializable {

	private static final long serialVersionUID = 5610594126179584365L;

	@Id
	@Column(name = "id", length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	public String getCode() {
		return code;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
