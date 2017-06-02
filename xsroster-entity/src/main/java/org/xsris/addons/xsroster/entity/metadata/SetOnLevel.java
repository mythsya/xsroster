package org.xsris.addons.xsroster.entity.metadata;

public enum SetOnLevel {
	ON_SYSTEM(9),
	ON_FACILITY(8),
	ON_DEPARTMENT(7),
	ON_PROFILE(5),
	ON_WORKSTATION_GROUP(3),
	ON_WORKSTATION(2),
	ON_USER(1);

	public static class SetOnLevelType extends GenericEnumType<SetOnLevel> {
		private static final long serialVersionUID = 365252823017738409L;

		public SetOnLevelType() {
			super(SetOnLevel.class);
		}
	}

	public static SetOnLevel fromCode(int v) {
		for (SetOnLevel g : SetOnLevel.values()) {
			if (g.getCode() == v) {
				return g;
			}
		}
		return ON_SYSTEM;
	}

	private final int code;

	SetOnLevel(int v) {
		this.code = v;
	}

	public int getCode() {
		return this.code;
	}
}
