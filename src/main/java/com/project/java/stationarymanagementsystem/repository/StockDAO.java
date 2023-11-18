package com.project.java.stationarymanagementsystem.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.project.java.stationarymanagementsystem.entities.Stock;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StockDAO {
	private EntityManager entityManager;
	
	@Autowired
	public StockDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public Stock getStockById(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Stock stock = currentSession.get(Stock.class, id);
		currentSession.close();
		return stock;
	}

	public List<Stock> getStocks() {
		Session currentSession = entityManager.unwrap(Session.class);
		TypedQuery<Stock> theQuery =
				currentSession.createQuery("from Stock", Stock.class);
		List<Stock> stocks = theQuery.getResultList();
		currentSession.close();
		return stocks;
	}
	@Transactional
	public void addStock(final Stock stock) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(stock);
		currentSession.close();
	}

	@Transactional
	public void updateStock(final Stock stock) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(stock);
		currentSession.close();
	}

	@Transactional
	public void deleteStock(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Stock stock = currentSession.get(Stock.class, id);
		currentSession.remove(stock);
		currentSession.close();
	}
}
