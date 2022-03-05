package com.smartguardian.domain.entity;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestLegalPerson {
    @Test
    public void shoudInstanceObject() throws Exception {
        LegalPerson legalPerson = new LegalPerson();

        legalPerson.setName("Teste");
        legalPerson.setEmail("teste@example.com");
        legalPerson.setPassword("123");
        legalPerson.setDocument("12345678901234");

        assertTrue(legalPerson.getName().equals("Teste"));
        assertTrue(legalPerson.getEmail().equals("teste@example.com"));
        assertTrue(legalPerson.getPassword().equals("123"));
        assertTrue(legalPerson.getDocument().equals("12345678901234"));

    }
}
