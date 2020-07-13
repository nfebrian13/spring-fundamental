package com.jpafilter.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jpafilter.demo.model.Product;
import com.jpafilter.demo.services.ProductPageService;
import com.jpafilter.demo.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductPageService pageService;

/*	@RequestMapping("/")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<Product> listProducts = service.listAll(keyword);
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("keyword", keyword);
		return "product/product_list";
	} */
	
	@RequestMapping("/")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
//		String keyword = "China";
		return listByPage(model, 1, "name", "asc", keyword);
	}
	
	@GetMapping("/page/{pageNumber}")
	public String listByPage(Model model, 
			@PathVariable("pageNumber") int currentPage,
			@RequestParam(value="sortField", defaultValue = "name") String sortField,
			@RequestParam(value="sortDir", defaultValue = "asc") String sortDir,
			@Param("keyword") String keyword) {
		
		Page<Product> page = pageService.listAll(currentPage, sortField, sortDir, keyword);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		
		List<Product> listProducts = page.getContent();
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("keyword", keyword);
		
		String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
		model.addAttribute("reverseSortDir", reverseSortDir);
		
		return "product/product_list";
	}

	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "product/new_product";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("product/edit_product");
		Product product = service.get(id);
		mav.addObject("product", product);
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
	}

	@GetMapping("/plain-page")
	public String plainPage() {
		return "plain-page";
	}

	@GetMapping("/pricing-tables")
	public String pricingTables() {
		return "pricing-tables";
	}

}
