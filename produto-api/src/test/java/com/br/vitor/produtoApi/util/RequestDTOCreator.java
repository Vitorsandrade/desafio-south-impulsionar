package com.br.vitor.produtoApi.util;

import com.br.vitor.produtoApi.dto.RequestProductDTO;

import java.math.BigDecimal;

public class RequestDTOCreator {

    public static RequestProductDTO createRequestProductDto() {
        return RequestProductDTO.builder()
                .category("teste").price(BigDecimal.TEN)
                .color("teste").material("teste").description("hjkfgsdhfg")
                .build();
    }
}
