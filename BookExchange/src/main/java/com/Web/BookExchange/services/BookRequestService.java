package com.Web.BookExchange.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.Web.BookExchange.Repository.*;
import com.Web.BookExchange.entity.*;


@Service
public class BookRequestService {
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	UserRepository usRepo;
	
	@Autowired
	BookRequestRepository reqrepo;
	

	public void save(BookRequests bookreq) {
		reqrepo.save(bookreq);
	}
	
	public BookRequests findById(long ReqId) {
		BookRequests bookreq = reqrepo.findById(ReqId).get();
		return bookreq;
	}
	
	}


