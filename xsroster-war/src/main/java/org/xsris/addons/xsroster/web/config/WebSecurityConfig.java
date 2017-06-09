package org.xsris.addons.xsroster.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.xsris.addons.xsroster.web.auth.UserInfoService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("externalAuthDataSource")
	private DataSource externalAuthDataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		// builder.inMemoryAuthentication().withUser("ris").password("agfa123").roles("USER");
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		ReflectionSaltSource saltSource = new ReflectionSaltSource();
		saltSource.setUserPropertyToUse("salt");
		authProvider.setSaltSource(saltSource);
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(new Md5PasswordEncoder());
		builder.authenticationProvider(authProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/scripts/**", "/fonts/**", "/**/viewer.html**",
				"/**/login.html**").permitAll().antMatchers("/**/*.html**").hasRole("USER").and().formLogin().loginPage(
						"/login").usernameParameter("username").passwordParameter(
								"password").and().httpBasic().and().csrf().disable();
	}

	@Override
	protected UserInfoService userDetailsService() {
		return new UserInfoService().setUsersUsernameQuery(
				"select username,password,enabled,id,rolename,id from auth_user where username=?").setAuthoritiesUsernameQuery(
						"select distinct t.user_id, decode(authority,'AUTH_ROSTER','ROLE_ADMIN','ROLE_USER') from auth_user_group t, auth_group g, auth_group_authority ga where t.group_id = g.id and g.id = ga.auth_group_id and t.user_id=?").dataSource(
								externalAuthDataSource);
	}
}
