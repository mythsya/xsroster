package org.xsris.addons.xsroster.entity.metadata;

public enum CommunicationDataType {
	EMAILADDRESS("EMAIL"),
	FAXNUMBER("FAX"),
	INHOUSEADDRESS("HOUSE"),
	MOBILENUMBER("MOBILE"),
	TELEPHONENUMBER("PHONE"),
	POSTALADDRESS("POST"),
	PRINTER("PRINTER"),
	BUSINESSADDRESS("BIZ"),
	INSTANTMESSAGINGADDRESS("IM"),
	FULLQUALIFIEDADDRESS("FULL");

	public static class CommunicationDataTypeType extends GenericEnumType<CommunicationDataType> {
		private static final long serialVersionUID = 365252823017738409L;

		public CommunicationDataTypeType() {
			super(CommunicationDataType.class);
		}
	}

	public static CommunicationDataType fromCode(String v) {
		for (CommunicationDataType g : CommunicationDataType.values()) {
			if (g.getCode().equalsIgnoreCase(v)) {
				return g;
			}
		}
		return FULLQUALIFIEDADDRESS;
	}

	private final String code;

	CommunicationDataType(String v) {
		this.code = v;
	}

	public String getCode() {
		return this.code;
	}
}
