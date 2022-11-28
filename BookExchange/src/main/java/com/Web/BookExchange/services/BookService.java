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
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	UserRepository usRepo;
	
	public void save(Books book) {
		bookRepo.save(book);
	}
	
	public void saveById(Long bookId) {
		bookRepo.save(bookRepo.findById(bookId).get());
	}
	
	public List<Books> findAll(){
		return (List<Books>) bookRepo.findAll();
	}
	
	public List<Books> findExcept(long OID){
		List<Books> books1 = new ArrayList<>();
		for (Books book : bookRepo.findAll()) {
			if (!book.getOwnerId().equals(OID)) {
				books1.add(book);
			}
		}
		return books1;
	}
	
	public Books findById(long bookId) {
		Books book = bookRepo.findById(bookId).get();
		return book;
	}
	
public List<Books> searchBooks(String title, String author){
		
		List<Books> searchedBooks = new ArrayList<Books>();
		
		if (title != null && author == null) {
			searchedBooks = getByTitle(title);
		} else if (title == null && author != null) {
			searchedBooks = getByAuthor(author);
		} else if (title != null && author != null) {
			searchedBooks = getByTitleAndAuthor(title, author);
		} 
		
		return searchedBooks;
	}

			public List<Books> getByTitle(String title){
				List<Books> books1 = new ArrayList<>();
				for (Books book : bookRepo.findAll()) {
					if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
						books1.add(book);
					}
				}
				return books1;
			}
			public List<Books> getByTitleexcept(String title,long oid){
				List<Books> books1 = new ArrayList<>();
				for (Books book : bookRepo.findAll()) {
					if (book.getTitle().toLowerCase().contains(title.toLowerCase()) && !book.getOwnerId().equals(oid) && book.getStatus().equals(true)) {
						books1.add(book);
					}
				}
				return books1;
			}
			
			public List<Books> getByBorrowerId(long borrowerid){
				List<Books> books1 = new ArrayList<>();
				for (Books book : bookRepo.findAll()) {
					if(!book.getStatus()){
						if (book.getBorrowerId().equals(borrowerid))
							books1.add(book);
					}
				}
				return books1;
			}
			
			public List<Books> getByAuthor(String author){
				List<Books> books = new ArrayList<>();
				for (Books book : bookRepo.findAll()) {
					if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
						books.add(book);
					}
				}	
				return books;
			}
			
			public List<Books> getByTitleAndAuthor(String title, String author){
				List<Books> books = new ArrayList<>();
				for (Books book : bookRepo.findAll()) {
					if (book.getTitle().toLowerCase().contains(title.toLowerCase()) &&
						book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
						books.add(book);
					}
				}
				return books;
			}
			public void deleteById(long bookId) {
				bookRepo.deleteById(bookId);
			}
			
			public List<Books> getByOwnerId(Long OID){
				List<Books> books = new ArrayList<>();
				for (Books book : bookRepo.findAll()) {
					
					if(book.getOwnerId().equals(OID)) {
						books.add(book);
					}
				}
				
				return books;
				}
			
			public Long getsOwnerfromBook(Long bookId) {
				Books book = bookRepo.findById(bookId).get();
				Long oid=book.getOwnerId();
				return oid;
				
			}
			
			 
			}
				
			
