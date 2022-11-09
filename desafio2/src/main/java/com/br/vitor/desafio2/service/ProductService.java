package com.br.vitor.desafio2.service;

import com.br.vitor.desafio2.entity.Product;
import com.br.vitor.desafio2.repository.ProductRepository;
import com.br.vitor.desafio2.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Product insert(Product product) {
        return repository.save(product);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Product update(Long id, Product product) {
        try {
            Product entity = repository.getById(id);
            updateData(entity, product);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Product entity, Product product) {
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
    }

}
