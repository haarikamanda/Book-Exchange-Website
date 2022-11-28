package com.Web.BookExchange.entity;
//import java.util.*;
import java.time.LocalDate;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="Books")

public class Books {
	
	@Id
	@Column(name="id")
	private Long bookId;
	
	
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	@Column(name="title")
	private String title;
	
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="ownerId")
	private Long ownerId;
	
	@Column(name="borrowerId")
	private Long borrowerId;
	
	@Column(name="issueDate")
	private LocalDate issueDate;
	
	@Column(name="dueDate")
	private LocalDate dueDate;
	
	@Column(name="returnDate")
	private LocalDate returnDate;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="description")
	private String description;
	
	@Column(name="author")
	private String author;
	
	@Column(name="publisher")
	private String publisher;
	
	@Column(name="edition")
	private String edition;
	
	@Column(name="year")
	private String year;
	
	
	public String getName() {
		return title;
	}
	public void setName(String name) {
		this.title = name;
	}
	
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public Long getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(Long borrowerId) {
		this.borrowerId = borrowerId;
	}
	
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
	public Books(Long bookId, String title, Long ownerId, Long borrowerId, LocalDate issueDate, LocalDate dueDate,
			LocalDate returnDate, Boolean status, String description, String author, String publisher, String edition,
			String year) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.ownerId = ownerId;
		this.borrowerId = borrowerId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.status = status;
		this.description = description;
		this.author = author;
		this.publisher = publisher;
		this.edition = edition;
		this.year = year;
	}
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}