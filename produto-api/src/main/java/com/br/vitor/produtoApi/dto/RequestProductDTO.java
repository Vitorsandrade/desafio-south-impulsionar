package com.br.vitor.produtoApi.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
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
