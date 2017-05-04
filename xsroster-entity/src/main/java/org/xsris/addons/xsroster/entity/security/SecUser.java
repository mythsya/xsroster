package org.xsris.addons.xsroster.entity.security;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.xsris.addons.xsroster.entity.base.OptimisticLockingEntity;
import org.xsris.addons.xsroster.entity.identity.Patient;
import org.xsris.addons.xsroster.entity.identity.Person;
import org.xsris.addons.xsroster.entity.identity.Professional;

@Entity
@Table(name = "SEC_USER")
public class SecUser extends OptimisticLockingEntity {

	private static final long serialVersionUID = -4312362266974499109L;

	private String loginName;
	private Boolean valid = true;
	private Boolean reserved = false;
	private DateTime activeFrom;
	private DateTime activeTill;
	private DateTime createdWhen;
	private DateTime modifiedWhen;
	private DateTime lockedWhen;
	private Long failedLoginCount = 0L;
	private String guiLanguage;
	private Set<SecPassword> passwords = new HashSet<SecPassword>();
	private Set<SecToken> tokens = new HashSet<SecToken>();
	private Set<SecRole> roles = new HashSet<SecRole>();
	private Set<SecUserDomain> userDomains = new HashSet<SecUserDomain>();
	private Person person;

	@Type(type = "DateTime")
	@Column(name = "ACTIVE_FROM")
	public DateTime getActiveFrom() {
		return this.activeFrom;
	}

	@Type(type = "DateTime")
	@Column(name = "ACTIVE_TILL")
	public DateTime getActiveTill() {
		return this.activeTill;
	}

	@Type(type = "DateTime")
	@Column(name = "CREATED_WHEN")
	public DateTime getCreatedWhen() {
		return this.createdWhen;
	}

	@Column(name = "FAIL_LOGIN_COUNT", precision = 38, scale = 0, columnDefinition = "NUMBER(38,0)")
	public Long getFailedLoginCount() {
		return this.failedLoginCount;
	}

	@Column(name = "GUI_LANGUAGE")
	public String getGuiLanguage() {
		return this.guiLanguage;
	}

	@Type(type = "DateTime")
	@Column(name = "LOCKED_WHEN")
	public DateTime getLockedWhen() {
		return this.lockedWhen;
	}

	@Column(name = "LOGIN_NAME")
	public String getLoginName() {
		return this.loginName;
	}

	@Type(type = "DateTime")
	@Column(name = "MODIFIED_WHEN")
	public DateTime getModifiedWhen() {
		return this.modifiedWhen;
	}

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "user")
	public Set<SecPassword> getPasswords() {
		return this.passwords;
	}

	@Any(metaColumn = @Column(name = "PERSON_TYPE"))
	@AnyMetaDef(idType = "long", metaType = "char", metaValues = {
			@MetaValue(targetEntity = Patient.class, value = "T"),
			@MetaValue(targetEntity = Professional.class, value = "F") })
	@JoinColumn(name = "PERSON_ID", columnDefinition = "NUMBER(38,0)")
	public Person getPerson() {
		return this.person;
	}

	@Column(name = "RESERVED_USER")
	public Boolean getReserved() {
		return this.reserved;
	}

	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "SEC_USER_ROLE", inverseJoinColumns = @JoinColumn(name = "ROLE_ID"), joinColumns = @JoinColumn(name = "USER_ID"))
	public Set<SecRole> getRoles() {
		return this.roles;
	}

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "user")
	public Set<SecToken> getTokens() {
		return this.tokens;
	}

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "user")
	public Set<SecUserDomain> getUserDomains() {
		return this.userDomains;
	}

	@Column(name = "VALID")
	public Boolean getValid() {
		return this.valid;
	}

	public void setActiveFrom(DateTime activeFrom) {
		this.activeFrom = activeFrom;
	}

	public void setActiveTill(DateTime activeTill) {
		this.activeTill = activeTill;
	}

	public void setCreatedWhen(DateTime createdWhen) {
		this.createdWhen = createdWhen;
	}

	public void setFailedLoginCount(Long failedLoginCount) {
		this.failedLoginCount = failedLoginCount;
	}

	public void setGuiLanguage(String guiLanguage) {
		this.guiLanguage = guiLanguage;
	}

	public void setLockedWhen(DateTime lockedWhen) {
		this.lockedWhen = lockedWhen;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setModifiedWhen(DateTime modifiedWhen) {
		this.modifiedWhen = modifiedWhen;
	}

	public void setPasswords(Set<SecPassword> passwords) {
		this.passwords = passwords;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setReserved(Boolean reserved) {
		this.reserved = reserved;
	}

	public void setRoles(Set<SecRole> roles) {
		this.roles = roles;
	}

	public void setTokens(Set<SecToken> tokens) {
		this.tokens = tokens;
	}

	public void setUserDomains(Set<SecUserDomain> userDomains) {
		this.userDomains = userDomains;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}
}
