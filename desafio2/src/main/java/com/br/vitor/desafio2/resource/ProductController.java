package com.br.vitor.desafio2.resource;

import com.br.vitor.desafio2.dto.ProductDTO;
import com.br.vitor.desafio2.entity.Product;
import com.br.vitor.desafio2.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<Product> list = service.findAll();
        List<ProductDTO> listDto = list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Product product = service.findById(id);

        return ResponseEntity.ok().body(new ProductDTO(product));
    }

    @PostMapping
    public ResponseEntity insert(@RequestBody ProductDTO productDTO) {
        Product product = service.cathDTO(productDTO);
        product = service.insert(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(product);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Product product = service.cathDTO(productDTO);
        product = service.update(id, product);

        return ResponseEntity.ok().body(product);
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<Void> upload(@RequestParam("file") MultipartFile file) throws IOException {
        String pathDirectory = "src/main/resources/";
        String path = pathDirectory + UUID.randomUUID() + "." + service.extractExtension(file.getOriginalFilename());

        Files.copy(file.getInputStream(), Path.of(path), StandardCopyOption.REPLACE_EXISTING);
        service.saveDataFromFile(path);

        return ResponseEntity.ok().build();


    }


}
