package com.Web.BookExchange.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.Web.BookExchange.entity.Books;
import com.Web.BookExchange.entity.BorrowedBook;
import com.Web.BookExchange.Repository.BorrowedBookRepository;

@Service
public class BorrowedBookService {
	@Autowired
	BorrowedBookRepository borbookrepo;
	
	public void save(BorrowedBook bor) {
		borbookrepo.save(bor);
	}
	
	public List<BorrowedBook>  getbyBorrowerId(long borid) {
		List<BorrowedBook> allborrowed= new ArrayList<>();
		for (BorrowedBook book : borbookrepo.findAll()) {
			if(book.getBorrowerId().equals(borid))
				allborrowed.add(book);
			}
	 return allborrowed;
	}
}
