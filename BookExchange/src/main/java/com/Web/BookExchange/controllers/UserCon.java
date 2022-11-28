package com.Web.BookExchange.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Web.BookExchange.entity.*;
import com.Web.BookExchange.services.*;
import com.Web.BookExchange.security.FindPresentUser;
import com.Web.BookExchange.Repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

@Controller
@RequestMapping("/user")
public class UserCon {
	
	public final Logger logger = Logger.getLogger(UserCon.class);


	@Autowired
	UserService usService;
	
	@Autowired
	UserRepository usRepo;
	
	@Autowired
	BookService bookService;
	@Autowired
	BookRequestService reqService;
	
	@Autowired
	BookRepository Bookrepo;
	
	@Autowired
	BookRequestRepository Reqrepo;
	@Autowired
	FindPresentUser currentUserFinder;
	
	@Autowired
	WalletRepository walletRepo;
	
	@Autowired
	WalletService walletService;
	
	@Autowired
	BorrowedBookService borService;
	
	@Autowired
	BorrowedBookRepository borRepo;
	
	@GetMapping
	public String userHome(Model model) {
		
		NormalUser currentUser = currentUserFinder.getCurrentUser();
		if(!walletRepo.existsById(currentUser.getUserId())) {
		Wallet newwallet=new Wallet();
		newwallet.setAmount(0);
		newwallet.setUserId(currentUser.getUserId());
		walletService.save(newwallet);
		}
		model.addAttribute("currentUser",currentUser);
		return "userhome.html";
	}
	
	@GetMapping(value="/addbooks")
	public String addBooks(Model model) {
		
		NormalUser currentUser = currentUserFinder.getCurrentUser();
		model.addAttribute("newBook", new Books());
		return "addbook.html";
	}
	
	@PostMapping(value="/addbooks/save")
	public String saveNewBook(Books newBook) {
		logger.info("Entering into function");

		NormalUser currentUser = currentUserFinder.getCurrentUser();
		logger.info("Finding user");

		newBook.setStatus(true);
		double a=Math.random()*Math.pow(10,6);
		long b=(long)a;
		newBook.setBookId(b);
		newBook.setOwnerId(currentUser.getUserId());
		logger.info("Saving user");
		Bookrepo.save(newBook);
		return "redirect:/user/addbooks/bookadded";
	}
	
	@GetMapping(value="/addbooks/bookadded")
	public String accountCreated() {
		return "bookaddedsuccess.html";
	}	
	
	
	
	  @GetMapping(value="/yourbooks") public String delBooks(Model model) {
	  
	  NormalUser currentUser = currentUserFinder.getCurrentUser(); 
	  List<Books> books = bookService.getByOwnerId(currentUser.getUserId());
	  model.addAttribute("books", books);
	  
	  return "yourbooks.html"; 
	  }
	 
		/*
		 * @PostMapping(value="/deletebook/complete") public void doBook(Long selBook){
		 * 
		 * Bookrepo.deleteById(selBook);
		 * 
		 * }
		 */
	  @RequestMapping(value = "/deletebook/complete", method = RequestMethod.GET)
	  public String handleDeleteUser(@RequestParam(name="bookId")Long bookId) {
		 
		  Bookrepo.deleteById(bookId);
	      return "redirect:/user/deletedbook";
	  }
	  
	  @GetMapping(value="/deletedbook")
		public String successdelete() {
			return "bookdelsuccess.html";
		}	
	  
	  @GetMapping(value="/browsebooks")
		public String BrowseBooks(@RequestParam (required=false) String title,Model model) {
		  NormalUser currentUser = currentUserFinder.getCurrentUser(); 

		  List<Books> bookst;
		  if(title==null) {
			  //bookst=bookService.findAll();
			  bookst=bookService.findExcept(currentUser.getUserId());
		  }
		  else {
			  //bookst=bookService.getByTitle(title);
			  bookst=bookService.getByTitleexcept(title,currentUser.getUserId());
		  }
		  
		model.addAttribute("books", bookst);
		model.addAttribute("title", title);
		  
			return "browsebooks.html";
		}
	  
