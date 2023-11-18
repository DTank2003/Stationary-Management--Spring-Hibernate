package com.project.java.stationarymanagementsystem.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "order1")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int orderid;
	
	@ManyToOne
	@JoinColumn(name = "adminid")
	private Admin adminid;
	
	@ManyToOne
	@JoinColumn(name = "itemname")
	private Item itemname;

	@Column
	private String status;
	
	public Order() {
	}
	
	public Order(int order_id, Admin admin_id, Item item_name, String status) {
		super();
		this.orderid = order_id;
		this.adminid = admin_id;
		this.itemname = item_name;
		this.status = status;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	
	public Admin getAdminid() {
		return adminid;
	}

	public void setAdminid(Admin adminid) {
		this.adminid = adminid;
	}

	public Item getItemname() {
		return itemname;
	}

	public void setItemname(Item itemname) {
		this.itemname = itemname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
