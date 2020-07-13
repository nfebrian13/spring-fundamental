package com.jpafilter.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpafilter.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
