// hibernate/src/test/java/com/dmenezesgabriel/jpa/User.java
package com.smartguardian.domain.entity;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestUser {
    @Test
    public void shoudInstanceObject() throws Exception {
        User user = new User();

        user.setName("test_user");
        user.setEmail("test_email@example.com");
        user.setPassword("123");
        assertTrue(user.getName().equals("test_user"));
        assertTrue(user.getEmail().equals("test_email@example.com"));

    }
}
