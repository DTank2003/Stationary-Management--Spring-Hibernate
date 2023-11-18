package com.project.java.stationarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.java.stationarymanagementsystem.entities.Item;
import com.project.java.stationarymanagementsystem.repository.ItemDAO;


@Service
public class ItemService {
	
	@Autowired
	private ItemDAO itemDAO;
	
	public Item getItemById(final int id) {
		return itemDAO.getItemById(id);
	}
	
	public Item getItemByItemname(final String name) {
		return itemDAO.getItemByItemname(name);
	}

	public List<Item> getItems() {
		return itemDAO.getItems();
	}

	public void addItem(final Item item) {
		itemDAO.addItem(item);
	}

	public void updateItem(final Item item) {
		itemDAO.updateItem(item);
	}

	public void deleteItem(final int id) {
		itemDAO.deleteItem(id);
	}
}
