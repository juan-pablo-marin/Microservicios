package com.aplication.rest.SpringBootRest.feign;

import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "microservicio1", url = "${microservicio1.url}")
public interface PersonListClient {
    @GetMapping("/api/maker/getAll")
    List<MakerDTO> getAllPersons();
}
