package com.jpafilter.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpafilter.demo.model.Product;
import com.jpafilter.demo.repository.ProductPageRepository;

@Service
public class ProductPageService {

	@Autowired
	private ProductPageRepository repo;

	public Page<Product> listAll(int pageNumber, String sortField, String sortDir,
			String keyword) {
		Sort sort = Sort.by(sortField);
		sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();

		Pageable pageable = PageRequest.of(pageNumber - 1, 6, sort);
		
		if (keyword != null) {
			return repo.findPageAll(keyword, pageable);
		}
		
		return repo.findAll(pageable);
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
