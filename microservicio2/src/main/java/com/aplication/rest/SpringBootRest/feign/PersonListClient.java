package com.aplication.rest.SpringBootRest.feign;

import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.wrapper.ApiResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "microservicio1", url = "${microservicio1.url}")
public interface PersonListClient {

    Logger logger = LoggerFactory.getLogger(PersonListClient.class);

    @GetMapping("/api/maker/getAll")
    @CircuitBreaker(name="microservicio1", fallbackMethod = "fallbackGetAll")
    ApiResponse<List<MakerDTO>> getAllPersons();

    @GetMapping("/api/maker/get/{id}")
    @CircuitBreaker(name="microservicio1", fallbackMethod = "fallbackGet")
    ApiResponse<MakerDTO> getById (@PathVariable Long id);

    @PostMapping("/api/maker/save")
    ApiResponse<MakerDTO> save (@RequestBody MakerDTO makerDTO);

    default   ApiResponse<MakerDTO> fallbackGet(Long id, Throwable throwable ){
        logger.warn("fallo con el Get/id");
        ApiResponse<MakerDTO> response = new ApiResponse<>();
        response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase());
        return response;
    }

    default ApiResponse<List<MakerDTO>> fallbackGetAll(Throwable throwable ){
        logger.warn("fallo con el GetAll");
        ApiResponse<List<MakerDTO>> response = new ApiResponse<>();
        response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase());
        return response;
    }


}
