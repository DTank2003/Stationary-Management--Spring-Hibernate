package com.project.java.stationarymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.java.stationarymanagementsystem.entities.Admin;
import com.project.java.stationarymanagementsystem.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@RequestMapping("")
    public String showPage(HttpServletRequest request,ModelMap model) {
        HttpSession session = request.getSession();
        if(session.getAttribute("role") != null) {
            if(!session.getAttribute("role").equals("admin"))return "redirect:/";
        }
        if(session.getAttribute("success") != null) {
            model.addAttribute("success",session.getAttribute("success"));
            session.removeAttribute("success");
        }
        return "cust_homepage";
    }
	
	@PostMapping("login")
    public String checkAdmin(@RequestParam(value = "email", required = true) String email,
                               @RequestParam(value = "password", required = true) String password,HttpServletRequest request, ModelMap model){
        
        if(!adminService.login(email,password)){
        	model.addAttribute("error", "Wrong credentials !!");
        	return "cust_login";
        }
        Admin admin = adminService.getAdminByEmail(email);
        HttpSession session = request.getSession();
        session.setAttribute("role", "admin");
        session.setAttribute("id",admin.getAdminid());
        session.setAttribute("success","Login SuccessFull,Welcome");
        return "redirect:/";
    }
    
    @GetMapping("login")
    public String loginGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("role") != null) {
            return "redirect:/";
        }
        session.invalidate();
        return "cust_login";
    }
    
    @PostMapping("signup")
    public String registerAdmin(@ModelAttribute("admin") Admin admin, ModelMap model) {
    	adminService.addAdmin(admin);
//    	List<Admin> admins = adminService.getAdmins();
//    	model.addAttribute("admins", admins);
    	model.addAttribute("success","Account Created Successfully");
    	return "cust_login";
    }
    @GetMapping("signup")
    public String RegisterGet(ModelMap model) {
    	Admin cust = new Admin();
    	model.addAttribute("admin", cust);
    	return "cust_signup";
    }
	
}
