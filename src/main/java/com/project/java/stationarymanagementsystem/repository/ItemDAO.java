package com.project.java.stationarymanagementsystem.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.java.stationarymanagementsystem.entities.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ItemDAO {
	
		private EntityManager entityManager;
			
		@Autowired
		public ItemDAO(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}

		public Item getItemById(final int itemid) {
			Session currentSession = entityManager.unwrap(Session.class);
			Item item = currentSession.get(Item.class, itemid);
			currentSession.close();
			return item;
		}
		
		public Item getItemByItemname(final String itemname) {
			Session currentSession = entityManager.unwrap(Session.class);
			Item item = currentSession.get(Item.class, itemname);
			currentSession.close();
			return item;
		}

		public List<Item> getItems() {
			Session currentSession = entityManager.unwrap(Session.class);
			TypedQuery<Item> theQuery =
					currentSession.createQuery("from Item", Item.class);
			List<Item> items = theQuery.getResultList();
			currentSession.close();
			return items;
		}
		@Transactional
		public void addItem(final Item item) {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.persist(item);
			currentSession.close();
		}

		@Transactional
		public void updateItem(final Item item) {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.merge(item);
			currentSession.close();
		}

		@Transactional
		public void deleteItem(final int id) {
			Session currentSession = entityManager.unwrap(Session.class);
			Item item = currentSession.get(Item.class, id);
			currentSession.remove(item);
			currentSession.close();	
		}
}
