package org.xsris.addons.xsroster.entity.resource.def;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.xsris.addons.xsroster.entity.base.OptimisticLockingTrackableEntity;

@Entity
@Table(name = "RESOURCE_DEFINITION", uniqueConstraints = @UniqueConstraint(name = "UK_RESOURCE_DEF_CODE", columnNames = {
		"CODE" }))
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING, length = 2)
@DiscriminatorValue(value = "B")
public abstract class ResourceDefinition extends OptimisticLockingTrackableEntity {

	private static final long serialVersionUID = -3854967571881461345L;

	private String code;
	private String name;
	private String nameSoundex;
	private String description;
	private Boolean autoCreated = false;
	private Boolean active = true;
	private String category;
	private String category2;
	private String category3;
	private byte[] icon;
	private Boolean leaf = true;
	private ResourceDefinition parent;
	private Set<ResourceDefinition> children;

	@Column(name = "ACTIVE")
	public Boolean getActive() {
		return this.active;
	}

	@Column(name = "AUTO_CREATED")
	public Boolean getAutoCreated() {
		return this.autoCreated;
	}

	@Column(name = "CATEGORY")
	public String getCategory() {
		return this.category;
	}

	@Column(name = "CATEGORY2")
	public String getCategory2() {
		return this.category2;
	}

	@Column(name = "CATEGORY3")
	public String getCategory3() {
		return this.category3;
	}

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	public Set<ResourceDefinition> getChildren() {
		return children;
	}

	@Column(name = "CODE", nullable = false, length = 200)
	public String getCode() {
		return this.code;
	}

	@Column(name = "DESCRIPTION", length = 2000)
	public String getDescription() {
		return this.description;
	}

	@Lob
	@Basic
	@Column(name = "ICON")
	public byte[] getIcon() {
		return this.icon;
	}

	@Column(name = "LEAF")
	public Boolean getLeaf() {
		return leaf;
	}

	@Column(name = "NAME", nullable = false, length = 1000)
	public String getName() {
		return this.name;
	}

	@Column(name = "NAME_SOUNDEX", length = 1000)
	public String getNameSoundex() {
		return this.nameSoundex;
	}

	@ManyToOne
	@JoinColumn(name = "PARENT")
	public ResourceDefinition getParent() {
		return parent;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setAutoCreated(Boolean autoCreated) {
		this.autoCreated = autoCreated;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public void setCategory3(String category3) {
		this.category3 = category3;
	}

	public void setChildren(Set<ResourceDefinition> children) {
		this.children = children;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNameSoundex(String nameSoundex) {
		this.nameSoundex = nameSoundex;
	}

	public void setParent(ResourceDefinition parent) {
		this.parent = parent;
	}

}
