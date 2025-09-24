package com.microservicios.micro_security_service;

import com.microservicios.micro_security_service.util.MicroservicesProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//@EnableConfigurationProperties(MicroservicesProperties.class)
@SpringBootApplication
public class MicroSecurityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroSecurityServiceApplication.class, args);
	}

}
