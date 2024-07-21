package com.infosys.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		 return new Docket(DocumentationType.SWAGGER_2).select()                               
		          .apis(RequestHandlerSelectors.basePackage("com.infosys"))  
		          .build()
		          .apiInfo(apiInfo()); 
				
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()

		  .title("InfyRail Project API Documentation")
          .description("The identity API provides standardized mechanism for identity management such as creation, update, retrieval, deletion. ")
          .license("Recent Licence Renewed")
          .licenseUrl("https:mindsconnect.omfysgroup.com")
          .termsOfServiceUrl("")
          .version("1.0.0")
          .contact(new Contact("Amit Kumar(Infosys)", "www.infosys.com", "amit.kumar441@infosys.com"))
          .build();
	}
}
