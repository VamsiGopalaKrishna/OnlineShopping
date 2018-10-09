package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.New1.ProductDao;

@Controller
public class HomeController {
	@Autowired
	private ProductDao productDao;
	
	public HomeController(){
		System.out.println("HomeController bean is instantiated");
	}

	@RequestMapping(value={"/","/home"})
	public String homePage(HttpSession session){
		session.setAttribute("categories", productDao.getAllCategories());
		return "home";
	}
	@RequestMapping(value="/AboutUs")
	public String AboutUs(){
		return "AboutUs";
	}
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	@RequestMapping(value="/loginerror")
	public String loginFailed(Model model){
		model.addAttribute("error","Invalid credentials..");
		return "login";
	}
	@RequestMapping(value="/logout")
	public String logout(Model model){
		model.addAttribute("msg","Loggedout successfully..");
		return "login";
		
	}
}
