package com.aplication.rest.SpringBootRest.service.impl;

import com.aplication.rest.SpringBootRest.PersonListClient;
import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonConsumeService {

    private final PersonListClient feignClient;

    public List<MakerDTO> fetchAllPersons() {
        return feignClient.getAllPersons();
    }
}