package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.model.Product;
import lv.venta.service.ICRUDProductService;
@Controller
@RequestMapping("/product/crud")
public class ProductCrudController {

	
	@Autowired
	private ICRUDProductService prodService;
	
	@GetMapping("/all")//localhost:8080/product/crud/all
	public String getControllerAllProducts(Model model ) {
		try {
		ArrayList<Product> allProducts = prodService.retrieveAll();
		model.addAttribute("package", allProducts);
		return "show-all-product-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error-page";
		}
	}

	@GetMapping("/one")//localhost:8080/product/crud/one?id=2
	public String getControllerOneProductsById(@RequestParam(name = "id")int id,Model model) {
		
		try {
		Product oneProducts = prodService.retrieveById(id);
		model.addAttribute("package", oneProducts);
		return "how-one-PRODUCT-PAGE";
		}
		catch (Exception e){
			model.addAttribute("package", e.getMessage());
			return "show-error-page";
		}
	}
	
	@GetMapping("/all/{id}")//localhost:8080/product/crud/all/2
	
	public String getControllerGetOneProductByIdSecoundApproach(@PathVariable(name = "id")int id, Model model) {
	try {
	Product oneProducts = prodService.retrieveById(id);
	model.addAttribute("package", oneProducts);
	return "how-one-PRODUCT-PAGE";
	}
	catch (Exception e){
		model.addAttribute("package", e.getMessage());
		return "show-error-page";
	}
	}
	@GetMapping("/create")
	public String getControllerCreateProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "create-product";
	}
	@PostMapping("/create")
	public String postControllerCreateProduct(Product product, Model model) {
	if (product == null){
		model.addAttribute("package", "Nav ieguts aizpilditais produkts");
		return "show-error-page";
	}
	try {
		prodService.create(product.getTitle(), product.getDesc(), product.getCena(), product.getQuantity());
		return "redirect:/product/crud/all";
	}
	catch (Exception e){
		model.addAttribute("package", e.getMessage());
		return "show-error-page";
	}
	
	}
	
}


