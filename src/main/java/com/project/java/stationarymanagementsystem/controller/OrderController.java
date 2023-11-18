package com.project.java.stationarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
    private OrderService orderService;
	
	@Autowired
	private ItemService itemService;

	@GetMapping("/orders")
	public String getOrders(ModelMap orderModel) {
		List<Order> orders = orderService.getOrders();
		orderModel.addAttribute("orders", orders);
		return "orders";
	}

	@GetMapping("addOrder")
	public String addPage() {
		return "addOrder";
		
	}

	@PostMapping("/add/order")
	public String addOrder(HttpServletRequest request, @RequestParam(value = "itemid") String itemid, @RequestParam(value = "status") String status,ModelMap orderModel) {
		HttpSession session = request.getSession();
		Order order = new Order();
		order.setAdminid(adminService.getAdmin((Integer)session.getAttribute("id")));
		order.setItemname(itemService.getItemById(Integer.parseInt(itemid)));
		order.setStatus(status);
		orderService.addOrder(order);
		orderModel.addAttribute("msg", "Item added successfully");
		List<Order> orders = orderService.getOrders();
		orderModel.addAttribute("orders", orders);
		return "redirect:/order/addOrder";
	}

	@GetMapping("update/order/{id}")
	public String updatePage(@PathVariable("id") int id, ModelMap orderModel) {
		orderModel.addAttribute("id", id);
		Order order = orderService.getOrderById(id);
		orderModel.addAttribute("order", order);
		return "updateOrder";
	}

	@PostMapping("/update/order")
	public String updateOrder(@RequestParam(value = "orderid") String orderid,
			@RequestParam(value = "status", required = true) String status, ModelMap orderModel) {
		Order order = orderService.getOrderById(Integer.parseInt(orderid));
		order.setStatus(status);
		orderService.updateOrder(order);
		List<Order> orders = orderService.getOrders();
		orderModel.addAttribute("orders", orders);
		orderModel.addAttribute("id", orderid);
		orderModel.addAttribute("msg", "Order updated successfully");
		return "redirect:/order/orders";
	}

	@GetMapping("/delete/order/{id}")
	public String deleteOrder(@PathVariable int id, ModelMap orderModel) {
		orderService.deleteOrder(id);
		List<Order> orders = orderService.getOrders();
		orderModel.addAttribute("orders", orders);
		orderModel.addAttribute("msg", "Order deleted successfully");
		return "redirect:/order/orders";
	}
	
}
