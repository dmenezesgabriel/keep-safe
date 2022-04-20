package com.smartguardian.keepsafe.model;

/**
 * Legal Person entity
 *
 * @author Smart Guardian Group
 * @version 1.0
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

import java.util.List;

@Entity
@Table(name = "tbl_pessoa_juridica")
public class LegalPerson extends User {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Document is required!")
    @NotNull(message = "Document may not be null!")
    @NotEmpty(message = "Document may not be empty!")
    @Column(name = "nr_cnpj_pessoa_juridica", nullable = false, length = 14,
            unique = true)
    private String document;

    public LegalPerson() {}

    public LegalPerson(String document, List<IssueType> issueTypeList) {
        super();
        this.document = document;
    }

    public String getDocument() {
        return this.document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LegalPerson document(String document) {
        setDocument(document);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LegalPerson)) {
            return false;
        }
        LegalPerson legalPerson = (LegalPerson) o;
        return Objects.equals(document, legalPerson.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(document);
    }

    @Override
    public String toString() {
        return "LegalPerson [document=" + document + "]";
    }

}
