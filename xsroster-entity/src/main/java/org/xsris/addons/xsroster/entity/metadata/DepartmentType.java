package org.xsris.addons.xsroster.entity.metadata;

public enum DepartmentType {
	NORMAL("N"),
	WARD("W"),
	BOTH("NW");

	public static class DepartmentTypeType extends GenericEnumType<DepartmentType> {
		private static final long serialVersionUID = -5221367579969748367L;

		public DepartmentTypeType() {
			super(DepartmentType.class);
		}
	}

	public static DepartmentType fromCode(String v) {
		for (DepartmentType g : DepartmentType.values()) {
			if (g.getCode().equalsIgnoreCase(v)) {
				return g;
			}
		}
		return NORMAL;
	}

	private final String code;

	DepartmentType(String v) {
		this.code = v;
	}

	public String getCode() {
		return this.code;
	}
}
