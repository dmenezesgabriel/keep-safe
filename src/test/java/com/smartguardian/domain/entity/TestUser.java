// hibernate/src/test/java/com/dmenezesgabriel/jpa/User.java
package com.smartguardian.domain.entity;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import org.junit.Test;

public class TestUser {
    @Test
    public void shoudInstanceObject() throws Exception {
        User user = new User();

        user.setName("Gabriel");
        user.setEmail("gabriel@example.com");
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(Calendar.YEAR, 1995);
        birthDate.set(Calendar.MONTH, Calendar.MARCH);
        birthDate.set(Calendar.DAY_OF_MONTH, 20);
        user.setBirthDate(birthDate);
        Gender gender = Gender.MALE;
        user.setGender(gender);

        assertTrue(user.getName().equals("Gabriel"));
        assertTrue(user.getEmail().equals("gabriel@example.com"));
        assertTrue(user.getBirthDate().equals(birthDate));
        assertTrue(user.getGender().equals(Gender.MALE));

    }
}
