package ua.com.yummzy.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Yummzy API", description = "REST API for Yummzy", version = "v1"),
        servers = @Server(url = "http://localhost:8080"))
public class SwaggerConfiguration {
}
