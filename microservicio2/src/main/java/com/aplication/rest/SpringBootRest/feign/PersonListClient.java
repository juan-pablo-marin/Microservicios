package com.aplication.rest.SpringBootRest.feign;

import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.wrapper.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "microservicio1", url = "${microservicio1.url}")
public interface PersonListClient {

    @GetMapping("/api/maker/getAll")
    ApiResponse<List<MakerDTO>> getAllPersons();

    @GetMapping("/api/maker/get/{id}")
    ApiResponse<MakerDTO> getById (@PathVariable Long id);

    @PostMapping("/api/maker/save")
    ApiResponse<MakerDTO> save (@RequestBody MakerDTO makerDTO);

}
