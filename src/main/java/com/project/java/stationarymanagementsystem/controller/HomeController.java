package com.project.java.stationarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.java.stationarymanagementsystem.entities.Admin;
import com.project.java.stationarymanagementsystem.entities.Item;
import com.project.java.stationarymanagementsystem.entities.Order;
import com.project.java.stationarymanagementsystem.service.AdminService;
import com.project.java.stationarymanagementsystem.service.ItemService;
import com.project.java.stationarymanagementsystem.service.OrderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	ItemService itemService;
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/")
    public String showPage(HttpServletRequest request, ModelMap itemModel) {
		List<Item> items = itemService.getItems();
		itemModel.addAttribute("items", items);
		return "cust_homepage";
    }
	
	@GetMapping("/items")
	public String getItems(ModelMap itemModel) {
		List<Item> items = itemService.getItems();
		itemModel.addAttribute("items", items);
		return "items";
	}
	
    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	session.invalidate();
    	return "redirect:/";
    }
	
}
