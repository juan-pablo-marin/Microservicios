package com.microservicios.micro_getway_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    private static final String [] FREE_RESOURCES_URLS = {
         "/swagger-ui.html","swagger-iu/**","/v3/api-docs/**",
         "/swagger-resources/**", "/api-docs/**", "/webjars/**"
    };

    @Bean
    public SecurityWebFilterChain securityWebFilterChain (ServerHttpSecurity httpSecurity){
        return httpSecurity
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/swagger-ui.index.html","/swagger-ui.html", "/swagger-ui/**",
                                "/swagger-resources/**", "/api-docs/**", "favicon.ico",
                                "/v3/api-docs/**", "/webjars/**").permitAll()
                        .anyExchange().authenticated()
                )
                .oauth2ResourceServer(server ->server.jwt(jwt ->{}))
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .build();
    }


}
