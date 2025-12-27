package com.p9oc.gateway.configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()

                .route("patient-service", r -> r
                        .path("/api/patient/**")
                        .uri("http://patient_ms:8082")
                )
                .route("note-service", r -> r
                        .path("/api/notes/**")
                        .uri("http://note_ms:8083")
                )

                .route("risk-service", r -> r
                        .path("/api/risk/**")
                        .uri("http://risk_ms:8084")
                )
                .build();
    }
}
