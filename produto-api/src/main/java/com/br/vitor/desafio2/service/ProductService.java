package com.br.vitor.desafio2.service;

import com.br.vitor.desafio2.dto.ProductDTO;
import com.br.vitor.desafio2.dto.RequestProductDTO;
import com.br.vitor.desafio2.entity.Product;
import com.br.vitor.desafio2.exceptions.InvalidFileException;
import com.br.vitor.desafio2.exceptions.ResourceNotFoundException;
import com.br.vitor.desafio2.mapper.ProductMapper;
import com.br.vitor.desafio2.repository.ProductRepository;
import lombok.AllArgsConstructor;
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


    public Page<Product> listAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public ProductDTO insert(RequestProductDTO requestDTO) {
        ProductDTO productDTO = productMapper.requestToProductDTO(requestDTO);
        productDTO.setCode(generateCode());
        productDTO.setBarCode(generateCodBar());
        productDTO.setManufacturingDate(LocalDate.now());
        productDTO.setExpirationDate(null);
        String year = String.valueOf(LocalDate.now().getYear());
        String month = String.valueOf(LocalDate.now().getMonthValue());
        productDTO.setSeries(month + "/" + year);

        Product product = productMapper.productDtoToProduct(productDTO);
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

    public ProductDTO update(Long id, Product product) {
        try {
            Product entity = repository.getById(id);
            updateData(entity, product);
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
        entity.setCode(product.getCode());
        entity.setBarCode(product.getBarCode());
        entity.setExpirationDate(product.getExpirationDate());
        entity.setManufacturingDate(product.getManufacturingDate());
        entity.setSeries(product.getSeries());
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

    public void saveDataFromFile(String path) throws IOException {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));

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

                Product product = Product.builder().id(null).code(data[0]).barCode(data[1]).series(data[2]).name(data[3])
                        .description(data[4]).price(price).manufacturingDate(manufacturingDate).expirationDate(expirationDate)
                        .color(data[10]).material(data[11]).category(data[5]).amount(Integer.parseInt(data[12])).build();

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