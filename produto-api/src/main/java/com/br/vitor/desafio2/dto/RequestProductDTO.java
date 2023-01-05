package com.br.vitor.desafio2.dto;

import lombok.Builder;
import lombok.Data;
import lombok.With;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@With
public class RequestProductDTO {

    @NotBlank
    private String name;
    private String description;
    @NotNull
    private BigDecimal price;
    private String color;
    private String material;
    @NotBlank
    private String category;
    @NotNull
    private BigDecimal tax;
}
