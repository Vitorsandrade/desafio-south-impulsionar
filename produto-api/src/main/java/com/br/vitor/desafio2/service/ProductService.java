package com.br.vitor.desafio2.service;

import com.br.vitor.desafio2.dto.ProductDTO;
import com.br.vitor.desafio2.dto.RequestAmountDTO;
import com.br.vitor.desafio2.dto.RequestProductDTO;
import com.br.vitor.desafio2.entity.Product;
import com.br.vitor.desafio2.exceptions.InvalidCodeException;
import com.br.vitor.desafio2.exceptions.InvalidFileException;
import com.br.vitor.desafio2.exceptions.ResourceNotFoundException;
import com.br.vitor.desafio2.mapper.ProductMapper;
import com.br.vitor.desafio2.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository repository;

    private ProductMapper productMapper;

    private RabbitTemplate rabbitTemplate;

    public Page<Product> listAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public ProductDTO insert(RequestProductDTO requestDTO) {
        var product = productMapper.requestToProduct(requestDTO);

        product.setCode(generateCode());
        product.setBarCode(generateCodBar());
        product.setManufacturingDate(LocalDate.now());
        product.setExpirationDate(null);
        String year = String.valueOf(LocalDate.now().getYear());
        String month = String.valueOf(LocalDate.now().getMonthValue());
        product.setSeries(month + "/" + year);
        product.setAmount(0);
        product.setPrice(finalValue(product.getTax(),product.getPrice()));

        repository.save(product);
        return productMapper.productToProductDTO(product);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public ProductDTO update(Long id, RequestProductDTO requestDTO) {
        try {
            Product entity = repository.getById(id);
            updateData(entity, productMapper.requestToProduct(requestDTO));
            repository.save(entity);
            return productMapper.productToProductDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(Product entity, Product product) {
        entity.setAmount(product.getAmount());
        entity.setCategory(product.getCategory());
        entity.setColor(product.getColor());
        entity.setDescription(product.getDescription());
        entity.setName(product.getName());
        entity.setMaterial(product.getMaterial());
        entity.setPrice(product.getPrice());
    }

    public Product insertFromFile(String code, Product product) {
        try {
            if (repository.getByCode(code) == null) {
                return repository.save(product);
            }
            Product entity = repository.getByCode(code);
            updateData(entity, product);
            entity.setAmount(0);

            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(e);
        }
    }

    public void saveDataFromFile(String path) throws IOException {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));

            String line = br.readLine();
            String data[];

            while ((line = br.readLine()) != null) {

                data = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");


                BigDecimal price = finalValue(new BigDecimal(data[7].replace(",", ".").replace("\"", ""))
                        , new BigDecimal(data[6].replace(",", ".").replace("\"", "")));

                DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                LocalDate manufacturingDate = LocalDate.parse(data[8], fmt1);

                LocalDate expirationDate = null;

                if (!data[9].equals("n/a")) {
                    expirationDate = LocalDate.parse(data[9], fmt1);
                }

                Product product = Product.builder().id(null).code(data[0]).barCode(data[1]).series(data[2]).name(data[3])
                        .description(data[4]).price(price).manufacturingDate(manufacturingDate).expirationDate(expirationDate)
                        .color(data[10]).material(data[11]).category(data[5]).build();

                insertFromFile(data[0], product);

            }
            br.close();

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidFileException(e.getMessage());
        } catch (IOException e) {
            throw new InvalidFileException(e.getMessage());
        } finally {

            Path deleteFile = Paths.get(path);
            Files.deleteIfExists(deleteFile);
        }
    }

    public ProductDTO updateAmount(String code, RequestAmountDTO requestDTO) {
        try {
            Product entity = repository.getByCode(code);
            entity.setAmount(requestDTO.getAmount());
            repository.save(entity);

            rabbitTemplate.convertAndSend("PRODUCT_CHANGED",entity.toString());
            return productMapper.productToProductDTO(entity);

        } catch (EntityNotFoundException e) {
            throw new InvalidCodeException(code);
        }catch (NullPointerException e){
            throw new InvalidCodeException(code);
        }
    }


    public static BigDecimal finalValue(BigDecimal taxValue, BigDecimal grossValue) {

        BigDecimal profitMargin = new BigDecimal("45").divide(new BigDecimal("100"));

        BigDecimal tax = new BigDecimal(String.valueOf(taxValue)).divide(new BigDecimal("100"));

        BigDecimal priceWithTax = new BigDecimal(String.valueOf(grossValue)).multiply(tax).add(grossValue);

        BigDecimal price = new BigDecimal(String.valueOf(priceWithTax)).multiply(profitMargin)
                .add(priceWithTax).setScale(2, RoundingMode.CEILING);

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
