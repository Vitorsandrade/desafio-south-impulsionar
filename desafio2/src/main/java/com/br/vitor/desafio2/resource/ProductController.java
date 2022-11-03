package com.br.vitor.desafio2.resource;

import com.br.vitor.desafio2.entity.Product;
import com.br.vitor.desafio2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


    @PostMapping
    public ResponseEntity add(@RequestBody Product product) {
        service.save(product);

        return ResponseEntity.status(201).build();
    }
}
