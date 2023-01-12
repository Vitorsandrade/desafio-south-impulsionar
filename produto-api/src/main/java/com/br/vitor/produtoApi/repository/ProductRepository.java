package com.br.vitor.produtoApi.repository;

import com.br.vitor.produtoApi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product getByCode(String code);
}
