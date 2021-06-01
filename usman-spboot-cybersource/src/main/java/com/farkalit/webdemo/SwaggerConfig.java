/**
 * 
 */
package com.farkalit.webdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
public class SwaggerConfig implements WebMvcConfigurer {


	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.farkalit.webdemo.web.controller"))
				.paths(PathSelectors.any()).build().apiInfo(getApiInformation());
	}

	private ApiInfo getApiInformation() {
		VendorName vendors = new VendorName("MAFC");
		@SuppressWarnings("rawtypes")
		List<VendorExtension> vendorExtensions = new ArrayList<>();
		vendorExtensions.add(vendors);
		Contact contact = new Contact("Developer", "https://bitbucket.org/", "fausman@mafcarrefour.com");
		return new ApiInfo("Usman API Documentation", "Usman API Documentation", "1.0", "https://www.majidalfuttaim.com/en",
				contact, "Majid Al Futtaim Carrefour", "https://www.majidalfuttaim.com/en", vendorExtensions);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	class VendorName implements VendorExtension<Object>{

		private String name;
		
		public VendorName(String name) {
			this.name=name;
		}
		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public Object getValue() {
			return "MAF";
		}

	}
}
