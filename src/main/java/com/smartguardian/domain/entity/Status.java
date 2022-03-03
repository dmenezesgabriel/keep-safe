// hibernate/src/main/java/com/dmenezesgabriel/jpa/domain/Gender.java
package com.smartguardian.domain.entity;

public enum Status {

    INFECTION("Infecção"),
    TERRORISM("terrorismo"),
    THEFT("furto"),
    ROBBERY("assalto");

    private String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
