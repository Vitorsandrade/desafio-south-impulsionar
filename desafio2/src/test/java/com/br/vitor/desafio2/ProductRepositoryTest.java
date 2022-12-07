package com.br.vitor.desafio2;

import com.br.vitor.desafio2.entity.Product;
import com.br.vitor.desafio2.repository.ProductRepository;
import com.br.vitor.desafio2.util.ProductCreator;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@DisplayName("Tests for Product Repository")
@Log4j2
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;


    @Test
    void savePersistProductWhenSuccessful(){
        Product productToBeSaved = ProductCreator.createProductWithMandatoryAttributes();

        Product productSaved = this.repository.save(productToBeSaved);

        Assertions.assertThat(productSaved).isNotNull();

        Assertions.assertThat(productSaved.getId()).isNotNull();

        Assertions.assertThat(productSaved.getName()).isEqualTo(productToBeSaved.getName());
    }

    @Test
    void saveUpdatesProductWhenSuccessful(){
        Product productToBeSaved = ProductCreator.createProductWithMandatoryAttributes();

        Product productSaved = this.repository.save(productToBeSaved);

        productSaved.setName("atualizado");

        Product productUpdated = this.repository.save(productSaved);

        Assertions.assertThat(productUpdated).isNotNull();

        Assertions.assertThat(productUpdated.getId()).isNotNull();

        Assertions.assertThat(productUpdated.getName()).isEqualTo(productSaved.getName());
    }

    @Test
    void deleteRemovesProductWhenSuccessful(){
        Product productToBeSaved = ProductCreator.createProductWithMandatoryAttributes();

        Product productSaved = this.repository.save(productToBeSaved);

        this.repository.delete(productSaved);

        Optional<Product> productOptional = this.repository.findById(productSaved.getId());

        Assertions.assertThat(productOptional).isEmpty();

    }

    @Test
    void getByCodeReturnsProductCodeWhenSuccessful(){
        Product productToBeSaved = ProductCreator.createProductWithMandatoryAttributesAndCode();

        Product productSaved = this.repository.save(productToBeSaved);

        String code = productSaved.getCode();

        Product product = this.repository.getByCode(code);

        Assertions.assertThat(product).isNotNull();

        Assertions.assertThat(product.getId()).isNotNull();

        Assertions.assertThat(product.getCode()).isEqualTo(code);

    }
}
