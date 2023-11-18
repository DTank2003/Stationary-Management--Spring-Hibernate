package com.project.java.stationarymanagementsystem.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.java.stationarymanagementsystem.entities.Admin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class AdminDAO {

	private EntityManager entityManager;

	@Autowired
	public AdminDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public Admin getAdmin(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Admin admin = currentSession.get(Admin.class, id);
		currentSession.close();
		return admin;
	}
	public boolean validate(String email,String password) {
		Session currentSession = entityManager.unwrap(Session.class);
		TypedQuery<Admin> theQuery = currentSession.createQuery("from Admin where email =:email and password =:pass", Admin.class);
		theQuery.setParameter("email", email);
		theQuery.setParameter("pass", password);

		List<Admin> admins = theQuery.getResultList();

		if (admins.isEmpty()) {
			return false;
		}
		return true;
	}
	public Admin getAdminByEmail(String email){
		Session currentSession = entityManager.unwrap(Session.class);
		TypedQuery<Admin> theQuery = currentSession.createQuery("from Admin where email =:email", Admin.class);
		theQuery.setParameter("email", email);
		return theQuery.getSingleResult();
	}
	
	public List<Admin> getAdmins() {
		Session currentSession = entityManager.unwrap(Session.class);

		TypedQuery<Admin> theQuery = currentSession.createQuery("from Admin", Admin.class);
		List<Admin> admins = theQuery.getResultList();
		currentSession.close();
		return admins;
	}
	@Transactional
	public void addAdmin(final Admin admin) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(admin);
		currentSession.close();
	}

	@Transactional
	public void updateAdmin(final Admin admin) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(admin);
		currentSession.close();
	}

	@Transactional
	public void deleteAdmin(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Admin admin = currentSession.get(Admin.class, id);
		currentSession.remove(admin);
		currentSession.close();

	}
	
}
