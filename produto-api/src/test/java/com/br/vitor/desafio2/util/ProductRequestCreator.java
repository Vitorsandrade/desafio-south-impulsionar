package com.br.vitor.desafio2.util;

import com.br.vitor.desafio2.dto.RequestProductDTO;
import com.br.vitor.desafio2.entity.Product;
import com.github.javafaker.Faker;

import java.math.BigDecimal;

public class ProductRequestCreator {

    public static RequestProductDTO createRequestWithAllAttributesFakerMinusTheName() {
        Faker faker = new Faker();
        return RequestProductDTO.builder().name("teste").category(faker.commerce().department())
                .price(new BigDecimal(faker.commerce().price().replace(",", "."))).color(faker.commerce().color()).amount(faker.number()
                        .randomDigitNotZero()).material(faker.commerce().material()).description(faker.lorem().paragraph()).build();
    }

}
