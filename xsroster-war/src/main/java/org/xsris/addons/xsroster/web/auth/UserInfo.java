package org.xsris.addons.xsroster.web.auth;

import java.util.Collection;

import org.joda.time.DateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserInfo extends User {

	private static final long serialVersionUID = 5193531706774402902L;
	private String id;
	private String name;
	private DateTime loginTime;
	private String loginIP;
	private String salt;

	public UserInfo(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public UserInfo(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public String getId() {
		return id;
	}

	public String getLoginIP() {
		return loginIP;
	}

	public DateTime getLoginTime() {
		return loginTime;
	}

	public String getName() {
		return name;
	}

	public String getSalt() {
		return salt;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}

	public void setLoginTime(DateTime loginTime) {
		this.loginTime = loginTime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
}
