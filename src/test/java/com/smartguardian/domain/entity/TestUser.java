package com.smartguardian.domain.entity;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestUser {
    @Test
    public void shoudInstanceObject() throws Exception {
        User user = new User();

        user.setName("Teste");
        user.setEmail("teste@example.com");
        user.setPassword("123");

        assertTrue(user.getName().equals("Teste"));
        assertTrue(user.getEmail().equals("teste@example.com"));
        assertTrue(user.getPassword().equals("123"));

    }
}
