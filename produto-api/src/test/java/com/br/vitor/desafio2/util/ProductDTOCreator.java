package com.br.vitor.desafio2.util;

import com.br.vitor.desafio2.dto.ProductDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductDTOCreator {

    public static ProductDTO createProductDto() {
        return ProductDTO.builder()
                .id(1L).name("teste").category("teste").price(BigDecimal.TEN).code("8754hjkd4")
                .color("teste").series("hsagdj").amount(1).material("teste").expirationDate(LocalDate.now())
                .manufacturingDate(LocalDate.now()).description("hjkfgsdhfg").barCode("478657846")
                .build();
    }

    public static ProductDTO createProductDtoNoId() {
        return ProductDTO.builder()
                .name("teste").category("teste").price(BigDecimal.TEN).code("8754hjkd4")
                .color("teste").series("hsagdj").amount(1).material("teste").expirationDate(LocalDate.now())
                .manufacturingDate(LocalDate.now()).description("hjkfgsdhfg").barCode("478657846")
                .build();
    }
}
