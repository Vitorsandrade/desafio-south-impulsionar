package com.br.vitor.produtoProducerApi.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

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