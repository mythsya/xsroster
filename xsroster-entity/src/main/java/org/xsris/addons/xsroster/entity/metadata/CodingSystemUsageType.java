package org.xsris.addons.xsroster.entity.metadata;

public enum CodingSystemUsageType {
	BILLING("B"),
	MODIFY_BILLING("M"),
	ALLERGIES("A"),
	PATIENT_SAFETY_HAZARD("S"),
	DIAGNOSIS("D"),
	UNKNOWN("U");

	public static class CodingSystemUsageTypeType extends GenericEnumType<CodingSystemUsageType> {

		private static final long serialVersionUID = 4626886251219096618L;

		public CodingSystemUsageTypeType() {
			super(CodingSystemUsageType.class);
		}
	}

	public static CodingSystemUsageType fromCode(String v) {
		for (CodingSystemUsageType g : CodingSystemUsageType.values()) {
			if (g.getCode().equalsIgnoreCase(v)) {
				return g;
			}
		}
		return UNKNOWN;
	}

	private final String code;

	CodingSystemUsageType(String v) {
		this.code = v;
	}

	public String getCode() {
		return this.code;
	}
}
