package com.aplication.rest.SpringBootRest.feign;

import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.Maker;
import org.springframework.stereotype.Component;

@Component
public class MakerApiMapper {
        public static Maker toEntity(MakerDTO dto) {
            Maker maker = new Maker();
            maker.setName(dto.getName());
            return maker;
        }
    }


