package com.br.vitor.desafio2.resource;

import com.br.vitor.desafio2.entity.Product;
import com.br.vitor.desafio2.service.ProductService;
import com.br.vitor.desafio2.util.ProductCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController productController;
    @Mock
    private ProductService productServiceMock;

    @BeforeEach
    void setUp(){
        PageImpl<Product> productPage = new PageImpl<>(List.of(ProductCreator.createProductWithMandatoryAttributes()));
        BDDMockito.when(productServiceMock.listAll(ArgumentMatchers.any()))
                .thenReturn(productPage);
    }

    @Test
    void returnListOfProductsInsidePageObject(){
        String expectedName = ProductCreator.createProductWithMandatoryAttributesAndCode().getName();

        Page<Product> productPage = productController.findAll(null).getBody();

        Assertions.assertThat(productPage).isNotNull();

        Assertions.assertThat(productPage.toList())
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(productPage.toList().get(0).getName()).isEqualTo(expectedName);
    }

}