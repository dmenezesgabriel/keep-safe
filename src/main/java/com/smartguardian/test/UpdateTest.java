package com.smartguardian.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.smartguardian.domain.entity.Address;
import com.smartguardian.domain.entity.Phone;
import com.smartguardian.domain.entity.User;

public class UpdateTest {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.smartguardian");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		User user = entityManager.find(User.class, 3);
		user.setName("Arthur D'Afonseca");
		
		Address address = entityManager.find(Address.class, 3);
		address.setAddressNumber("99");
		
		Phone phone = entityManager.find(Phone.class, 3);
		phone.setPhoneNumber("055016997028080");
		
		try {
			entityManager.getTransaction().begin();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
		}
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
