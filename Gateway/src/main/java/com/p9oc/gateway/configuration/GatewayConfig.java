package com.p9oc.gateway.configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration du routage Spring Cloud Gateway.
 * <p>
 * Définit les règles de routage entre les endpoints exposés par le Gateway
 * et les microservices internes.
 * </p>
 */
@Configuration
public class GatewayConfig {

    /**
     * Déclare les routes du Gateway.
     *
     * @param builder constructeur de routes
     * @return RouteLocator configuré
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("patient-service", r -> r
                        .path("/api/patient/**")
                        .uri("http://patientms:8082")
                )
                .route("note-service", r -> r
                        .path("/api/notes/**")
                        .uri("http://notems:8083")
                )
                .route("risk-service", r -> r
                        .path("/api/risk/**")
                        .uri("http://riskms:8084")
                )
                .build();
    }
}

