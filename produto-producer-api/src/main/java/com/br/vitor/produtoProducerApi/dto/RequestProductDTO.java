package com.br.vitor.produtoProducerApi.dto;

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

    private Long id;
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
