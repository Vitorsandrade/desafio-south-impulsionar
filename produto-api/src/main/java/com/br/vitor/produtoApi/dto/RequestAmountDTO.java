package com.br.vitor.produtoApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.validation.constraints.NotNull;

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
public class RequestAmountDTO {

    @NotNull
    private Integer amount;
}
