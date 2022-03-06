package com.smartguardian.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.smartguardian.domain.entity.Address;
import com.smartguardian.domain.entity.Phone;
import com.smartguardian.domain.entity.User;

public class CreateTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =
				Persistence.createEntityManagerFactory("com.smartguardian");
		EntityManager entityManager =
				entityManagerFactory.createEntityManager();

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

		// Check if created
		User record = entityManager.find(User.class, user.getId());
		assert (record.getName().equals("Arthur Silva"));
		assert (record.getEmail().equals("arthur@example.com"));
		assert (record.getPassword().equals("123"));
		assert (record.getPassword().equals("123"));
		assert (record.getAddressList().get(0).getAddress().equals("Rua Acre"));
		assert (record.getPhoneList().get(0).getPhoneNumber()
				.equals("055016997037819"));

		entityManager.close();
		entityManagerFactory.close();
	}

}
