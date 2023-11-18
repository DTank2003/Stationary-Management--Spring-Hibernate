package com.project.java.stationarymanagementsystem.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int adminid;
	
	@OneToMany(mappedBy = "orderid", cascade = CascadeType.ALL)
	private List<Order> order;
	
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String gender;
	@Column
	private String password;
	
	public Admin() {
		
	}
	
	public Admin(int admin_id, String username, String email, String gender, String password) {
		super();
		this.adminid = admin_id;
		this.username = username;
		this.email = email;
		this.gender = gender;
		this.password = password;
	}

	

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
