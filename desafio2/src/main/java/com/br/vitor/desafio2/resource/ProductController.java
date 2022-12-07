package com.br.vitor.desafio2.resource;

import com.br.vitor.desafio2.dto.ProductDTO;
import com.br.vitor.desafio2.entity.Product;
import com.br.vitor.desafio2.mapper.ProductMapper;
import com.br.vitor.desafio2.service.ProductService;
import com.br.vitor.desafio2.exceptions.FileIsEmptyException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
    private ProductService service;
    private ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<Page<Product>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.listAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Product product = service.findById(id);

        return ResponseEntity.ok().body(new ProductDTO(product));
    }

    @PostMapping
    public ResponseEntity insert(@RequestBody @Valid Product product) {
        product = service.insert(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(productMapper.toProductDTO(product));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody Product product) {
        product = service.update(id, product);

        return ResponseEntity.ok().body(productMapper.toProductDTO(product));
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


}
