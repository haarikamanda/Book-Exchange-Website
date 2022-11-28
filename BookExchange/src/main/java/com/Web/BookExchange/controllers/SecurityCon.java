package com.Web.BookExchange.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Web.BookExchange.Repository.*;
import com.Web.BookExchange.entity.NormalUser;
import java.util.Random;

@Controller
public class SecurityCon {
	
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	@Autowired
	UserRepository Userrep;
	
	@GetMapping(value="/login")
	public String login() {
		return "login.html";
	}
	@GetMapping(value="/logout")
	public String logout() {
		return "logout.html";
	}
	
	@GetMapping(value="/register")
	public String register(Model model) {
		model.addAttribute("newAccount", new NormalUser());
		return "register.html";
	}
	
	@PostMapping(value="/register/save")
	public String saveNewAccount(NormalUser account) {
		account.setPassword(pwEncoder.encode(account.getPassword()));
		account.setenabled(true);
		account.setRole("ROLE_USER");
		Random rd = new Random();
		account.setUserId(rd.nextLong());
		Userrep.save(account);
		return "redirect:/register/accountcreated";
	}
	
	@GetMapping(value="/register/accountcreated")
	public String accountCreated() {
		return "accountcreated.html";
	}	

}
