package com.aplication.rest.SpringBootRest.feign;
import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.Maker;
import com.aplication.rest.SpringBootRest.persistence.IMakerDAO;
import com.aplication.rest.SpringBootRest.wrapper.ApiResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonConsumeService {

    @Autowired
    private final PersonListClient feignClient;

    @Autowired
    private final MakerApiMapper makerApiMapper;

    @Autowired
    private IMakerDAO makerDAO;

    public  List<MakerDTO> fetchAllPersons() {
        ApiResponse<List<MakerDTO>> response = feignClient.getAllPersons();
        return response.getData();
    }

    public  MakerDTO savePerson(MakerDTO makerDTO){
        ApiResponse<MakerDTO> response = feignClient.save(makerDTO);
        return response.getData();
    }

    public  MakerDTO getByid(long id) {
        ApiResponse<MakerDTO> response =  feignClient.getById(id);
        return response.getData();
     }

    @Transactional
    public Maker saveMakerFromApi(Long id) {
        // 1. Consumir el endpoint externo
        ApiResponse<MakerDTO> dto = feignClient.getById(id);

        // 2. Convertir a entidad
        Maker entity = makerApiMapper.toEtnity(dto);

        // 3. Guardar en BD
        return makerDAO.save(entity);
    }

}