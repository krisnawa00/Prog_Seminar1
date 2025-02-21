package lv.venta.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.model.Product;

@Controller
public class MFC {

	

	private ArrayList<Product> allProducts = new ArrayList<>(Arrays.asList(
			new Product("Gurķis", "Zaļš", 1.99f, 7),
			new Product("Arbūzs", "Salds", 5.99f, 2),
			new Product("Burkāns", "Veselīgs", 0.45f, 5)));

		@GetMapping("/simple")
		public String getControllerSimple() 
		{
			System.out.println("ir izsaukusies simple funkcija");
			return "simple_page";
		}
		@GetMapping("/simple2")
		public String getControllerSimple2(Model model) 
		{
			System.out.println("ir izsaukusies simple funkcija");
			Random rand = new Random();
			String data = "Kristers: " + rand.nextInt(0,100);
			
			model.addAttribute("package", data);
			return "simple_page2";
		}
		@GetMapping("/navsimple")
		public String getControllerGetProduct(Model model) {
			
		Product testProduct = new Product ("Tomats", "Garsigs", 0.99f, 5);
		model.addAttribute("package", testProduct);
		return "how-one-PRODUCT-PAGE";
		}

		@GetMapping("/productall")
		public String getControllerGetManyProducts(Model model) {
			model.addAttribute("package", allProducts);
			return "show-all-product-page";
		}
		
}
