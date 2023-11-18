package com.project.java.stationarymanagementsystem.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int stockid;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "itemid")
	private Item itemid;
	
	@Column
	private int quantityavailable;

	public Stock() {
	}
	
	public Stock(int stock_id, Item item_id, int quantity_available) {
		super();
		this.stockid = stock_id;
		this.itemid = item_id;
		this.quantityavailable = quantity_available;
	}

	public int getStockid() {
		return stockid;
	}

	public void setStockid(int stockid) {
		this.stockid = stockid;
	}

	public Item getItemid() {
		return itemid;
	}

	public void setItemid(Item itemid) {
		this.itemid = itemid;
	}

	public int getQuantityavailable() {
		return quantityavailable;
	}

	public void setQuantityavailable(int quantityavailable) {
		this.quantityavailable = quantityavailable;
	}
	
}
