/**
 * 
 */
package com.farkalit.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author farkalitusman
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.maf.paymentservice.epaisa.web.controller"))
				.paths(PathSelectors.any()).build().apiInfo(getApiInformation());
	}

	private ApiInfo getApiInformation() {
		VendorName vendors = new VendorName("MAFC");
		@SuppressWarnings("rawtypes")
		List<VendorExtension> vendorExtensions = new ArrayList<>();
		vendorExtensions.add(vendors);
		Contact contact = new Contact("Developer", "https://localhost:8080", "fausman@mafcarrefour.com");
		return new ApiInfo("MAFC Management API Documentation", "MAFC API Documentation", "1.0", "https://github.com/",
				contact, "Usman API 2.0", "https://localhost:8080/v2/api-docs", vendorExtensions);
	}

	class VendorName implements VendorExtension<Object> {

		private String name;

		public VendorName(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public Object getValue() {
			return "Contractors";
		}

	}
}
