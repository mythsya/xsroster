package org.xsris.addons.xsroster.entity.identity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name implements Serializable {

	private static final long serialVersionUID = -7578954731915204934L;

	private String idiographicName;
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneticName;

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return this.firstName;
	}

	@Column(name = "IDIOGRAPHIC_NAME", length = 1000)
	public String getIdiographicName() {
		return this.idiographicName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return this.lastName;
	}

	@Column(name = "MIDDLE_NAME")
	public String getMiddleName() {
		return this.middleName;
	}

	@Column(name = "PHONETIC_NAME", length = 1000)
	public String getPhoneticName() {
		return this.phoneticName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setIdiographicName(String idiographicName) {
		this.idiographicName = idiographicName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setPhoneticName(String phoneticName) {
		this.phoneticName = phoneticName;
	}

}
