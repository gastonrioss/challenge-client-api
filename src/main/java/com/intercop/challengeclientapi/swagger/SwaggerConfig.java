package com.intercop.challengeclientapi.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Configuration
public class SwaggerConfig {
        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.intercop.challengeclientapi.controller"))
                    .paths(PathSelectors.any())
                    .build()
                    .useDefaultResponseMessages(false)
                    .apiInfo(apiInfo())
                    .produces(new HashSet<>(Arrays.asList("application/json")))
                    .consumes(new HashSet<>(Arrays.asList("application/json")));

        }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Challenge Client Api",
                "Api desarrollada para el challenge de Intercorp.",
                "1.0.0",
                "",
                new Contact("Gaston Emilio Rios", "https://github.com/gastonrioss/challenge-client-api", "gastonerios2002@gmail.com"),
                "Linkedin", "https://www.linkedin.com/in/gaston-rios-956319b7/", Collections.emptyList());
    }
    }
