package ua.com.yummzy.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@SecurityScheme(name = "bearer", type = SecuritySchemeType.HTTP, scheme = "bearer", in = SecuritySchemeIn.HEADER)
public class SwaggerConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        var localhost = new Server();
        localhost.setUrl("http://localhost:8080");

        var staging = new Server();
        staging.setUrl("https://backend.yummzy.pythontop.xyz");

        return new OpenAPI()
                .info(new Info()
                        .title("Yummzy API")
                        .description("REST API for Yummzy")
                        .version("v1")
                )
                .servers(List.of(localhost, staging));
    }
}
