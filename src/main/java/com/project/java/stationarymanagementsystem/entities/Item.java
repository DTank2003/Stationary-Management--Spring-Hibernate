package com.project.java.stationarymanagementsystem.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int itemid;
	
	@OneToOne(mappedBy = "itemid")
	private Stock stockid;
	
	@OneToMany(mappedBy = "orderid", cascade = CascadeType.ALL)
	private List<Order> order;
	
	@Column
	private String itemname;
	
	@Column
	private String manufacturer;
	
	@Column
	private int price;

	public Item() {
	}
	
	public Item(int itemid, String itemname, String manufacturer, int price) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.manufacturer = manufacturer;
		this.price = price;
	}
	

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public Stock getStockid() {
		return stockid;
	}

	public void setStockid(Stock stockid) {
		this.stockid = stockid;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
