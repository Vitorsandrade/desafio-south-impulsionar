package com.br.vitor.produtoProducerApi.resource;

import com.br.vitor.produtoProducerApi.dto.RequestProductDTO;
import com.br.vitor.produtoProducerApi.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id){
        service.sendMessageDeleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Void> updateMessage(@PathVariable Long id, @RequestBody @Valid RequestProductDTO requestDTO){
        service.sendMessageUpdateProduct(id, requestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}