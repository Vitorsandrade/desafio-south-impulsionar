package com.br.vitor.produtoApi.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String code;
    private String barCode;
    private String series;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal tax;
    private LocalDate manufacturingDate;
    private LocalDate expirationDate;
    private String color;
    private String material;
    private String category;
    private Integer amount;

}
