package com.microservicios.micro_getway_service.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Configuration
public class GatewayConfig {

    @Value("${microservices.microservice1-url}")
    private String microservicio1;
    @Value("${microservices.microservice2-url}")
    private String microservicio2;

    @Value("${gateway.retry.attempts}")
    private int retryAttempts;

    private Set<String> getAllStatusCodes(){
        return IntStream.rangeClosed(500,599)
                .mapToObj(String::valueOf)
                .collect(Collectors.toSet());
    }

    @Bean
    public RouteLocator microserviceRouteLocator (RouteLocatorBuilder builder){
        Set<String> statusCode5xx= getAllStatusCodes();
        return builder.routes()
                .route("microservice", r->r.path("/api/maker/**")
                        .filters(f->f
                                .circuitBreaker(cb -> cb.setName("makerServiceCircuitBreaker")
                                        .setFallbackUri("forward:/fallback/api/maker"))
                                .retry(retryConfig -> retryConfig.setRetries(retryAttempts)
                                        .setStatuses(HttpStatus.INTERNAL_SERVER_ERROR))
                        )
                        .uri(microservicio1))
                .route("microservice2",
                        r->r.path("/micro/**")
                                .filters(f->f
                                        .circuitBreaker(cb -> cb.setName("microService2CircuitBreaker")
                                                .setFallbackUri("forward:/fallback/micro"))
                                        .retry(retryConfig -> retryConfig.setRetries(retryAttempts)
                                                .setStatuses(HttpStatus.INTERNAL_SERVER_ERROR))
                                )
                                .uri(microservicio2))
                .route("swagger-microservice",
                        r->r.path("/v3/api-docs/api/maker")
                                .filters(f-> f
                                        .rewritePath("/v3/api-docs/api/maker","/v3/api-docs")
                                )
                                .uri(microservicio1))
                .route("swagger-microservice2",
                        r->r.path("/v3/api-docs/micro")
                                .filters(f-> f
                                        .rewritePath("/v3/api-docs/micro","/v3/api-docs")
                                )
                                .uri(microservicio2))
                .build();
}




}
