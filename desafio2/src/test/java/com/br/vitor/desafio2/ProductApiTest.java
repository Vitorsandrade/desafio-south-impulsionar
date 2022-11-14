package com.br.vitor.desafio2;

import com.br.vitor.desafio2.dto.ProductDTO;
import com.br.vitor.desafio2.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Type;
import java.util.List;

//@SpringBootTest(classes = Desafio2ApplicationTests.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductApiTest {

//    @Autowired
//    protected TestRestTemplate rest;
//
//    private ResponseEntity<ProductDTO> getProduct(String url) {
//        return rest.getForEntity(url, ProductDTO.class);
//    }
//
//    private ResponseEntity<List<ProductDTO>> getProducts(String url) {
//        return rest.exchange(url,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<ProductDTO>>() {
//        });
//    }
//    @Test
//    public void testSave(){
//        Product p = new Product();
//        p.setName("teclado");
//        p.setColor("preto");
//
//        ResponseEntity response = rest.postForEntity("product",p,null);
//        System.out.println(response);
//    }
//    @Test
//    public void testGetNotFound(){
//        ResponseEntity response = getProduct("product/1000");
//        System.out.println(response);
//    }

}
