package com.smartguardian.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.smartguardian.domain.entity.Address;
import com.smartguardian.domain.entity.Phone;
import com.smartguardian.domain.entity.User;

public class DeleteTest {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.smartguardian");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Phone phone = entityManager.find(Phone.class, 2);
		Address address = entityManager.find(Address.class, 2);
		User user = entityManager.find(User.class, 2);
		
		entityManager.remove(phone);
		entityManager.remove(address);
		entityManager.remove(user);
		
		try {
			entityManager.getTransaction().begin();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("error: "+e);
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
		}
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
