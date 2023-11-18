package com.project.java.stationarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.java.stationarymanagementsystem.entities.Item;
import com.project.java.stationarymanagementsystem.entities.Order;
import com.project.java.stationarymanagementsystem.repository.OrderDAO;


@Service
public class OrderService {

	@Autowired
    private OrderDAO orderDAO;

	public List<Order> getOrders() {
		return orderDAO.getOrders();
	}
	
	public Order getOrderById(final int id) {
		return orderDAO.getOrderById(id);
	}
	
	public void addOrder(final Order order) {
		orderDAO.addOrder(order);
	}

	public void updateOrder(final Order order) {
		orderDAO.updateOrder(order);
	}

	public void deleteOrder(final int id) {
		orderDAO.deleteOrder(id);
	}
	
}
