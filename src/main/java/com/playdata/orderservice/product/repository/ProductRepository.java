package com.playdata.orderservice.product.repository;

import com.playdata.orderservice.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //검색조건 ( 카테고리)에 따른 페이징
    @Query("SELECT p FROM Product p WHERE p.category = ?1")
    Page<Product> findByCategoryValue(String category, Pageable pageable);

    //검색조건 (검색어 )에 따른 페이징
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    Page<Product> findByNameValue(String keyword, Pageable pageable);

}
