// hibernate/src/main/java/com/dmenezesgabriel/jpa/domain/Gender.java
package com.smartguardian.domain.entity;

public enum Gender {

    MALE("masculino"), FEMALE("feminino");

    private String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
