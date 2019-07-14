package com.eksad.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

@EnableSwagger2
@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
	
	@Bean
	public Docket eksadAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.eksad.rest"))
				.paths(regex("/api.*"))
				.build()
				.apiInfo(metaInfo())
				.tags(
						new Tag("Brand", "Brand Management API"),
						new Tag("Product", "Product Management API"),
						new Tag("Data Manipulation API", "Delete, Update, and Save Data Brand & Product"),
						new Tag("Get Data API", "Brand & Product")
						);
	}
	
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Product Data Management REST API", 
				"Rest API Collection for Product Data Management", 
				"1.0.0", 
				"http://google.com", 
				new Contact("Afra Tiara Rahmayani", "afratiararahmayani", "rahmayanitiaraafra@gmail.com"), 
				"Afra 2.0", 
				"http://www.google.com/license",
				Collections.emptyList());
		return apiInfo;
	}

}
