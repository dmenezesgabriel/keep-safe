package com.smartguardian.domain.entity;

/**
 * Natual Person entity
 *
 * @author Smart Guardian Group
 * @version 1.0
 */
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Objects;

@Entity
@Table(name = "tbl_pessoa_fisisca")
public class NaturalPerson extends User {
    private static final long serialVersionUID = 1L;

    @Column(name = "nr_cpf_pessoa_fisica", nullable = false, length = 11)
    private String document;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nascimento_pessoa_fisica")
    private Calendar birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_genero", length = 50)
    private Gender gender;


    public NaturalPerson() {}

    public NaturalPerson(String document, Calendar birthDate, Gender gender) {
        this.document = document;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getDocument() {
        return this.document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Calendar getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public NaturalPerson document(String document) {
        setDocument(document);
        return this;
    }

    public NaturalPerson birthDate(Calendar birthDate) {
        setBirthDate(birthDate);
        return this;
    }

    public NaturalPerson gender(Gender gender) {
        setGender(gender);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NaturalPerson)) {
            return false;
        }
        NaturalPerson naturalPerson = (NaturalPerson) o;
        return Objects.equals(document, naturalPerson.document)
                && Objects.equals(birthDate, naturalPerson.birthDate)
                && Objects.equals(gender, naturalPerson.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(document, birthDate, gender);
    }


    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return "{" + " document='" + getDocument() + "'" + ", birthDate='"
                + sdf.format(birthDate.getTime()) + "'" + ", gender='"
                + getGender() + "'" + "}";
    }


}
