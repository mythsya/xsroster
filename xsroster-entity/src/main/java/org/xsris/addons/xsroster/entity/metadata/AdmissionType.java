package org.xsris.addons.xsroster.entity.metadata;

public enum AdmissionType {
	ACCIDENT("A"),
	ELECTIVE("C"),
	EMERGENCY("E"),
	LABORANDDELIVERY("L"),
	NEWBORN("N"),
	ROUTINE("R"),
	URGENT("U");

	public static class AdmissionTypeType extends GenericEnumType<AdmissionType> {
		private static final long serialVersionUID = 443038466718930717L;

		public AdmissionTypeType() {
			super(AdmissionType.class);
		}
	}

	public static AdmissionType fromCode(String v) {
		for (AdmissionType g : AdmissionType.values()) {
			if (g.getCode().equalsIgnoreCase(v)) {
				return g;
			}
		}
		return ACCIDENT;
	}

	private final String code;

	AdmissionType(String v) {
		this.code = v;
	}

	public String getCode() {
		return this.code;
	}
}
