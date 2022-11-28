package com.Web.BookExchange.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.Web.BookExchange.Repository.*;

@Controller
public class HomeCon {
	
	@Autowired
	UserRepository Userrep;
	
	@RequestMapping("/")
	public String doLogin( Model model, HttpSession session) {
		
		UserDetails principal = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();	  
		Collection<? extends GrantedAuthority> role = new ArrayList<>();
		role = principal.getAuthorities();
		
		//if (role.toString().equals("[ROLE_ADMIN]")){
			//return "redirect:/admin";
		//} 
		 //else {
			return "redirect:/user";
		//}
		//NormalUser t = new NormalUser((long)1,"ROLE_USER","sam123","tiger","Sam Harris","123@gmail.com","9686825381", null, null);
		
		//Userrep.save(t);
		
		//return "Success";
		
	}

}
