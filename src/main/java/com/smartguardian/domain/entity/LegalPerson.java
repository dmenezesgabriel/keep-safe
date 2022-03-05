package com.smartguardian.domain.entity;

/**
 * Legal Person entity
 *
 * @author Smart Guardian Group
 * @version 1.0
 */


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import java.util.Objects;


@Entity
@Table(name = "tbl_pessoa_juridica")
@DiscriminatorValue("PJ")
public class LegalPerson extends User {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "tbl_pessoa_juridica_cd_pessoa_juridica_seq",
            sequenceName = "tbl_pessoa_juridica_cd_pessoa_juridica_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "tbl_pessoa_juridica_cd_pessoa_juridica_seq")
    @Column(name = "cd_pessoa_juridica", updatable = false)
    private int id;

    @Column(name = "nr_cnpj_pessoa_juridica", nullable = false, length = 14)
    private String document;


    public LegalPerson() {}

    public LegalPerson(int id, String document) {
        this.id = id;
        this.document = document;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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
        return id == legalPerson.id
                && Objects.equals(document, legalPerson.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, document);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", document='" + getDocument()
                + "'" + "}";
    }

}