		/*
		 * @RequestMapping(value="/browsebook/{bookId}//select",method=RequestMethod.
		 * GET) public String SelectBook(@RequestParam(name="bookId")Long bookId) {
		 * 
		 * return "EnterDuration.html"; }
		 */
	  @RequestMapping(value = "/browsebooks/request", method = RequestMethod.GET)
	  public String AddBookRequest(@RequestParam(name="bookId")Long bookId,Model model) {
		 NormalUser currentUser = currentUserFinder.getCurrentUser();
		 Wallet wal= walletService.findById(currentUser.getUserId());
		  if(wal.getAmount()==0)
			  return "rejected.html";
		  //Bookrepo.deleteById(bookId);
		  model.addAttribute("RequestObj",new BookRequests());
		  model.addAttribute("storedId",bookId);
	      return "requestdate.html";
	  }
	  
	  @RequestMapping(value = "/browsebooks/requestsave", method = RequestMethod.GET)
	  public String AddBookDate(@RequestParam(name="bookId")Long bookId,@RequestParam(name="date")Integer date,BookRequests newReq) {
		  
		  NormalUser currentUser = currentUserFinder.getCurrentUser();
		  newReq.setBookId(bookId);
		  newReq.setRequestId(currentUser.getUserId());
		  double a=Math.random()*Math.pow(10,6);
		  long b=(long)a;
		  newReq.setBookRequest(b);
		  LocalDate localDate = LocalDate.now();
		  localDate = localDate.plusDays(date);
		  newReq.setRetdate(localDate);
		  newReq.setRequsername(currentUser.getUserName());
		  Books book1=bookService.findById(bookId);
		  newReq.setTitle(book1.getTitle());
		  Reqrepo.save(newReq);
	  return "redirect:/user";
	  }
	  
	  @GetMapping(value="/notifications")
	  public String notifications(Model model){
		  NormalUser currentUser = currentUserFinder.getCurrentUser(); 
		  List<Books> books = bookService.getByOwnerId(currentUser.getUserId());
		  List<BookRequests> reqs=Reqrepo.findAll();
		  List<BookRequests> Ownerreq= new ArrayList<>();
		  for (Books book : books) {
			  for(BookRequests req: reqs) {
				  if(book.getBookId().equals(req.getBookId()))
				  {
					  Ownerreq.add(req);
				  }
				  
			  }
			  
		  }
		  logger.info("Entering into function1");
		  List<BorrowedBook> allbor=borService.getbyBorrowerId(currentUser.getUserId());
		  logger.info("Entering into function2");
		  for(BorrowedBook book : allbor) {
			  if(book.getPickupDetails()==null)
				  allbor.remove(book);
		  }
		  logger.info("Entering into function3");
		  model.addAttribute("Ownerreq",Ownerreq);
		  model.addAttribute("BorrowedBook",allbor);
		  logger.info("Entering into function4");
		  return "notifications.html";
	  }
	  
	  
	  @GetMapping(value="/notifications/completereq")
	  public String comprequest(@RequestParam(name="reqid")Long reqid,Model model) {
		  BookRequests fulreq=reqService.findById(reqid);
		  NormalUser currentUser = currentUserFinder.getCurrentUser(); 
		  Books book=bookService.findById(fulreq.getBookId());
		  book.setBorrowerId(fulreq.getRequestId());
		  book.setDueDate(fulreq.getRetdate());
		  LocalDate localDate = LocalDate.now();
		  book.setIssueDate(localDate);
		  book.setStatus(false);
		  
		  BorrowedBook bor= new BorrowedBook();
		  bor.setBookId(book.getBookId());
		  bor.setBorrowerId(book.getBorrowerId());
		  bor.setExtension(false);
		  double a=Math.random()*Math.pow(10,6);
			long b=(long)a;
		  bor.setBorrowedBook(b);
		  bor.setTitle(book.getTitle());
		  borService.save(bor);
		  bookService.save(book);
		  Reqrepo.deleteById(reqid);
		  
		  model.addAttribute("borrowedbook",bor);
		  return "redirect:/user";
	  }
	  
