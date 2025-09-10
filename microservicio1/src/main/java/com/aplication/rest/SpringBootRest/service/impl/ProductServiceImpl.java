package com.aplication.rest.SpringBootRest.service.impl;

import com.aplication.rest.SpringBootRest.controllers.dto.ProductDTO;
import com.aplication.rest.SpringBootRest.entities.Product;
import com.aplication.rest.SpringBootRest.mappers.ProductMapper;
import com.aplication.rest.SpringBootRest.persistence.impl.ProductDAOImpl;
import com.aplication.rest.SpringBootRest.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Autowired
    private ProductDAOImpl productDAO;

    @Override
    public Optional<Product> findById(Long id) {
        return productDAO.findById(id) ;
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxDecimal) {
        return productDAO.findByPriceInRange(minPrice, maxDecimal);
    }

    @Override
    public ProductDTO getById(Long id) {
        return productDAO.findById(id)
                .map(productMapper::toProductDto)
                .orElse(null);
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> productList = productDAO.findAll();
        return productMapper.toDtos(productList);
    }

    @Override
    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }

    @Override
    public ProductDTO create(ProductDTO dto) {
        Product entity = productMapper.toProduct(dto);
        Product saved = productDAO.save(entity);
        return productMapper.toProductDto(saved);
    }

    public void otraFuncion (){
        System.out.println("Esto viene del servicio");
    }

  /* public ProductDTO updatem (ProductDTO productDTO){
         Product entity = productMapper.toProduct(productDTO);
         Product saved = productDAO.save(entity);
         return productMapper.toProductDto(saved);

   }*/
}
