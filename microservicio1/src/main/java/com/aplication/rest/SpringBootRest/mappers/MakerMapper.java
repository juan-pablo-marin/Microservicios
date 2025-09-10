package com.aplication.rest.SpringBootRest.mappers;


import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.entities.Maker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MakerMapper {
    MakerMapper makerMapper = Mappers.getMapper(MakerMapper.class);

   // @Mapping(target = "names", source = "name")
    MakerDTO toMakerDto(Maker maker);

    Maker toMaker(MakerDTO dto);
    List<MakerDTO> toDtos(List<Maker> makers);
}
