package com.codingdojo.gotnxt.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.gotnxt.models.LoginUser;
import com.codingdojo.gotnxt.models.User;
import com.codingdojo.gotnxt.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServ;
	
//	Maybe for Landing page. 
//	@GetMapping("/")
//	public String index() {
//		return "index.jsp";
//	}
	
	@GetMapping("/")
	public String login(@ModelAttribute("loginUser") User loginUser) {
		return "login.jsp";
	}
	
	@GetMapping("/reg")
	public String reg(@ModelAttribute("user") User user) {
		return "reg.jsp";
	}
	
	@PostMapping("/login")
	public String confLogin(@Valid @ModelAttribute("loginUser") LoginUser loginUser,
			BindingResult result,
			HttpSession session
			) {
		this.userServ.authenticateUser(loginUser, result);
		if(result.hasErrors()) {
			return "login.jsp";			
		}else {
			User foundUser = this.userServ.findByUserName(loginUser.getUserName());
			session.setAttribute("userId", foundUser.getId());
			return "redirect:/dashboard";
		}
	}
	
	@PostMapping("/reg")
	public String ConfReg(@Valid @ModelAttribute("user") User user,
			BindingResult result,
			HttpSession session) {
		this.userServ.validate(user, result);
		if(result.hasErrors()) {
			return "reg.jsp";
		}else {
			User regUser = this.userServ.createUser(user);
			session.setAttribute("userId", regUser.getId());
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/logout")
	public String LogOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
