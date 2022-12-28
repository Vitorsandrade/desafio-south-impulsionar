package com.br.vitor.desafio2.util;

import com.br.vitor.desafio2.entity.Product;
import com.github.javafaker.Faker;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductCreator {

    public static Product createProductWithAllAttributesNoName() {
        Faker faker = new Faker();
        return Product.builder().category(faker.commerce().department())
                .price(new BigDecimal(faker.commerce().price()
                        .replace(",", "."))).code("sdjkfhs")
                .color(faker.commerce().color()).series("hsagdj").amount(faker.number()
                        .randomDigitNotZero()).material(faker.commerce().material()).description(faker.lorem().paragraph())
                .barCode("478657846").build();
    }

    public static Product createProductWithAllAttributesFakerMinusTheName() {
        Faker faker = new Faker();
        return Product.builder().id(1L).name("teste").category(faker.commerce().department())
                .price(new BigDecimal(faker.commerce().price().replace(",", "."))).code(faker.commerce()
                        .promotionCode()).color(faker.commerce().color()).series("hsagdj").amount(faker.number()
                        .randomDigitNotZero()).material(faker.commerce().material()).expirationDate(LocalDate.now())
                .manufacturingDate(LocalDate.now()).description(faker.lorem().paragraph()).barCode("478657846").build();
    }

    public static Product createProductWithAllAttributes() {
        Faker faker = new Faker();
        return Product.builder().id(1L).name("teste").category(faker.commerce().department())
                .price(new BigDecimal(faker.commerce().price().replace(",", "."))).code(faker.commerce()
                        .promotionCode()).color(faker.commerce().color()).series("hsagdj").amount(faker.number()
                        .randomDigitNotZero()).material(faker.commerce().material()).expirationDate(LocalDate.now())
                .manufacturingDate(LocalDate.now()).description(faker.lorem().paragraph()).barCode("478657846").build();
    }
}
