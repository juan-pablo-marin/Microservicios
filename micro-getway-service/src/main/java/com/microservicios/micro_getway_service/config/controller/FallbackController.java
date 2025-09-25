package com.microservicios.micro_getway_service.config.controller;


import jdk.jfr.Frequency;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @RequestMapping("/api/maker")
    public ResponseEntity<Map<String, String>> makerFallback(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE )
                .body(Collections.singletonMap("message","Maker Service is unavailable. Please try again later"));
    }

    @RequestMapping("/micro")
    public ResponseEntity<Map<String, String>> microFallback(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE )
                .body(Collections.singletonMap("message","Micro Service is unavailable. Please try again later"));
    }


}
