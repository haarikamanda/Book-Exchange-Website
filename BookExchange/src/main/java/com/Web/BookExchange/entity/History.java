package com.Web.BookExchange.entity;

import java.util.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="History")

public class History {
	
	@Id
	@Column(name="id")
	private String bookId;
	
	@Column(name="bookName")
	private String bookName;
	
	@Column(name="ownerId")
	private String ownerId;
	
	@Column(name="borrowerId")
	private String borrowerId;
	
	@Column(name="issueDate")
	private Date issueDate;
	
	@Column(name="dueDate")
	private Date dueDate;
	
	@Column(name="returnDate")
	private Date returnDate;


	public String getBookId() {
		return bookId;
	}


	public void setBookId(String bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}


	public String getBorrowerId() {
		return borrowerId;
	}


	public void setBorrowerId(String borrowerId) {
		this.borrowerId = borrowerId;
	}


	public Date getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}


	public Date getDueDate() {
		return dueDate;
	}


	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	public Date getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}


	public History(String bookId, String bookName, String ownerId, String borrowerId, Date issueDate, Date dueDate,
			Date returnDate) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.ownerId = ownerId;
		this.borrowerId = borrowerId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
	}


	public History() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
