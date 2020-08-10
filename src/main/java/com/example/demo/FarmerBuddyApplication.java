package com.example.demo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SpringBootApplication
public class FarmerBuddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmerBuddyApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("");
			}
		};
	}

	@Bean
	public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)  
				.select()                                  
				.apis(RequestHandlerSelectors.any())              
				.paths(PathSelectors.any())                          
				.build()
				.apiInfo(metaData());
	}
	
	 private ApiInfo metaData() {
	        return new ApiInfoBuilder()
	                .title("Farmer-Buddy Project")
	                .description("\"Farmer-Buddy app of Spring Boot REST flavoured with Hibernate<-->MySql 8.x\"")
	                .version("1.0.0")
	                .license("Gauri GitHub URL")
	                .licenseUrl("https://github.com/gauri-deshmukh")
	                .contact(new Contact("Prajakta Github URL", "https://github.com/Praja2601/farmer_buddy_project", "farmer.buddyhelp@gmail.com"))
	                .build();
	    }
}
