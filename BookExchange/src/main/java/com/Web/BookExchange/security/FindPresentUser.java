package com.Web.BookExchange.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.Web.BookExchange.entity.NormalUser;
import com.Web.BookExchange.services.UserService;
import org.springframework.security.core.Authentication;


@Service
public class FindPresentUser {
	@Autowired
	UserService usService;
	public long getCurrentUserId() {
		
		//UserDetails details = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//String username = details.getUsername();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		long userId = -1;
		for (NormalUser user : usService.findAll()) {
			if (user.getUserName().equals(currentPrincipalName)) {
				userId = user.getUserId();
				break;		
			}
		}
		return userId;
	}
	
	public NormalUser getCurrentUser() {
		NormalUser currentUser = usService.findById(getCurrentUserId());
		return currentUser;
	}
	
	
	}


