package com.aplication.rest.SpringBootRest.controllers.dto;

import com.aplication.rest.SpringBootRest.entities.Product;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {

    /**
     * Se agregan los mismos atributos de la clase sin las anotaciones
     */

    private Long id;
    @NotNull(message = "El campo 'nombre' es obligatorio")
    private String name;
    private List<Product> productList=new ArrayList<>();

}
