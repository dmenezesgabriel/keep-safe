package com.smartguardian.domain.entity;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import static org.junit.Assert.assertTrue;
import java.util.List;

public class TestInsertUser {
        @Test
        public void shouldInserUser() throws Exception {
                EntityManagerFactory entityManagerFactory =
                                Persistence.createEntityManagerFactory(
                                                "com.smartguardian");
                EntityManager entityManager =
                                entityManagerFactory.createEntityManager();

                CriteriaBuilder criteriaBuilder =
                                entityManager.getCriteriaBuilder();
                CriteriaQuery<User> criteriaQuery =
                                criteriaBuilder.createQuery(User.class);
                criteriaQuery.from(User.class);
                List<User> users = entityManager.createQuery(criteriaQuery)
                                .getResultList();

                // No users registered yet
                assertTrue(users.isEmpty());

                User user = new User();

                user.setName("Teste");
                user.setEmail("teste@example.com");
                user.setPassword("123");

                entityManager.getTransaction().begin();
                entityManager.persist(user);
                entityManager.getTransaction().commit();

                users = entityManager.createQuery(criteriaQuery)
                                .getResultList();
                assertTrue(users.size() == 1);

                User record = entityManager.find(User.class, user.getId());

                assertTrue(record.getName().equals("Teste"));
                assertTrue(record.getEmail().equals("teste@example.com"));

                entityManager.close();
                entityManagerFactory.close();

        }
}
