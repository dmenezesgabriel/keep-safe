package com.smartguardian.domain.entity;

/**
 * Phone entity
 *
 * @author Smart Guardian Group
 * @version 1.0
 */
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.text.SimpleDateFormat;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Objects;

@Entity
@Table(name = "tbl_telefone")
public class Phone implements Serializable {
    protected static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "tbl_telefone_cd_telefone_seq",
            sequenceName = "tbl_telefone_cd_telefone_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "tbl_telefone_cd_telefone_seq")
    @Column(name = "cd_telefone", updatable = false)
    private int id;

    @Column(name = "nr_telefone", nullable = false, length = 15)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "cd_usuario")
    private User user;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_criacao", columnDefinition = "TIMESTAMP WITH TIME ZONE",
            updatable = false)
    private Calendar createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_atualizacao",
            columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Calendar updatedAt;

    public Phone() {}

    public Phone(int id, String phoneNumber, User user, Calendar createdAt,
            Calendar updatedAt) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Calendar getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public Calendar getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Phone id(int id) {
        setId(id);
        return this;
    }

    public Phone phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    public Phone user(User user) {
        setUser(user);
        return this;
    }

    public Phone createdAt(Calendar createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    public Phone updatedAt(Calendar updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Phone)) {
            return false;
        }
        Phone phone = (Phone) o;
        return id == phone.id && Objects.equals(phoneNumber, phone.phoneNumber)
                && Objects.equals(user, phone.user)
                && Objects.equals(createdAt, phone.createdAt)
                && Objects.equals(updatedAt, phone.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phoneNumber, user, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return "{" + " id='" + getId() + "'" + ", phoneNumber='"
                + getPhoneNumber() + "'" + ", user='" + getUser() + "'"
                + ", createdAt='" + sdf.format(createdAt.getTime()) + "'"
                + ", updatedAt='" + sdf.format(updatedAt.getTime()) + "'" + "}";
    }

}
