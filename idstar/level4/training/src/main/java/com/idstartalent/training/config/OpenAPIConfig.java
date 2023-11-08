package com.idstartalent.training.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

        @Bean
        public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("training idstart")
                        .version("v1")
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Confluence - Service Documentation")
                        .url(""));
    }
    }
