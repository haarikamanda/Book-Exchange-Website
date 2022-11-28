package com.Web.BookExchange.entity;
import java.time.LocalDate;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="BorrowedBook")

public class BorrowedBook {
	
	@Id
	@Column(name="id")
	private Long BorrowedBook;
	
	@Column(name="BookId")
	private Long BookId;
	
	@Column(name="BorrowerId")
	private Long BorrowerId;
	
	@Column(name="Extension")
	private boolean Extension=false;
	
	@Column(name="Pickupdet")
	private String PickupDetails;
	
	@Column(name="title")
	private String title;

	public Long getBorrowedBook() {
		return BorrowedBook;
	}

	public void setBorrowedBook(Long borrowedBook) {
		BorrowedBook = borrowedBook;
	}

	public Long getBookId() {
		return BookId;
	}

	public void setBookId(Long bookId) {
		BookId = bookId;
	}

	

	public boolean isExtension() {
		return Extension;
	}

	public void setExtension(boolean extension) {
		Extension = extension;
	}

	public String getPickupDetails() {
		return PickupDetails;
	}

	public void setPickupDetails(String pickupDetails) {
		PickupDetails = pickupDetails;
	}

	public Long getBorrowerId() {
		return BorrowerId;
	}

	public void setBorrowerId(Long borrowerId) {
		BorrowerId = borrowerId;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BorrowedBook(Long borrowedBook, Long bookId, Long borrowerId, boolean extension, String pickupDetails,
			String title) {
		super();
		BorrowedBook = borrowedBook;
		BookId = bookId;
		BorrowerId = borrowerId;
		Extension = extension;
		PickupDetails = pickupDetails;
		this.title = title;
	}

	public BorrowedBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
}
	
	


