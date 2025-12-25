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
                .route(r -> r.path("/api/patient/**")
                        .uri("http://localhost:8082"))  // Use patients microservice
                .route(r -> r.path("/api/notes/**")
                        .uri("http://localhost:8083")) // use Note microservice
                .build();
    }
}
