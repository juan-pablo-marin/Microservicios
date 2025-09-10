package com.aplication.rest.SpringBootRest.service;

import com.aplication.rest.SpringBootRest.controllers.dto.MakerDTO;
import com.aplication.rest.SpringBootRest.controllers.dto.ProductDTO;
import com.aplication.rest.SpringBootRest.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    Optional<Product> findById(Long id);
    List<Product> findAll();
    void save(Product product);
    ProductDTO create(ProductDTO productDTO);
    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxDecimal );
    ProductDTO getById(Long id);
    List<ProductDTO> getAll();
    void deleteById(Long id);
    void otraFuncion ();
    //ProductDTO updatem (ProductDTO product);

}
