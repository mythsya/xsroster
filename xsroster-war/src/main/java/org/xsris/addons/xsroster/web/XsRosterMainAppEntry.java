package org.xsris.addons.xsroster.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "org.xsris.addons.xsroster.entity")
@ComponentScan(basePackages = "org.xsris.addons.xsroster")
@EnableJpaRepositories(basePackages = "org.xsris.addons.xsroster")
public class XsRosterMainAppEntry extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(XsRosterMainAppEntry.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(XsRosterMainAppEntry.class);
	}
}
