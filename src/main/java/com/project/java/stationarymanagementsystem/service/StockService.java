package com.project.java.stationarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.java.stationarymanagementsystem.entities.Stock;
import com.project.java.stationarymanagementsystem.repository.StockDAO;


@Service
public class StockService {
	
	@Autowired
	private StockDAO stockDAO;
	
	public Stock getStockById(final int id) {
		return stockDAO.getStockById(id);
	}

	public List<Stock> getStocks() {
		return stockDAO.getStocks();
	}
	
	public void addStock(final Stock stock) {
		stockDAO.addStock(stock);
	}

	public void updateStock(final Stock stock) {
		stockDAO.updateStock(stock);
	}

	public void deleteStock(final int id) {
		stockDAO.deleteStock(id);
	}
}
