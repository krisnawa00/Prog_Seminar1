package lv.venta.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MFC {

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
		
		
}
