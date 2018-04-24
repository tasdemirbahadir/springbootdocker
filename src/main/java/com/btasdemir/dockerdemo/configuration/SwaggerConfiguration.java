package com.btasdemir.dockerdemo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Value("${swagger.host.url}")
    private String host;
    @Value("${swagger.host.path}")
    private String path;
    @Value("${spring.application.name:Api Documentation}")
    private String appName;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).host(host).pathMapping(path)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.btasdemir.dockerdemo.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Arrays.asList(apiKey()))
                .securityContexts(Arrays.asList(securityContext()))
                .apiInfo(apiInfo())
                .protocols(new HashSet<>(Arrays.asList("http", "https")));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                appName,
                "Docker Demo",
                "v1",
                "",
                new Contact("btasdemir", "https://www.btasdemir.com", "bahadir.tasdemir@hotmail.com.tr"),
                ".",
                ".",
                Collections.singletonList(new StringVendorExtension(".", "."))
        );
    }

    private ApiKey apiKey() {
        return new ApiKey(HttpHeaders.AUTHORIZATION, "Bearer apikey", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/anyPath.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(
                new SecurityReference(HttpHeaders.AUTHORIZATION, authorizationScopes));
    }

}
