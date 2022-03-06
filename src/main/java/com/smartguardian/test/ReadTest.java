package com.smartguardian.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.smartguardian.domain.entity.Address;
import com.smartguardian.domain.entity.Phone;
import com.smartguardian.domain.entity.User;

public class ReadTest {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.smartguardian");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		User user = entityManager.find(User.class, 3);
		List<Address> userAddressList = user.getAddressList();
		List<Phone> userPhoneList = user.getPhoneList();
		
		System.out.println("User's info:");
		System.out.println(user.getId()+" "+user.getName());
		
		System.out.println("User's Adress List:");
		for (int i = 0; i < userAddressList.size(); i++) {
            System.out.println(userAddressList.get(i).getId()+" "+userAddressList.get(i).getAddress()+" "+userAddressList.get(i).getAddressNumber());
        }
		
		System.out.println("User's Phone List:");
		for (int i = 0; i < userPhoneList.size(); i++) {
            System.out.println(userPhoneList.get(i).getId()+" "+userPhoneList.get(i).getPhoneNumber());
        }
		
		Address address = entityManager.find(Address.class, 3);
		System.out.println(address.getId()+" "+address.getAddress()+ " "+address.getAddressNumber());
		
		Phone phone = entityManager.find(Phone.class, 3);
		System.out.println(phone.getId()+" "+phone.getPhoneNumber());
		
		entityManager.close();
		entityManagerFactory.close();
		
	}

}
