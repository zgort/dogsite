package com.rum.cms.webapp.engine;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Hikmat
 *
 */
@SpringBootApplication
@ComponentScan("com.rum.*")
@EnableJpaRepositories("com.rum.*")
@EntityScan("com.rum.*")
@EnableJSONDoc
public class Starter extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Starter.class);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}
}
