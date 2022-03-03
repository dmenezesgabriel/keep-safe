// hibernate/src/main/java/com/dmenezesgabriel/jpa/domain/Gender.java
package com.smartguardian.domain.entity;

public enum IssueType {

    ACTIVE("ativo"),
    SOLVED("resolvido");

    private String description;

    IssueType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
