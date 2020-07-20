package ar.com.spring.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
@Configuration
public class OpenApiConfig {
 
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                		.title("PRODUCT API SERVICE")
                		.description("This is an example of the Netflix suit, this is the Item API.")
                		.version("1.0.0")
                		.termsOfService("Esta API es publica"))
                ;
    }
}