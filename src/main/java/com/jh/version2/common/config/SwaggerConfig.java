package com.jh.version2.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * The type Swagger config.
 *
 * @author [오지훈]
 * @implNote Swagger2 Configure 작성
 * @since 2020. 10. 29. 오전 11:25:15
 */
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig implements WebMvcConfigurer {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/api/v1/**"))
				.build()
				/*.globalOperationParameters(Arrays.asList(
						new ParameterBuilder()
								.name("Authorization")
								.description("인증키")
								.modelRef(new ModelRef("string")).parameterType("header").required(true).modelRef(new ModelRef("String")).build()))*/
				.apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("이 문서는 오지훈님의 Project API 문서 입니다.")
				.description("Created by Jihoon.Oh").license("Apache License Version 2.0")
				.licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE").version("1.0").build();
	}

}