	  @GetMapping(value="/done")
	  public String savepickup(BorrowedBook bor) {
		  borService.save(bor);
		  return "redirect:/user";
		 
	  }
	  
	  
	  @GetMapping(value="/wallet")
	  public String walletstatus(@RequestParam(required=false)String amount,Model model) {
		  
		NormalUser currentUser = currentUserFinder.getCurrentUser();
		  Wallet currwall=walletService.findById(currentUser.getUserId());
		  String message = "";
		  try{
		  if(amount!=null) {
			  int amount1 = Integer.parseInt(amount);
			  currwall.setAmount(currwall.getAmount()+amount1);
			  walletService.save(currwall);
		  }
		  }catch(Exception e){
			message = "Please enter a valid amount";
		  }
		  
		 model.addAttribute("currwall", currwall);
		 model.addAttribute("amount",amount);
		 model.addAttribute("message", message);
		  return "walletpage.html";
	  }
	  
	  @GetMapping(value="/borrowedbooks")
	  public String borrowedbooks(Model model) {
	   NormalUser currentUser = currentUserFinder.getCurrentUser();
	   List<Books> books=bookService.getByBorrowerId(currentUser.getUserId());
	   model.addAttribute("books", books);
	   return "borrowedbooks.html";
	  }
	  
	  
	  @GetMapping(value="/borrowedbooks/return")
		public String returnbooks(@RequestParam(name="bookId")Long bookId){
			  Books book = Bookrepo.getById(bookId);
			  NormalUser currentUser = currentUserFinder.getCurrentUser();
			  if(book.getDueDate().compareTo(LocalDate.now())> 0){
				  long delay = book.getDueDate().compareTo(LocalDate.now());
				  System.out.println(delay);
				  long penalty = delay*10;
				  Wallet wallet = walletRepo.findByUserId(currentUser.getUserId());
				  wallet.setAmount(wallet.getAmount() - penalty);
				  walletRepo.save(wallet);
			  }
			  book.setBorrowerId(null);
			  book.setDueDate(null);
			  book.setIssueDate(null);
			  book.setStatus(true);
			  Bookrepo.save(book);
			  //BorrowedBook tempBook=borRepo.findByBorrowerId(currentUser.getUserId());
			  //borRepo.delete(tempBook);
			  return("redirect:/user");
		  }
		/*
		 * @GetMapping(value="/borrowedbooks") public String borrowedbooks(Model model)
		 * {
		 * 
		 * NormalUser currentUser = currentUserFinder.getCurrentUser(); List<Books>
		 * books=bookService.getByBorrowerId(currentUser.getUserId());
		 * model.addAttribute("books", books); return "borrowedbooks.html";
		 * 
		 * }
		 */
	  
	  @GetMapping(value="/adminservice")
	  public String adminfunc(){
		  return "adminpage.html";
		  
	  }
	  
	  @GetMapping(value="/adminservice/deleteuser")
	  public String deluser(Model model) {
		  
		  List <NormalUser> alluser=usService.findAll();
		  model.addAttribute("alluser", alluser);
		  return "deleteuserpage.html";
	  }
	  @RequestMapping(value = "/adminservice/deleteuser/done", method = RequestMethod.GET)
	  public String handledelUser(@RequestParam(name="userId")Long userId) {
		 
		  List <BookRequests> reqall=Reqrepo.findAll();
		  BookRequests temp = new BookRequests();
		  for (BookRequests requests : reqall) {
		  if(requests.getRequestId()==userId) {
			  temp=requests;
			  
		  }
		  }
		  Reqrepo.delete(temp);
		  usRepo.deleteById(userId);
	      return "redirect:/user/adminservice";
	  }
	    
}
