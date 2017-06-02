package org.xsris.addons.xsroster.entity.metadata;

public enum ConfigValueType {
	STRING("STR"),
	INTEGER("INT"),
	BOOLEAN("BOOL"),
	DATETIME("DT"),
	BLOB("BLOB");

	public static class ConfigValueTypeType extends GenericEnumType<ConfigValueType> {
		private static final long serialVersionUID = 365252823017738409L;

		public ConfigValueTypeType() {
			super(ConfigValueType.class);
		}
	}

	public static ConfigValueType fromCode(String v) {
		for (ConfigValueType g : ConfigValueType.values()) {
			if (g.getCode().equalsIgnoreCase(v)) {
				return g;
			}
		}
		return STRING;
	}

	private final String code;

	ConfigValueType(String v) {
		this.code = v;
	}

	public String getCode() {
		return this.code;
	}
}
