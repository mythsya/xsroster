package org.xsris.addons.xsroster.entity.identity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.xsris.addons.xsroster.entity.base.IdentifiableEntity;
import org.xsris.addons.xsroster.entity.namecode.IdentifierType;
import org.xsris.addons.xsroster.entity.organization.Company;
import org.xsris.addons.xsroster.entity.organization.Department;
import org.xsris.addons.xsroster.entity.organization.Facility;

@Entity
@Table(name = "IDENTITY_CODE", uniqueConstraints = @UniqueConstraint(name = "UK_IDENTITY_CODE_CODE", columnNames = {
		"CODE" }))
public class IdentityCode extends IdentifiableEntity {

	private static final long serialVersionUID = -5010680317444626221L;

	private Identity identity;
	private String code;
	private AssigningAuthority assigningAuthority;
	private IdentifierType identifierType;
	private DateTime validFrom;
	private DateTime validTill;
	private IdentityCode mergedTo;
	private Boolean mergeChecked = false;

	@ManyToOne
	@JoinColumn(name = "ASSIGNING_AUTHORITY")
	public AssigningAuthority getAssigningAuthority() {
		return this.assigningAuthority;
	}

	@Column(name = "CODE", nullable = false, length = 200)
	public String getCode() {
		return this.code;
	}

	@ManyToOne
	@JoinColumn(name = "IDENTIFIER_TYPE")
	public IdentifierType getIdentifierType() {
		return this.identifierType;
	}

	@Any(metaColumn = @Column(name = "IDENTITY_TYPE"))
	@AnyMetaDef(idType = "long", metaType = "char", metaValues = {
			@MetaValue(targetEntity = Patient.class, value = "T"),
			@MetaValue(targetEntity = Professional.class, value = "F"),
			@MetaValue(targetEntity = Company.class, value = "C"),
			@MetaValue(targetEntity = Facility.class, value = "A"),
			@MetaValue(targetEntity = Department.class, value = "D") })
	@JoinColumn(name = "IDENTITY_ID")
	public Identity getIdentity() {
		return this.identity;
	}

	@Column(name = "MERGE_CHECKED", nullable = false)
	public Boolean getMergeChecked() {
		return this.mergeChecked;
	}

	@ManyToOne
	@JoinColumn(name = "MERGED_TO")
	public IdentityCode getMergedTo() {
		return this.mergedTo;
	}

	@Type(type = "DateTime")
	@Column(name = "VALID_FROM")
	public DateTime getValidFrom() {
		return this.validFrom;
	}

	@Type(type = "DateTime")
	@Column(name = "VALID_TILL")
	public DateTime getValidTill() {
		return this.validTill;
	}

	public void setAssigningAuthority(AssigningAuthority assigningAuthority) {
		this.assigningAuthority = assigningAuthority;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setIdentifierType(IdentifierType identifierType) {
		this.identifierType = identifierType;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public void setMergeChecked(Boolean mergeChecked) {
		this.mergeChecked = mergeChecked;
	}

	public void setMergedTo(IdentityCode mergedTo) {
		this.mergedTo = mergedTo;
	}

	public void setValidFrom(DateTime validFrom) {
		this.validFrom = validFrom;
	}

	public void setValidTill(DateTime validTill) {
		this.validTill = validTill;
	}
}
