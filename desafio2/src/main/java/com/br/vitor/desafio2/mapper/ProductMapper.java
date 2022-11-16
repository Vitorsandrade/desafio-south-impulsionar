package com.br.vitor.desafio2.mapper;

import com.br.vitor.desafio2.dto.ProductDTO;
import com.br.vitor.desafio2.entity.Product;

public class ProductMapper {

    public Product productToProductEntity(Product entity, Product product) {
        entity.setAmount(product.getAmount());
        entity.setCategory(product.getCategory());
        entity.setColor(product.getColor());
        entity.setDescription(product.getDescription());
        entity.setName(product.getName());
        entity.setMaterial(product.getMaterial());
        entity.setPrice(product.getPrice());
        entity.setCode(product.getCode());
        entity.setBarCode(product.getBarCode());
        entity.setExpirationDate(product.getExpirationDate());
        entity.setManufacturingDate(product.getManufacturingDate());
        entity.setSeries(product.getSeries());

        return entity;
    }

    public ProductDTO productToProductDTO(Product productEntity, ProductDTO productDTO) {
        productDTO.setAmount(productEntity.getAmount());
        productDTO.setCategory(productEntity.getCategory());
        productDTO.setColor(productEntity.getColor());
        productDTO.setDescription(productEntity.getDescription());
        productDTO.setName(productEntity.getName());
        productDTO.setMaterial(productEntity.getMaterial());
        productDTO.setPrice(productEntity.getPrice());
        productDTO.setCode(productEntity.getCode());
        productDTO.setBarCode(productEntity.getBarCode());
        productDTO.setExpirationDate(productEntity.getExpirationDate());
        productDTO.setManufacturingDate(productEntity.getManufacturingDate());
        productDTO.setSeries(productEntity.getSeries());

        return productDTO;
    }
}
