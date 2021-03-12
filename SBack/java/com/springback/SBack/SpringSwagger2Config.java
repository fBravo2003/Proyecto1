package com.springback.SBack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan(basePackages = {"com.springback.SBack.controller"})
@EnableSwagger2
public class SpringSwagger2Config {
	
	@Bean
    public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)  
        .select()                                  
        .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework")))             
        .build()
        .useDefaultResponseMessages(false)
        .apiInfo(infoApi());                                           
    }
	
	private ApiInfo infoApi() {
        return new ApiInfoBuilder()
        .title("Prueba Spring")
        .version("1.0")
        .description("Prueba de Spring")
        .build();
    }
	
}
