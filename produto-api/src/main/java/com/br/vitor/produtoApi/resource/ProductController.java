package com.br.vitor.produtoApi.resource;

import com.br.vitor.produtoApi.dto.ProductDTO;
import com.br.vitor.produtoApi.dto.RequestAmountDTO;
import com.br.vitor.produtoApi.dto.RequestProductDTO;
import com.br.vitor.produtoApi.entity.Product;
import com.br.vitor.produtoApi.exceptions.FileIsEmptyException;
import com.br.vitor.produtoApi.service.ProductService;
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

    @GetMapping("/get/all")
    public ResponseEntity<Page<Product>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.listAll(pageable));
    }

    @GetMapping(value = "/get/{id}")
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
    public ResponseEntity<Void> teste(@PathVariable String code, @RequestBody @Valid RequestAmountDTO requestDTO) {

        service.sendMessageUpdateAmount(code, requestDTO);
        return ResponseEntity.ok().build();
    }

}
