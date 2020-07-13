package com.jpafilter.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jpafilter.demo.model.Product;

public interface ProductPageRepository extends PagingAndSortingRepository<Product, Long> {

	@Query("SELECT p FROM Product p WHERE " 
			+ "CONCAT(p.id, p.name, p.brand, p.madein, p.price)"
			+" LIKE %?1%")
	public Page<Product> findPageAll(String keyword, Pageable pageagble);
}
