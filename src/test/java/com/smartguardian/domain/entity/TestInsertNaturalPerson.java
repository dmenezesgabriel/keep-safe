package com.smartguardian.domain.entity;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import static org.junit.Assert.assertTrue;
import java.util.Calendar;
import java.util.List;

public class TestInsertNaturalPerson {
        @Test
        public void shouldInserNaturalPerson() throws Exception {
                EntityManagerFactory entityManagerFactory =
                                Persistence.createEntityManagerFactory(
                                                "com.smartguardian");
                EntityManager entityManager =
                                entityManagerFactory.createEntityManager();

                CriteriaBuilder criteriaBuilder =
                                entityManager.getCriteriaBuilder();
                CriteriaQuery<NaturalPerson> criteriaQuery = criteriaBuilder
                                .createQuery(NaturalPerson.class);
                criteriaQuery.from(NaturalPerson.class);
                List<NaturalPerson> naturalPersons = entityManager
                                .createQuery(criteriaQuery).getResultList();

                // No naturalPersons registered yet
                assertTrue(naturalPersons.isEmpty());

                NaturalPerson naturalPerson = new NaturalPerson();

                naturalPerson.setName("Teste");
                naturalPerson.setEmail("teste@example.com");
                naturalPerson.setPassword("123");
                naturalPerson.setGender(Gender.MALE);
                Calendar birthDate = Calendar.getInstance();
                birthDate.set(Calendar.YEAR, 1995);
                birthDate.set(Calendar.MONTH, Calendar.MARCH);
                birthDate.set(Calendar.DAY_OF_MONTH, 20);
                naturalPerson.setBirthDate(birthDate);
                naturalPerson.setDocument("12345678901");

                entityManager.getTransaction().begin();
                entityManager.persist(naturalPerson);
                entityManager.getTransaction().commit();

                naturalPersons = entityManager.createQuery(criteriaQuery)
                                .getResultList();
                assertTrue(naturalPersons.size() == 1);

                NaturalPerson record = entityManager.find(NaturalPerson.class,
                                naturalPerson.getId());

                assertTrue(record.getName().equals("Teste"));
                assertTrue(record.getEmail().equals("teste@example.com"));
                assertTrue(record.getPassword().equals("123"));
                assertTrue(record.getGender().equals(Gender.MALE));
                assertTrue(record.getBirthDate().equals(birthDate));
                assertTrue(record.getDocument().equals("12345678901"));

                entityManager.close();
                entityManagerFactory.close();

        }
}
