package com.codingdojo.gotnxt.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.codingdojo.gotnxt.models.LoginUser;
import com.codingdojo.gotnxt.models.User;
import com.codingdojo.gotnxt.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User createUser(User user) {
		if(this.userRepo.getCount() == 0) {
			user.setAdminAccount(true);
		}
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return this.userRepo.save(user);
	}
	
	//Validate User for Duplicate email and password
	public void validate(User newUser, Errors errors) {
		//Password matching
		if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			errors.rejectValue("password", "Mismatch","Password does not match!!");
		}
		//Email Duplicate
		if(this.userRepo.findByUserName(newUser.getUserName())!=null) {
			errors.rejectValue("userName", "unique","Username is already Taken. Please choose another.");
		}
	}
	
	
	public User findByEmail(String email) {
		return this.userRepo.findByEmail(email);
	}
	
	public User findByUserName(String userName) {
		return this.userRepo.findByUserName(userName);
	}
	
	public User findUserById(Long id) {
		return this.userRepo.findById(id).orElse(null);
	}
	
	
	public boolean authenticateUser(LoginUser newLogin, Errors errors) {
		// Find User by...
		User loggedInUser = this.userRepo.findByUserName(newLogin.getUserName());
		
		
		if(loggedInUser == null || !BCrypt.checkpw(newLogin.getPassword(), loggedInUser.getPassword())) {
			errors.rejectValue("userName","invalidLogin", "UserName/Password does Not match our records.");
			errors.rejectValue("password","invalidLogin", "UserName/Password does Not match our records.");
			return false;
		
//		if(loggedInUser == null) {
//			errors.rejectValue("userName","invalidLogin", "UserName or Password doen Not match our records.");
//			return false;
//		} else {
//			if(!BCrypt.checkpw(newLogin.getPassword(), loggedInUser.getPassword())) {
//				errors.rejectValue("password","invalidLogin", "UserName or Password doen Not match our records.");
//				return false;
//			}
		}
		return true;
	}
}
