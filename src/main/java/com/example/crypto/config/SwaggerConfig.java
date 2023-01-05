package com.example.crypto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    public static final String USER_TAG = "user service";
    public static final String NOTE_TAG = "note service";
    public static final String USER_NOTE_TAG = "userNote service";
    public static final String NOTE_PREVIEW_TAG = "notePreview service";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .tags(
                    new Tag(USER_TAG, "the user API with description api tag"),
                    new Tag(NOTE_TAG, "the userNote API with description api tag"),
                    new Tag(USER_NOTE_TAG, "the userNote API with description api tag")
                );
    }
}