package com.br.vitor.produtoApi.resource;

import com.br.vitor.produtoApi.entity.Product;
import com.br.vitor.produtoApi.service.ProductService;
import com.br.vitor.produtoApi.util.ProductCreator;
import com.br.vitor.produtoApi.util.ProductDTOCreator;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController productController;
    @Mock
    private ProductService productServiceMock;

    @BeforeEach
    void setUp() {
        PageImpl<Product> productPage = new PageImpl<>(List.of(ProductCreator.createProductWithAllAttributesFakerMinusTheName()));
        BDDMockito.when(productServiceMock.listAll(ArgumentMatchers.any()))
                .thenReturn(productPage);

        BDDMockito.when(productServiceMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(ProductCreator.createProductWithAllAttributes());

        BDDMockito.when(productServiceMock.insert(ArgumentMatchers.any()))
                .thenReturn(ProductDTOCreator.createProductDto());

        BDDMockito.doNothing().when(productServiceMock).delete(ArgumentMatchers.anyLong());

    }

    @Test
    void testReturnListOfProductsInsidePageController() {
        String expectedName = ProductCreator.createProductWithAllAttributesFakerMinusTheName().getName();

        Page<Product> productPage = productController.findAll(null).getBody();

        Assertions.assertThat(productPage).isNotNull();

        Assertions.assertThat(productPage.toList())
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(productPage.toList().get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    void testProductFindByIdController() {
        Long expectedId = ProductCreator.createProductWithAllAttributes().getId();

        Product product = productController.findById(1L).getBody();

        Assertions.assertThat(product).isNotNull();

        Assertions.assertThat(product.getId()).isNotNull().isEqualTo(expectedId);
    }

    @Test
    void testFindByIdIncorrectProduct() {
        Long expectedId = ProductCreator.createProductWithAllAttributes().getId();

        Product product = productController.findById(1L).getBody();
        product.setId(2L);
        Assertions.assertThat(product).isNotNull();

        Assertions.assertThat(product.getId()).isNotNull().isNotEqualTo(expectedId);
    }

//    @Test
//    void testInsertProductController() {
//        ProductDTO product = productController.insert(ProductCreator.createProductWithAllAttributes()).getBody();
//        Assertions.assertThat(product).isNotNull();
//    }

    @Test
    void testDeleteProductController() {

        Assertions.assertThatCode(() -> productController.delete(1L))
                .doesNotThrowAnyException();

        ResponseEntity<Void> entity = productController.delete(1L);

        Assertions.assertThat(entity).isNotNull();

        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }


}