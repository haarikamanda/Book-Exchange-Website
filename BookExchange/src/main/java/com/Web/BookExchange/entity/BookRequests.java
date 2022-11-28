package com.Web.BookExchange.entity;
import java.time.LocalDate;
//import java.util.*;
//import java.time.LocalDateTime;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Table(name="BookRequests")
public class BookRequests {
	@Id
	@Column(name="Id")
	private long BookRequest;
	
	@Column(name="RequestId")
	private long RequestId;
	
	@Column(name="bookId")
	private Long bookId;

	@Column(name="Retdate")
	private LocalDate Retdate;
	
	@Column(name="title")
	private String title;

	@Column(name="Requsername")
	private String Requsername;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRequsername() {
		return Requsername;
	}

	public void setRequsername(String requsername) {
		Requsername = requsername;
	}

	public long getBookRequest() {
		return BookRequest;
	}

	public void setBookRequest(long bookRequest) {
		BookRequest = bookRequest;
	}

	public long getRequestId() {
		return RequestId;
	}

	public void setRequestId(long requestId) {
		RequestId = requestId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public LocalDate getRetdate() {
		return Retdate;
	}

	public void setRetdate(LocalDate retdate) {
		Retdate = retdate;
	}

	public BookRequests() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookRequests(long bookRequest, long requestId, Long bookId, LocalDate retdate, String title,
			String requsername) {
		super();
		BookRequest = bookRequest;
		RequestId = requestId;
		this.bookId = bookId;
		Retdate = retdate;
		this.title = title;
		Requsername = requsername;
	}

	
	
	

}
