package org.xsris.addons.xsroster.web.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.xsris.addons.xsroster.jdbc.RosterPooledDataSource;

@Configuration
public class DataSourceConfig {

	@Bean("externalAuthDataSource")
	@ConfigurationProperties(prefix = "spring.datasource4auth")
	public DataSource externalAuthDataSource() {
		return DataSourceBuilder.create().type(RosterPooledDataSource.class).build();
	}

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().type(RosterPooledDataSource.class).build();
	}
}
