package com.project.java.stationarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.java.stationarymanagementsystem.entities.Admin;
import com.project.java.stationarymanagementsystem.repository.AdminDAO;

@Service
public class AdminService {

	@Autowired
	private AdminDAO adminDAO;
	
	public Admin getAdmin(final int id) {
		return adminDAO.getAdmin(id);
	}
	
	public Admin getAdminByEmail(final String email) {
		return adminDAO.getAdminByEmail(email);
	}
	
	public List<Admin> getAdmins() {
		return adminDAO.getAdmins();
	}

	public void addAdmin(final Admin admin) {
		adminDAO.addAdmin(admin);
	}

	public void updateAdmin(final Admin admin) {
		adminDAO.updateAdmin(admin);
	}

	public void deleteAdmin(final int id) {
		adminDAO.deleteAdmin(id);
	}
	
	public boolean login(String email,String password) {
		return adminDAO.validate(email, password);
	}
	
}
