package com.smartguardian.domain.entity;

import static org.junit.Assert.assertTrue;
import java.util.Calendar;
import org.junit.Test;

public class TestNaturalPerson {
    @Test
    public void shoudInstanceObject() throws Exception {
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

        assertTrue(naturalPerson.getName().equals("Teste"));
        assertTrue(naturalPerson.getEmail().equals("teste@example.com"));
        assertTrue(naturalPerson.getPassword().equals("123"));
        assertTrue(naturalPerson.getGender().equals(Gender.MALE));
        assertTrue(naturalPerson.getBirthDate().equals(birthDate));
        assertTrue(naturalPerson.getDocument().equals("12345678901"));

    }
}
