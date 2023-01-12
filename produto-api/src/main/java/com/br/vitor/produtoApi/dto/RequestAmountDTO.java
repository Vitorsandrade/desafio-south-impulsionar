package com.br.vitor.produtoApi.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
public class RequestAmountDTO {

    @NotNull
    private Integer amount;
}
