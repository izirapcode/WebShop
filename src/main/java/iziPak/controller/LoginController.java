package iziPak.controller;

import iziPak.components.Cart;
import iziPak.entity.Account;
import iziPak.service.AccountService;
import iziPak.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class LoginController {

	@Autowired
	ProductService productService;


	
	@RequestMapping("/")
	public String showHome(Model model) {
		model.addAttribute("products",productService.getProducts());
		return "home";
	}
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		return "fancy-login";
	}

	
	@GetMapping("/access-denied")
	public String showAccessDenied() {

		return "access-denied";
		
	}




}
