package com.example.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes()
                .route("companyms",r->r.path("/api/company/**")
                        .uri("lb://companyms"))
                .route("jobms",r->r.path("/api/job/**")
                        .uri("lb://jobms"))
                .route("reviewms",r->r.path("/reviews/**")
                        .uri("lb://reviewms"))
                .build();

    }
}
