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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Objects;

@Entity
@Table(name = "tbl_pessoa_fisisca")
public class NaturalPerson extends User {

    @Id
    @SequenceGenerator(name = "tbl_pessoa_fisica_cd_pessoa_fisica_seq", sequenceName = "tbl_pessoa_fisica_cd_pessoa_fisica_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_pessoa_fisica_cd_pessoa_fisica_seq")
    @Column(name = "cd_pessoa_fisica", updatable = false)
    private int id;

    @Column(name = "nr_cpf_pessoa_fisica", nullable = false, length = 11)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nascimento_pessoa_fisica")
    private Calendar birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "des_genero", length = 50)
    private Gender gender;

    public NaturalPerson() {
    }

    public NaturalPerson(int id, String name, Calendar birthDate, Gender gender) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public NaturalPerson id(int id) {
        setId(id);
        return this;
    }

    public NaturalPerson name(String name) {
        setName(name);
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
        return id == naturalPerson.id && Objects.equals(name, naturalPerson.name)
                && Objects.equals(birthDate, naturalPerson.birthDate) && Objects.equals(gender, naturalPerson.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, gender);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", birthDate='" + sdf.format(birthDate.getTime()) + "'" +
                ", gender='" + getGender() + "'" +
                "}";
    }

}
