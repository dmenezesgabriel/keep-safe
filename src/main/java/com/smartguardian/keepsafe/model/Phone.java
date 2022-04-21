package com.smartguardian.keepsafe.model;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @NotBlank(message = "Phone number is required!")
    @NotNull(message = "Phone number may not be null!")
    @NotEmpty(message = "Phone number may not be empty!")
    @Column(name = "nr_telefone", nullable = false, length = 15)
    private String phoneNumber;

    @NotNull(message = "User Id may not be null!")
    @Column(name = "cd_usuario", nullable = false)
    private int userId;

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

    public Phone(int id, String phoneNumber, int userId, Calendar createdAt,
            Calendar updatedAt) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public Calendar getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + id;
        result = prime * result
                + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result
                + ((updatedAt == null) ? 0 : updatedAt.hashCode());
        result = prime * result + userId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Phone other = (Phone) obj;
        if (createdAt == null) {
            if (other.createdAt != null)
                return false;
        } else if (!createdAt.equals(other.createdAt))
            return false;
        if (id != other.id)
            return false;
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        if (updatedAt == null) {
            if (other.updatedAt != null)
                return false;
        } else if (!updatedAt.equals(other.updatedAt))
            return false;
        if (userId != other.userId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Phone [createdAt=" + createdAt + ", id=" + id + ", phoneNumber="
                + phoneNumber + ", updatedAt=" + updatedAt + ", userId="
                + userId + "]";
    }

}
