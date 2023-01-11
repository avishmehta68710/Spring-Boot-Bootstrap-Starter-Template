package com.applications.user.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Application API", version = "1.0", description = "API Collection")
)
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:81");
        List<Server> servers = new ArrayList<>();
        servers.add(server);
        return new OpenAPI().servers(servers);
    }
}
