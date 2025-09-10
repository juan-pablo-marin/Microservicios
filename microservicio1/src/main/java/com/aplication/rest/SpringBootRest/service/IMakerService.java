package com.aplication.rest.SpringBootRest.service;

import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerService {

    /**
     *nos traemos los mismos metodos del DAO en este caso IMakerDAO
     */


    List<Maker> findAll ();

    Optional<Maker> findById (Long id);

    void save(Maker maker);

    void deleteById(Long id);

    List<MakerDTO> getAll();

    MakerDTO getById(Long id);

    MakerDTO saveMaker (MakerDTO makerDTO);
}
