package org.xsris.addons.xsroster.entity.metadata;

public enum PatientClass {
	OUTPATIENT("O"),
	INPATIENT("I"),
	EMERGENCY("E"),
	UNKNOWN("U"),
	NOTAPPLICABLE("N"),
	OBSTETRICS("B"),
	COMMERCIALACCOUNT("C"),
	PREADMIT("P"),
	RECURRINGPATIENT("R");

	public static class PatientClassType extends GenericEnumType<PatientClass> {
		private static final long serialVersionUID = 6201826294364203912L;

		public PatientClassType() {
			super(PatientClass.class);
		}
	}

	public static PatientClass fromCode(String v) {
		for (PatientClass g : PatientClass.values()) {
			if (g.getCode().equalsIgnoreCase(v)) {
				return g;
			}
		}
		return UNKNOWN;
	}

	private final String code;

	PatientClass(String v) {
		this.code = v;
	}

	public String getCode() {
		return this.code;
	}
}
