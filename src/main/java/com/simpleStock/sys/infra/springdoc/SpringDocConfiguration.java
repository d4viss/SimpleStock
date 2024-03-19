package com.simpleStock.sys.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("SimpleStock")
                        .description("API Rest de la aplicación SimpleStock, tiene las funcionalidades de administrar " +
                                "el inventario de pequeñas compañias")
                        .contact(new Contact()
                                .name("Davison Castelblanco")
                                .email("davisonju26@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://simplestock/api/licencia")));
    }
}
