package org.xsris.addons.xsroster.entity.metadata;

public enum ServiceType {
	RADIOLOGY("R"),
	PATHOLOGY("P"),
	ULTRASOUND("U"),
	ENDOSCOPY("E"),
	LABORATORY("L");

	public static class ServiceTypeType extends GenericEnumType<ServiceType> {
		private static final long serialVersionUID = 6201826294364203912L;

		public ServiceTypeType() {
			super(ServiceType.class);
		}
	}

	public static ServiceType fromCode(String v) {
		for (ServiceType g : ServiceType.values()) {
			if (g.getCode().equalsIgnoreCase(v)) {
				return g;
			}
		}
		return RADIOLOGY;
	}

	private final String code;

	ServiceType(String v) {
		this.code = v;
	}

	public String getCode() {
		return this.code;
	}
}
