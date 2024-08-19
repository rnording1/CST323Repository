package com.gcu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.data.ProductsDataService;
import com.gcu.data.entity.ProductEntity;

@Controller
public class HomeController {
	
	@Autowired
	private ProductsDataService productService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<ProductEntity> products = productService.findAll();
		model.addAttribute("products", products);
		return "index";
	}
}
