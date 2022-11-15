package com.br.vitor.desafio2.service;

import com.br.vitor.desafio2.dto.ProductDTO;
import com.br.vitor.desafio2.entity.Product;
import com.br.vitor.desafio2.repository.ProductRepository;
import com.br.vitor.desafio2.service.exceptions.ResourceNotFoundException;
import com.br.vitor.desafio2.service.exceptions.InvalidFileException;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
        product.setCode(generateCode());
        product.setBarCode(generateCodBar());
        product.setManufacturingDate(LocalDate.now());
        product.setExpirationDate(null);
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

    public Product insertFromFile(String code, Product product) {
        try {
            if (repository.getByCode(code) == null) {
                return repository.save(product);
            }
            Product entity = repository.getByCode(code);
            updateData(entity, product);

            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(e);
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


    public void saveDataFromFile(String path) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            String data[];

            while ((line = br.readLine()) != null) {
                data = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");


                BigDecimal price = finalValue(data[7], data[6]);

                DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                LocalDate manufacturingDate = LocalDate.parse(data[8], fmt1);

                LocalDate expirationDate = null;

                if (!data[9].equals("n/a")) {
                    expirationDate = LocalDate.parse(data[9], fmt1);
                }


                Product product = new Product(null, data[0], data[1], data[2], data[3], data[4], price,
                        manufacturingDate, expirationDate, data[10], data[11], data[5], Integer.parseInt(data[12]));

                insertFromFile(data[0], product);


            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidFileException(e.getMessage());
        } catch (IOException e) {
            throw new InvalidFileException(e.getMessage());
        }
    }

    public static BigDecimal finalValue(String taxValue, String grossValue) {

        BigDecimal profitMargin = new BigDecimal("45").divide(new BigDecimal("100")).add(new BigDecimal("1"));

        BigDecimal tax = new BigDecimal(taxValue.replace(",", ".").replace("\"", "")).divide(new BigDecimal("100"))
                .add(new BigDecimal("1"));

        BigDecimal price = new BigDecimal(grossValue.replace(",", ".").replace("\"", "")).multiply(tax)
                .multiply(profitMargin).setScale(2, RoundingMode.CEILING);

        return price;
    }


    public String extractExtension(String fileName) {
        int i = fileName.lastIndexOf(".");
        return fileName.substring(i + 1);
    }

    public String generateCodBar() {

        String characters = "0123456789";
        String randomString = "";
        int length = 12;

        Random rand = new Random();

        char[] text = new char[length];

        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rand.nextInt(characters.length()));
        }

        for (int i = 0; i < text.length; i++) {
            randomString += text[i];
        }

        return randomString;
    }

    public String generateCode() {
        String characters = "abcdefghijkmnopqrstuvwxyz023456789";
        String randomString = "";
        int length = 8;

        Random rand = new Random();

        char[] text = new char[length];

        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rand.nextInt(characters.length()));
        }

        for (int i = 0; i < text.length; i++) {
            randomString += text[i];
        }

        return randomString;

    }
}
