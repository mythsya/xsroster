package org.xsris.addons.xsroster.entity.metadata;

public enum Gender {
	AMBIGUOUS("A"),
	FEMALE("F"),
	MALE("M"),
	NOTAPPLICABLE("N"),
	OTHER("O"),
	UNKNOWN("U");

	public static class GenderType extends GenericEnumType<Gender> {
		private static final long serialVersionUID = 365252823017738409L;

		public GenderType() {
			super(Gender.class);
		}
	}

	public static Gender fromCode(String v) {
		for (Gender g : Gender.values()) {
			if (g.getCode().equalsIgnoreCase(v)) {
				return g;
			}
		}
		return UNKNOWN;
	}

	private final String code;

	Gender(String v) {
		this.code = v;
	}

	public String getCode() {
		return this.code;
	}
}
