// hibernate/src/main/java/com/dmenezesgabriel/jpa/domain/User.java
package com.smartguardian.domain.entity;

/**
* User entity
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
@Table(name = "t_usuario")
public class User implements Serializable {
    protected static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "t_usuario_cd_usuario_seq", sequenceName = "t_usuario_cd_usuario_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_usuario_cd_usuario_seq")
    @Column(name = "cd_usuario", updatable = false)
    // The naming tablename_columname_seq is the PostgreSQL default sequence naming
    // for SERIAL
    // The allocationSize=1 is important if you need Hibernate to co-operate with
    // other clients
    // Note that this sequence will have "gaps" in it if transactions roll back.
    // Never assume that for any id n there is an id n-1 or n+1.
    private int id;

    @Column(name = "nm_usuario", nullable = false, length = 60)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nascimento")
    private Calendar birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "des_genero")
    private Gender gender;

    @Column(name = "des_email", nullable = false, length = 60)
    private String email;

    @Column(name = "des_senha", nullable = false, length = 60)
    private String password;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_criacao", columnDefinition = "TIMESTAMP WITH TIME ZONE", updatable = false)
    private Calendar createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_atualizacao", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Calendar updatedAt;

    public User() {
    }

    public User(int id, String name, Calendar birthDate, Gender gender, String email, String password,
            Calendar createdAt, Calendar updatedAt) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public User id(int id) {
        setId(id);
        return this;
    }

    public User name(String name) {
        setName(name);
        return this;
    }

    public User birthDate(Calendar birthDate) {
        setBirthDate(birthDate);
        return this;
    }

    public User gender(Gender gender) {
        setGender(gender);
        return this;
    }

    public User email(String email) {
        setEmail(email);
        return this;
    }

    public User password(String password) {
        setPassword(password);
        return this;
    }

    public User createdAt(Calendar createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    public User updatedAt(Calendar updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(birthDate, user.birthDate)
                && Objects.equals(gender, user.gender) && Objects.equals(email, user.email)
                && Objects.equals(password, user.password) && Objects.equals(createdAt, user.createdAt)
                && Objects.equals(updatedAt, user.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, gender, email, password, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", birthDate='" + sdf.format(birthDate.getTime()) + "'" +
                ", gender='" + getGender() + "'" +
                ", email='" + getEmail() + "'" +
                ", password='" + getPassword() + "'" +
                ", createdAt='" + sdf.format(createdAt.getTime()) + "'" +
                ", updatedAt='" + sdf.format(updatedAt.getTime()) + "'" +
                "}";
    }

}