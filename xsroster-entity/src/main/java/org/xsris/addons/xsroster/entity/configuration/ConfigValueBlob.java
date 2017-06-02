package org.xsris.addons.xsroster.entity.configuration;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.xsris.addons.xsroster.entity.base.IdentifiableEntity;

@Entity
@Table(name = "CONFIG_VALUE_BLOB")
public class ConfigValueBlob extends IdentifiableEntity {

	private static final long serialVersionUID = 3529349495754805453L;

	private byte[] value;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "BLOB_VALUE")
	public byte[] getValue() {
		return value;
	}

	public void setValue(byte[] value) {
		this.value = value;
	}

}
