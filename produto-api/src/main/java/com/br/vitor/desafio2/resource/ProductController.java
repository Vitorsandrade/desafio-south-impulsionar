package com.br.vitor.desafio2.resource;

import com.br.vitor.desafio2.dto.ProductDTO;
import com.br.vitor.desafio2.dto.RequestAmountDTO;
import com.br.vitor.desafio2.dto.RequestProductDTO;
import com.br.vitor.desafio2.entity.Product;
import com.br.vitor.desafio2.exceptions.FileIsEmptyException;
import com.br.vitor.desafio2.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
    private ProductService service;

    @GetMapping
    public ResponseEntity<Page<Product>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.listAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody @Valid RequestProductDTO requestDTO) {
        return new ResponseEntity<>(service.insert(requestDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody RequestProductDTO requestDTO) {
        return new ResponseEntity<>(service.update(id, requestDTO), HttpStatus.OK);
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<Void> upload(@RequestParam("file") MultipartFile file) throws FileIsEmptyException {
        String path = UUID.randomUUID() + "." + service.extractExtension(file.getOriginalFilename());

        try {
            Files.copy(file.getInputStream(), Path.of(path), StandardCopyOption.REPLACE_EXISTING);
            service.saveDataFromFile(path);
        } catch (IOException e) {
            throw new FileIsEmptyException(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/amount/{code}")
    public ResponseEntity<ProductDTO> teste(@PathVariable String code ,@RequestBody @Valid RequestAmountDTO requestDTO) {

        return new ResponseEntity<>(service.updateAmount(code, requestDTO), HttpStatus.OK);
    }

}
