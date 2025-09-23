package com.aplication.rest.SpringBootRest.feign;

import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.Maker;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/micro")
@AllArgsConstructor
public class PersonController {

    @Autowired
    private final PersonConsumeService service;

    @GetMapping("/getAll")
    public List<MakerDTO> getPersons() {
        return service.fetchAllPersons();
    }

    @PostMapping("/save")
    public MakerDTO saveP(@RequestBody MakerDTO makerDTO) {
        return service.savePerson(makerDTO);
    }

    @GetMapping("/get/{id}")
    public MakerDTO getById(@PathVariable long id) {
        return service.getByid(id);
    }

    @PostMapping("/savetoapi/{id}")
    public Maker saveMakerFromApi(@PathVariable Long id) {
        return service.saveMakerFromApi(id);
    }
}