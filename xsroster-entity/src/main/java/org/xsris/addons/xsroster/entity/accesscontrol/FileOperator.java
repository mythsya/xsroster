package org.xsris.addons.xsroster.entity.accesscontrol;

import org.xsris.addons.xsroster.entity.metadata.GenericEnumType;

public enum FileOperator {
	CREATE("C"),
	READ("R"),
	UPDATE("U"),
	DELETE("D"),
	NONE("N");

	public static class FileOperatorType extends GenericEnumType<FileOperator> {

		private static final long serialVersionUID = 4626886251219096618L;

		public FileOperatorType() {
			super(FileOperator.class);
		}
	}

	public static FileOperator fromCode(String v) {
		for (FileOperator g : FileOperator.values()) {
			if (g.getCode().equalsIgnoreCase(v)) {
				return g;
			}
		}
		return NONE;
	}

	private final String code;

	FileOperator(String v) {
		this.code = v;
	}

	public String getCode() {
		return this.code;
	}
}
