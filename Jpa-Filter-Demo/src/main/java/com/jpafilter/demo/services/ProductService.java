package com.jpafilter.demo.services;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jpafilter.demo.model.Product;
import com.jpafilter.demo.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public List<Product> listAll(String keyword) {
		if (keyword != null) {
			return repo.findAll(keyword);
		}
		
		return repo.findAll();
	}

	public void save(Product product) {
		repo.save(product);
	}

	public Product get(long id) {
		return repo.findById(id).get();
	}

	public void delete(long id) {
		repo.deleteById(id);
	}
}
