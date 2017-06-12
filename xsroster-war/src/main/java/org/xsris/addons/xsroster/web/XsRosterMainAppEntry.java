package org.xsris.addons.xsroster.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.aspose.cells.License;

@SpringBootApplication
@EntityScan(basePackages = "org.xsris.addons.xsroster.entity")
@ComponentScan(basePackages = "org.xsris.addons.xsroster")
@EnableJpaRepositories(basePackages = "org.xsris.addons.xsroster")
public class XsRosterMainAppEntry extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		XsRosterMainAppEntry.validateLicense();
		SpringApplication.run(XsRosterMainAppEntry.class, args);
	}

	private static void validateLicense() {
		try {
			License lic = new License();
			Resource licenseXml = new ClassPathResource("license.xml");
			lic.setLicense(licenseXml.getInputStream());

			if (License.isLicenseSet()) {
				System.out.println("License is valid !");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		XsRosterMainAppEntry.validateLicense();
		return application.sources(XsRosterMainAppEntry.class);
	}
}
