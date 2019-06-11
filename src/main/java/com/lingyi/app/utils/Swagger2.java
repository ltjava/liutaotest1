package com.lingyi.app.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2//启用swaggerAPI
public class Swagger2 {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.lingyi.app.controller"))
				.paths(PathSelectors.any())
				.build();
				
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("spring boot中使用swagger2构建RESTful APIs")
				.description("更多请关注http://www.baidu.com")
				.termsOfServiceUrl("http://www.baidu.com")
				.contact("sunf")
				.version("1.0")
				.build();
	}
	
}
