package com.smartguardian.test;

import javax.persistence.Persistence;

public class DataBaseTest {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("com.smartguardian")
				.createEntityManager();
	}

}
