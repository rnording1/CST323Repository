package com.gcu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.data.ProductsDataService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.models.ProductModel;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

@Controller
public class ProductController {

	@Autowired
	private ProductsDataService productService;

	@GetMapping("/createProduct")
	public String showProductForm(Model model) {
		model.addAttribute("product", new ProductEntity());
		return "product";
	}

	@PostMapping("/createProduct")
	public String submitProductForm(@Valid @ModelAttribute("product") ProductEntity product,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "product";
		}
		// Logic to handle product creation (e.g., save to database)
		productService.create(product);
		return "redirect:/createProduct?success";
	}

	@GetMapping("/deleteProduct")
	public String showDeleteProductPage(Model model) {
		List<ProductEntity> products = productService.findAll();
		model.addAttribute("products", products);
		return "deleteProduct";
	}

	@PostMapping("/deleteProduct")
	public String deleteProducts(@RequestParam List<Long> productIds) {
		productService.deleteProductsByIds(productIds);
		return "redirect:/deleteProduct";
	}

	@GetMapping("/updateProduct")
	public String showUpdateProductPage(Model model) {
		List<ProductEntity> products = productService.findAll();
		model.addAttribute("products", products);
	    model.addAttribute("product", new ProductEntity());
		return "updateProduct";
	}

	@PostMapping("/updateProduct")
	public String updateProduct(@RequestParam("productID") Long productID,
	                            @RequestParam("name") String name,
	                            @RequestParam("description") String description,
	                            @RequestParam("price") String priceStr) {

	    ProductEntity product = new ProductEntity();
	    product.setProductID(productID);
	    product.setName(name);
	    product.setDescription(description);

	    try {
	        BigDecimal price = new BigDecimal(priceStr);
	        product.setPrice(price);
	    } catch (NumberFormatException e) {
	        // Handle the exception if the price string is not a valid BigDecimal
	        e.printStackTrace();
	        return "redirect:/updateProduct?error=invalidPrice";
	    }

	    productService.update(product);
	    return "redirect:/updateProduct";
	}
}
