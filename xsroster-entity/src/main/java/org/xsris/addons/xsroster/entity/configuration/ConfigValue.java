package org.xsris.addons.xsroster.entity.configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.joda.time.DateTime;
import org.xsris.addons.xsroster.entity.base.TrackableEntity;
import org.xsris.addons.xsroster.entity.metadata.SetOnLevel;
import org.xsris.addons.xsroster.entity.metadata.SetOnLevel.SetOnLevelType;

@Entity
@Table(name = "CONFIG_VALUE")
@TypeDef(name = "SetOnLevel", defaultForType = SetOnLevel.class, typeClass = SetOnLevelType.class)
public class ConfigValue extends TrackableEntity {

	private static final long serialVersionUID = 4141313708339865452L;

	private String key;
	private String stringValue;
	private Integer intValue;
	private Boolean boolValue;
	private DateTime datetimeValue;
	private ConfigValueBlob blobValue;
	private SetOnLevel setOnLevel;
	private String setOnTarget;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BLOB_VALUE")
	public ConfigValueBlob getBlobValue() {
		return blobValue;
	}

	@Column(name = "BOOLEAN_VALUE")
	public Boolean getBoolValue() {
		return boolValue;
	}

	@Column(name = "DATETIME_VALUE")
	public DateTime getDatetimeValue() {
		return datetimeValue;
	}

	@Column(name = "INTEGER_VALUE")
	public Integer getIntValue() {
		return intValue;
	}

	@Column(name = "KEY")
	public String getKey() {
		return key;
	}

	@Type(type = "SetOnLevel")
	@Column(name = "SET_ON_LEVEL", length = 4)
	public SetOnLevel getSetOnLevel() {
		return setOnLevel;
	}

	@Column(name = "SET_ON_TARGET", length = 64)
	public String getSetOnTarget() {
		return setOnTarget;
	}

	@Column(name = "STRING_VALUE", length = 1000)
	public String getStringValue() {
		return stringValue;
	}

	public void setBlobValue(ConfigValueBlob blobValue) {
		this.blobValue = blobValue;
	}

	public void setBoolValue(Boolean boolValue) {
		this.boolValue = boolValue;
	}

	public void setDatetimeValue(DateTime datetimeValue) {
		this.datetimeValue = datetimeValue;
	}

	public void setIntValue(Integer intValue) {
		this.intValue = intValue;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setSetOnLevel(SetOnLevel setOnLevel) {
		this.setOnLevel = setOnLevel;
	}

	public void setSetOnTarget(String setOnTarget) {
		this.setOnTarget = setOnTarget;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
}
