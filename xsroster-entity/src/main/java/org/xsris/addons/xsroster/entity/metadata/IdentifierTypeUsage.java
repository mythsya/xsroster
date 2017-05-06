package org.xsris.addons.xsroster.entity.metadata;

public enum IdentifierTypeUsage {
	FORPATIENT("T"),
	FORPROFESSIONAL("F"),
	FORFACILITY("A"),
	FORDEPARTMENT("D"),
	UNKNOWN("U");

	public static class IdentifierTypeUsageType extends GenericEnumType<IdentifierTypeUsage> {
		private static final long serialVersionUID = 6201826294364203912L;

		public IdentifierTypeUsageType() {
			super(IdentifierTypeUsage.class);
		}
	}

	public static IdentifierTypeUsage fromCode(String v) {
		for (IdentifierTypeUsage g : IdentifierTypeUsage.values()) {
			if (g.getCode().equalsIgnoreCase(v)) {
				return g;
			}
		}
		return UNKNOWN;
	}

	private final String code;

	IdentifierTypeUsage(String v) {
		this.code = v;
	}

	public String getCode() {
		return this.code;
	}

}
