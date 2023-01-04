package com.br.vitor.desafio2.dto;

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
