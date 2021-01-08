package com.example.demo.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// http://127.0.0.1:8080/demo/swagger-ui.html

	@Bean
	public Docket docket(Environment environment) {
		
		// 如果是开发环境就启用swagger
		boolean flag = environment.acceptsProfiles(Profiles.of("dev"));
		
		Contact contact = new Contact("lu_weicong", "https://github.com/weiconglu", "lu_weicong@purvar.co.jp");
		ApiInfo apiInfo = new ApiInfo("Title: springboot demo 的文档", "Description: springboot demo 的文档", "v1.0",
				"termsOfServiceUrl", contact, "APACHE LICENSE, VERSION 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo)
				.enable(flag) // <------------是否启用swagger
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
				.build();
	}

}
