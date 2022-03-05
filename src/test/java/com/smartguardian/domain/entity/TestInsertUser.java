// hibernate/src/test/java/com/dmenezesgabriel/jpa/TestInserUser.java
package com.smartguardian.domain.entity;

import java.util.Calendar;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.junit.Assert.assertTrue;

public class TestInsertUser {
    @Test
    public void shouldInserUser() throws Exception {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("com.smartguardian");
        EntityManager entityManager = entityManagerFactory
                .createEntityManager();

        User user = new User();

        user.setName("test_user");
        user.setEmail("test_email@example.com");
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(Calendar.YEAR, 1995);
        birthDate.set(Calendar.MONTH, Calendar.MARCH);
        birthDate.set(Calendar.DAY_OF_MONTH, 20);

        user.setPassword("123");

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        User record = entityManager.find(User.class, user.getId());

        assertTrue(record.getName().equals("test_user"));
        assertTrue(record.getEmail().equals("test_email@example.com"));

        entityManager.close();
        entityManagerFactory.close();

    }
}
