package ayshirv.com.aivocation.config.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.Collections;

/**
 * OpenAPI configuration for springdoc-openapi.
 * Generates Swagger UI at /swagger-ui.html and OpenAPI JSON at /v3/api-docs.
 * The server URL is set to the same base path (/api) used by WebConfig.
 */
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("aivocation API")
                        .description("Generated API documentation for aivocation API.")
                        .version("v1"))
                .servers(Collections.singletonList(new Server().url("/api")));
    }
}
