package com.smartguardian.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.smartguardian.domain.entity.Address;
import com.smartguardian.domain.entity.Phone;
import com.smartguardian.domain.entity.User;
import java.util.List;
import java.util.ArrayList;


public class DeleteTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("com.smartguardian");
		EntityManager entityManager =
				entityManagerFactory.createEntityManager();

		// Create before delete
		Address address = new Address();
		address.id(0);
		address.address("Rua Acre");
		address.addressNumber("119");
		address.district("Vila Vieira");
		address.city("Araraquara");
		address.state("SP");
		address.complement("Casa 12-B");
		address.postalCode("14811131");

		List<Address> addressList = new ArrayList<>();
		addressList.add(address);

		Phone phone = new Phone();
		phone.id(0);
		phone.phoneNumber("055016997037819");

		List<Phone> phoneList = new ArrayList<>();
		phoneList.add(phone);

		User user = new User();
		user.id(0);
		user.name("Arthur Silva");
		user.email("arthur@teste.com");
		user.password("123");
		user.addressList(addressList);
		user.phoneList(phoneList);

		address.setUser(user);
		phone.setUser(user);

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
		}
		entityManager.clear();

		// Remove
		Phone phoneRecord = entityManager.find(Phone.class, phone.getId());
		Address addressRecord =
				entityManager.find(Address.class, address.getId());
		User userRecord = entityManager.find(User.class, user.getId());

		try {
			entityManager.getTransaction().begin();
			entityManager.remove(phoneRecord);
			entityManager.remove(addressRecord);
			entityManager.remove(userRecord);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("error: " + e);
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
		}

		entityManager.close();
		entityManagerFactory.close();

		// Check if removed
		assert (entityManager.find(Phone.class, phone.getId()) == null);
		assert (entityManager.find(Address.class, address.getId()) == null);
		assert (entityManager.find(User.class, user.getId()) == null);

	}

}
