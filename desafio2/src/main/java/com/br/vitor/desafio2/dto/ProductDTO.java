package com.br.vitor.desafio2.dto;

import com.br.vitor.desafio2.entity.Product;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public ProductDTO(Product product) {
        id = product.getId();
        code = product.getCode();
        barCode = product.getBarCode();
        series = product.getSeries();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        manufacturingDate = product.getManufacturingDate();
        expirationDate = product.getExpirationDate();
        color = product.getColor();
        material = product.getMaterial();
        amount = product.getAmount();
        category = product.getCategory();
    }

    private Long id;
    private String code;
    private String barCode;
    private String series;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate manufacturingDate;
    private LocalDate expirationDate;
    private String color;
    private String material;
    private String category;
    private Integer amount;
}
