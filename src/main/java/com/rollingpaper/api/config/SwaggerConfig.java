package com.rollingpaper.api.config;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    private static final String GROUP_NAME = "GROUP1";
    private static final String BASE_PACKAGES = "com.rollingpaper.api.controller";
    private static final String V3_ANT_PATH = "/api/v3/**";
    private static final String TITLE = "롤링페이퍼 V3";
    private static final String DESCRIPTION = "this is for rollingpaper service";
    private static final String VERSION = "version 3.0";
    private static final String SERVICE_URL = "https://rollingpaper.site";
    private static final String EMAIL = "donghoon149@gmail.com";

    @Bean
    public Docket apiV1() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName(GROUP_NAME)
            .select()
            .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGES))
            .paths(PathSelectors.ant(V3_ANT_PATH))
            .build()
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            TITLE,
            DESCRIPTION,
            VERSION,
            SERVICE_URL,
            new Contact("Contact Me", SERVICE_URL, EMAIL),
            null,
            SERVICE_URL,
            new ArrayList<>());
    }
}
