package com.br.vitor.produtoProducerApi.resource;

import com.br.vitor.produtoProducerApi.dto.RequestProductDTO;
import com.br.vitor.produtoProducerApi.entity.Product;
import com.br.vitor.produtoProducerApi.service.PageableResponse;
import com.br.vitor.produtoProducerApi.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/send")
public class ProductController {
    private ProductService service;


    @PostMapping(value = "/insert")
    public ResponseEntity<Void> insertMessage(@RequestBody @Valid RequestProductDTO requestDTO) {
        service.sendMessageInsertProduct(requestDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        service.sendMessageDeleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Void> updateMessage(@PathVariable Long id, @RequestBody @Valid RequestProductDTO requestDTO) {
        service.sendMessageUpdateProduct(id, requestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:8080/api/products/get").build();
        ResponseEntity<Product> product = restTemplate.getForEntity("/" + id, Product.class);
        return ResponseEntity.ok(product).getBody();
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<PageableResponse<Product>> test() {
        RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:8080/api/products/get").build();
        ResponseEntity<PageableResponse<Product>> exchange = restTemplate.exchange("/all", HttpMethod.GET,HttpEntity.EMPTY,
                new ParameterizedTypeReference<PageableResponse<Product>>() {
                });
        return ResponseEntity.ok(exchange).getBody();
    }


}