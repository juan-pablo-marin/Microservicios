package com.aplication.rest.SpringBootRest.service.impl;

import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.Maker;
import com.aplication.rest.SpringBootRest.mappers.MakerMapper;
import com.aplication.rest.SpringBootRest.persistence.IMakerDAO;
import com.aplication.rest.SpringBootRest.service.IMakerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MakerServiceImpl implements IMakerService {

    @Autowired
    private final MakerMapper makerMapper;

    @Autowired
    private IMakerDAO makerDAO;

    @Override
    public List<Maker> findAll() {
        return makerDAO.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerDAO.findById(id);
    }

    @Override
    public MakerDTO save(MakerDTO makerDTO) {
        Maker entity = makerMapper.toMaker(makerDTO);
        Maker saved = makerDAO.save(entity);
        return makerMapper.toMakerDto(saved);
    }

    @Override
    public void deleteById(Long id) {
        makerDAO.deleteById(id);
    }

    public List<MakerDTO> getAll(){
        List<Maker> entity = makerDAO.findAll();
        return makerMapper.toDtos(entity);
    }

    @Override
    public MakerDTO getById(Long id){
        return makerDAO.findById(id)
                .map(makerMapper::toMakerDto)
                .orElse(null);
    }

    @Override
    public MakerDTO saveMaker(MakerDTO makerDTO){
        Maker entity = makerMapper.toMaker(makerDTO);
        Maker saved = makerDAO.save(entity);
        return makerMapper.toMakerDto(saved);
    }



}
