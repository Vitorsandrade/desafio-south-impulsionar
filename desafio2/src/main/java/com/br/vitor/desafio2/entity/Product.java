package com.br.vitor.desafio2.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "barcode")
    private String barCode;

    @Column(name = "series")
    private String series;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "manufacturingdate")
    private LocalDate manufacturingDate;

    @Column(name = "expirationdate")
    private LocalDate expirationDate;

    @Column(name = "color")
    private String color;

    @Column(name = "material")
    private String material;

    @Column(name = "category")
    private String category;

    @Column(name = "amount")
    private Integer amount;

}
