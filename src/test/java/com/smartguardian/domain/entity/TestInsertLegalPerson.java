package com.smartguardian.domain.entity;


import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import static org.junit.Assert.assertTrue;
import java.util.List;

public class TestInsertLegalPerson {
        @Test
        public void shouldInserLegalPerson() throws Exception {
                EntityManagerFactory entityManagerFactory =
                                Persistence.createEntityManagerFactory(
                                                "com.smartguardian");
                EntityManager entityManager =
                                entityManagerFactory.createEntityManager();


                CriteriaBuilder criteriaBuilder =
                                entityManager.getCriteriaBuilder();
                CriteriaQuery<LegalPerson> criteriaQuery =
                                criteriaBuilder.createQuery(LegalPerson.class);
                criteriaQuery.from(LegalPerson.class);
                List<LegalPerson> legalPersons = entityManager
                                .createQuery(criteriaQuery).getResultList();

                // No legalPersons registered yet
                assertTrue(legalPersons.isEmpty());

                LegalPerson legalPerson = new LegalPerson();

                legalPerson.setName("Gabriel");
                legalPerson.setEmail("gabriel@example.com");
                legalPerson.setPassword("123");
                legalPerson.setDocument("12345678901234");

                entityManager.getTransaction().begin();
                entityManager.persist(legalPerson);
                entityManager.getTransaction().commit();

                legalPersons = entityManager.createQuery(criteriaQuery)
                                .getResultList();
                assertTrue(legalPersons.size() == 1);

                LegalPerson record = entityManager.find(LegalPerson.class,
                                legalPerson.getId());

                assertTrue(record.getName().equals("Gabriel"));
                assertTrue(record.getEmail().equals("gabriel@example.com"));
                assertTrue(record.getPassword().equals("123"));
                assertTrue(record.getDocument().equals("12345678901234"));

                entityManager.close();
                entityManagerFactory.close();

        }
}
