package com.microservicios.micro_getway_service.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GatewayConfig {

    @Value("${microservices.microservice1-url}")
    private String microservicio1;
    @Value("${microservices.microservice2-url}")
    private String microservicio2;

    @Bean
    public RouteLocator microserviceRouteLocator (RouteLocatorBuilder builder){
        return builder.routes()
            .route("microservice",
                    r->r.path("/api/maker/**")
                            .uri(microservicio1))

            .route("microservice2",
                    r->r.path("/micro/**")
                            .uri(microservicio2))
                .build();
}




}
