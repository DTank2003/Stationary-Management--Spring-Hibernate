package com.project.java.stationarymanagementsystem.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.java.stationarymanagementsystem.entities.Item;
import com.project.java.stationarymanagementsystem.entities.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class OrderDAO {

	private EntityManager entityManager;
	
	@Autowired
	public OrderDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	public List<Order> getOrders() {
		Session currentSession = entityManager.unwrap(Session.class);
		TypedQuery<Order> theQuery =
				currentSession.createQuery("from Order", Order.class);
		List<Order> orders = theQuery.getResultList();
		currentSession.close();
		return orders;
	}
	
	public Order getOrderById(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Order order = currentSession.get(Order.class, id);
		currentSession.close();
		return order;
	}
	
	@Transactional
	public void addOrder(final Order order) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(order);
		currentSession.close();
	}

	@Transactional
	public void updateOrder(final Order order) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(order);
		currentSession.close();
	}

	@Transactional
	public void deleteOrder(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Order order = currentSession.get(Order.class, id);
		currentSession.remove(order);
		currentSession.close();	
	}
}
