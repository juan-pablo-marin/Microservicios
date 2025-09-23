package com.aplication.rest.SpringBootRest.controllers;

import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;

import com.aplication.rest.SpringBootRest.service.IMakerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/maker")
@AllArgsConstructor
public class MakerController {

    @Autowired
    private IMakerService makerService;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete ( @PathVariable Long id){
        if(id==null){
        return ResponseEntity.badRequest().build();
        }
        makerService.deleteById(id);
        return ResponseEntity.ok("Regsitro Eliminado");
    }

    @GetMapping("/getAll")
    public ResponseEntity <?> getAll (){
       List<MakerDTO> list =  makerService.getAll();
       return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id ){
     MakerDTO makerDTO= makerService.getById(id);
     return ResponseEntity.ok(makerDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMaker (@Valid @PathVariable Long id, @RequestBody MakerDTO makerDTO){
            MakerDTO update =makerService.saveMaker(makerDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(update);
    }

    @PostMapping ("/save")
    public ResponseEntity<?> save (@Valid @RequestBody MakerDTO makerDTO) throws URISyntaxException {
        MakerDTO create=makerService.saveMaker(makerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }
}
