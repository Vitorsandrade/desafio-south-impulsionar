package com.br.vitor.desafio2.repository;

import com.br.vitor.desafio2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product getByCode(String code);
}
