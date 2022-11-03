package com.br.vitor.desafio2.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Entity
public class Product {

    @Id
    private Integer id;


}
