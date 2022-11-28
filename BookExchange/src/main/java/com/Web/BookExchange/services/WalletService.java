package com.Web.BookExchange.services;
//import java.util.ArrayList; 
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Web.BookExchange.Repository.WalletRepository;
//import com.Web.BookExchange.entity.NormalUser;
//import com.Web.BookExchange.entity.NormalUser;
import com.Web.BookExchange.entity.Wallet;

@Service
public class WalletService {
	
	@Autowired
	WalletRepository walletRepo;
	
	

	public void save(Wallet wal) {
		walletRepo.save(wal);
	}
	public Wallet findById(long id) {
		Wallet wal = walletRepo.findById(id).get();
		return wal;
	}

}
