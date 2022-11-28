package com.Web.BookExchange.services;

import java.util.ArrayList; 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Web.BookExchange.Repository.UserRepository;
import com.Web.BookExchange.entity.NormalUser;
@Service
public class UserService {

	@Autowired
	UserRepository usRepo;
	
	public void save(NormalUser user) {
		usRepo.save(user);
	}
	
	public void saveById(Long userId) {
		NormalUser user = usRepo.findById(userId).get();
		usRepo.save(user);
	}
	
	public NormalUser findById(long id) {
		NormalUser user = usRepo.findById(id).get();
		return user;
	}
	
	public List<NormalUser> findAll(){
		return (List<NormalUser>) usRepo.findAll();
	}
	
	public List<NormalUser> getByFirstName(String Name){
		List<NormalUser> users = new ArrayList<NormalUser>();
		for (NormalUser user : usRepo.findAll()) {
			if (user.getName().toLowerCase().contains(Name.toLowerCase())) {
				users.add(user);
			}
		}
		return users;
	}
	
}