package com.micro.security_service.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "micro-security")
public class MicroservicesProperties {

    List<Application> applications;

    @Data
    public static class Application{

        private String clientId;
        private String clientSecret;
    }
}
