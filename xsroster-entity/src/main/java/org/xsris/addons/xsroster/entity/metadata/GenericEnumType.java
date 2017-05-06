package org.xsris.addons.xsroster.entity.metadata;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

public class GenericEnumType<E extends Enum<E>> extends AbstractSingleColumnStandardBasicType<E> {

	private static final long serialVersionUID = 4052115877738588824L;

	public GenericEnumType(Class<E> clazz) {
		super(VarcharTypeDescriptor.INSTANCE, new GenericEnumJavaTypeDescriptor<E>(clazz));
	}

	@Override
	public String getName() {
		return this.getJavaTypeDescriptor().getJavaTypeClass().getName();
	}

	@Override
	protected boolean registerUnderJavaType() {
		return true;
	}
}
