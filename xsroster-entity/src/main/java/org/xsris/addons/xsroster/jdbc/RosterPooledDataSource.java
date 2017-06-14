package org.xsris.addons.xsroster.jdbc;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.xsris.addons.xsroster.common.DESCoder;

public class RosterPooledDataSource extends DataSource {

	private String desKey = "E/d2eUX73ws=";

	public String getDesKey() {
		return desKey;
	}

	public void setDesKey(String desKey) {
		this.desKey = desKey;
	}

	@Override
	public void setPassword(String password) {
		if (StringUtils.isNotBlank(password)) {
			password = StringUtils.trimToEmpty(password);
			try {
				password = DESCoder.decryptString(password, getDesKey());
			} catch (Exception e) {
			}
		}
		this.poolProperties.setPassword(password);
		this.poolProperties.getDbProperties().setProperty("password", this.poolProperties.getPassword());
	}
}
