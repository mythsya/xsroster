package org.xsris.addons.xsroster.entity.metadata;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.StringTypeDescriptor;

public class GenericEnumJavaTypeDescriptor<E extends Enum<E>> extends AbstractTypeDescriptor<E> {

	private static final long serialVersionUID = 1721688059296230277L;

	protected GenericEnumJavaTypeDescriptor(Class<E> type) {
		super(type);
	}

	@Override
	public E fromString(String name) {
		return Enum.valueOf(this.getJavaTypeClass(), name);
	}

	@Override
	public String toString(E e) {
		return e == null ? null : e.toString();
	}

	@Override
	public <X> X unwrap(E e, Class<X> type, WrapperOptions options) {
		if (e == null) {
			return StringTypeDescriptor.INSTANCE.unwrap(null, type, options);
		} else {
			Class<E> typeClazz = this.getJavaTypeClass();
			Method method;
			String code = null;
			try {
				method = typeClazz.getDeclaredMethod("getCode");
				code = (String) method.invoke(e);
			} catch (SecurityException e1) {
			} catch (NoSuchMethodException e1) {
			} catch (IllegalArgumentException e1) {
			} catch (IllegalAccessException e1) {
			} catch (InvocationTargetException e1) {
			}

			return StringTypeDescriptor.INSTANCE.unwrap(code, type, options);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public <X> E wrap(X value, WrapperOptions options) {
		String v = StringTypeDescriptor.INSTANCE.wrap(value, options);

		Class<E> typeClazz = this.getJavaTypeClass();
		Method method;
		E o = null;
		try {
			method = typeClazz.getDeclaredMethod("fromCode", String.class);
			o = (E) method.invoke(null, v);
		} catch (SecurityException e1) {
		} catch (NoSuchMethodException e1) {
		} catch (IllegalArgumentException e1) {
		} catch (IllegalAccessException e1) {
		} catch (InvocationTargetException e1) {
		}

		return o;
	}

}
