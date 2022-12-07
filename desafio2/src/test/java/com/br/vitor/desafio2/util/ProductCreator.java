package com.br.vitor.desafio2.util;

import com.br.vitor.desafio2.entity.Product;

import java.math.BigDecimal;

public class ProductCreator {

    public static Product createProductWithMandatoryAttributes(){
        return Product.builder().id(1L).name("teste").category("teste").price(BigDecimal.TEN).build();
    }

    public static Product createProductNotId(){
        return Product.builder().name("teste").category("teste").price(BigDecimal.TEN).build();
    }

    public static Product createValidUpdateProduct(){
        return Product.builder().id(1L).name("teste atualizado").category("teste").price(BigDecimal.TEN).build();
    }

    public static Product createProductWithMandatoryAttributesAndCode(){
        return Product.builder().id(1L).name("teste").category("teste").price(BigDecimal.TEN).code("8754hjkd4").build();
    }
}
