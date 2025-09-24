package com.aplication.rest.SpringBootRest.feign;

import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.Maker;
import com.aplication.rest.SpringBootRest.wrapper.ApiResponse;
import org.springframework.stereotype.Component;

@Component
public class MakerApiMapper {
    public Maker toEtnity (ApiResponse<MakerDTO> dto) {
        Maker maker = new Maker();
        maker.setName(dto.getData().getName());
        return maker;
    }
}


