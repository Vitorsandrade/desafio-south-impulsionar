package com.br.vitor.desafio2.dto;

import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@With
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
