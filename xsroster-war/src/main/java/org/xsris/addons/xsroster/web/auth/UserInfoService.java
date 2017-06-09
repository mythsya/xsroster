package org.xsris.addons.xsroster.web.auth;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

public class UserInfoService extends JdbcUserDetailsManager implements UserDetailsService {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected final MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
	private String usersByUsernameQuery;
	private String authoritiesByUsernameQuery;

	public UserInfoService() {
	}

	public UserInfoService dataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
		return this;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		List<UserDetails> users = loadUsersByUsername(username);
		if (users.size() == 0) {
			throw new UsernameNotFoundException(
					messages.getMessage("JdbcDaoImpl.notFound", new Object[] { username }, "Username {0} not found"));
		}
		UserInfo user = (UserInfo) users.get(0);
		Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();
		if (getEnableAuthorities()) {
			dbAuthsSet.addAll(loadUserAuthorities(user.getId()));
		}
		if (getEnableGroups()) {
			dbAuthsSet.addAll(loadGroupAuthorities(user.getUsername()));
		}
		List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>(dbAuthsSet);
		addCustomAuthorities(user.getUsername(), dbAuths);
		if (dbAuths.size() == 0) {
			if (logger.isDebugEnabled()) {
				logger.debug("User '" + username + "' has no authorities and will be treated as 'not found'");
			}

			throw new UsernameNotFoundException(messages.getMessage("JdbcDaoImpl.noAuthority",
					new Object[] { username }, "User {0} has no GrantedAuthority"));
		}
		return createUserDetails(username, user, dbAuths);
	}

	public UserInfoService setAuthoritiesUsernameQuery(String authoritiesByUsernameQuery) {
		this.authoritiesByUsernameQuery = authoritiesByUsernameQuery;
		return this;
	}

	public UserInfoService setUsersUsernameQuery(String usersByUsernameQuery) {
		this.usersByUsernameQuery = usersByUsernameQuery;
		return this;
	}

	protected UserDetails createUserDetails(String username, UserInfo userFromUserQuery,
			List<GrantedAuthority> combinedAuthorities) {
		String returnUsername = userFromUserQuery.getUsername();
		if (!isUsernameBasedPrimaryKey()) {
			returnUsername = username;
		}
		UserInfo user = new UserInfo(returnUsername, userFromUserQuery.getPassword(), userFromUserQuery.isEnabled(),
				true, true, true, combinedAuthorities);

		user.setId(userFromUserQuery.getId());
		user.setName(userFromUserQuery.getName());
		user.setLoginTime(userFromUserQuery.getLoginTime());
		user.setLoginIP(userFromUserQuery.getLoginIP());
		user.setSalt(userFromUserQuery.getSalt());
		return user;
	}

	/**
	 * Loads authorities by executing the SQL from <tt>groupAuthoritiesByUsernameQuery</tt>.
	 *
	 * @return a list of GrantedAuthority objects for the user
	 */
	@Override
	protected List<GrantedAuthority> loadUserAuthorities(String userId) {
		try {
			return getJdbcTemplate().query(this.authoritiesByUsernameQuery, new Object[] { userId },
					new RowMapper<GrantedAuthority>() {

						@Override
						public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
							String roleName = getRolePrefix() + rs.getString(2);
							return new SimpleGrantedAuthority(roleName);
						}

					});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Loads authorities by executing the SQL from <tt>authoritiesByUsernameQuery</tt>.
	 *
	 * @return a list of GrantedAuthority objects for the user
	 */
	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {
		try {
			return getJdbcTemplate().query(this.usersByUsernameQuery, new Object[] { username },
					new RowMapper<UserDetails>() {

						@Override
						public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
							String username1 = rs.getString(1);
							String password = rs.getString(2);
							boolean enabled = rs.getBoolean(3);
							UserInfo user = new UserInfo(username1, password, enabled, true, true, true,
									AuthorityUtils.NO_AUTHORITIES);
							user.setId(rs.getString(4));
							user.setName(rs.getString(5));
							user.setSalt(rs.getString(6));

							return user;
						}

					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
