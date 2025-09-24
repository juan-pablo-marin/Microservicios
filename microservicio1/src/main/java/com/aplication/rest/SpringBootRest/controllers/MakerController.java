package com.aplication.rest.SpringBootRest.controllers;

import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.service.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/maker")
public class MakerController {

    @Autowired
    private IMakerService makerService;

    @GetMapping("/getAll")
    public ResponseEntity <?> getAll (){
       List<MakerDTO> list =  makerService.getAll();
       return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MakerDTO> getById(@PathVariable Long id ) throws Exception {
        if (makerService.findById(id).isPresent()) {
            MakerDTO makerDTO = makerService.getById(id);
            return ResponseEntity.ok(makerDTO);
        }
        return ResponseEntity.badRequest().build();
    }
}
