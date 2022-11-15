package com.br.vitor.desafio2.service;

import com.br.vitor.desafio2.dto.ProductDTO;
import com.br.vitor.desafio2.entity.Product;
import com.br.vitor.desafio2.repository.ProductRepository;
import com.br.vitor.desafio2.service.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {
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
        } catch (EntityNotFoundException e) {
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

    public Product cathDTO(ProductDTO productDTO) {

        return new Product(productDTO.getId(), productDTO.getCode(), productDTO.getBarCode(),
                productDTO.getSeries(), productDTO.getName(), productDTO.getDescription(),
                productDTO.getPrice(), productDTO.getManufacturingDate(),
                productDTO.getExpirationDate(), productDTO.getColor(), productDTO.getMaterial(),
                productDTO.getCategory(), productDTO.getAmount());
    }



    public String extractExtension(String fileName) {
        int i = fileName.lastIndexOf(".");
        return fileName.substring(i + 1);
    }

    public void saveDataFromFile(String path){

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            String data[];

            while ((line = br.readLine()) != null) {
                data = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

                Product product = new Product("12sdrevf","123456789012","12/09",data[0]
                        ,"ótimo", BigDecimal.ONE, LocalDate.now(),LocalDate.now(), data[2],"ferro", data[1],10);
                insert(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
