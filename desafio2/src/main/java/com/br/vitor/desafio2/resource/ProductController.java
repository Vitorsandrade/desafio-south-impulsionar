package com.br.vitor.desafio2.resource;

import com.br.vitor.desafio2.dto.ProductDTO;
import com.br.vitor.desafio2.entity.Product;
import com.br.vitor.desafio2.service.ProductService;
import com.br.vitor.desafio2.exceptions.FileIsEmptyException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
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
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                    @RequestParam(value = "size", defaultValue = "10") Integer size) {
        List<ProductDTO> listDto = service.findAll(PageRequest.of(page, size));

        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Product product = service.findById(id);

        return ResponseEntity.ok().body(new ProductDTO(product));
    }

    @PostMapping
    public ResponseEntity insert(@RequestBody @Valid ProductDTO productDTO) {
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

    //tratamento com file.isempity
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
