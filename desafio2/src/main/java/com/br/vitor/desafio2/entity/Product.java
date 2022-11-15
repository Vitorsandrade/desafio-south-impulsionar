package com.br.vitor.desafio2.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @Column(name = "bar_code")
    private String barCode;

    private String series;

    private String name;

    private String description;

    private BigDecimal price;

    @Column(name = "manufacturing_date")
    private LocalDate manufacturingDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    private String color;

    private String material;

    private String category;

    private Integer amount;

    public Product(String code, String barCode, String series, String name, String description, BigDecimal price, LocalDate manufacturingDate, LocalDate expirationDate, String color, String material, String category, Integer amount) {
        this.code = code;
        this.barCode = barCode;
        this.series = series;
        this.name = name;
        this.description = description;
        this.price = price;
        this.manufacturingDate = manufacturingDate;
        this.expirationDate = expirationDate;
        this.color = color;
        this.material = material;
        this.category = category;
        this.amount = amount;
    }
}
