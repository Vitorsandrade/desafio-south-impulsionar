package com.br.vitor.desafio2.resource;

import com.br.vitor.desafio2.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @GetMapping
    public ResponseEntity<Product> findAll(){
        Product p = new Product(1L, BigDecimal.ONE, "sds", "sds", 1);
        return ResponseEntity.ok().body(p);
    }
}
