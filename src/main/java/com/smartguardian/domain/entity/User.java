package com.smartguardian.domain.entity;

/**
 * User entity
 *
 * @author Smart Guardian Group
 * @version 1.0
 */
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
    protected static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "tbl_usuario_cd_usuario_seq",
            sequenceName = "tbl_usuario_cd_usuario_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "tbl_usuario_cd_usuario_seq")
    @Column(name = "cd_usuario", updatable = false)
    private int id;

    @Column(name = "nm_usuario", nullable = false, length = 50)
    private String name;

    @Column(name = "des_email", nullable = false, length = 150)
    private String email;

    @Column(name = "des_senha", nullable = false, length = 50)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Address> addressList;

    @OneToMany(mappedBy = "user")
    private List<Phone> phoneList;

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

    public User() {}

    public User(int id, String name, String email, String password,
            List<Address> addressList, List<Phone> phoneList,
            Calendar createdAt, Calendar updatedAt) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.addressList = addressList;
        this.phoneList = phoneList;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
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

    public User email(String email) {
        setEmail(email);
        return this;
    }

    public User password(String password) {
        setPassword(password);
        return this;
    }

    public User address(Address address) {
        this.addressList.add(address);
        return this;
    }

    public User addressList(List<Address> address) {
        setAddressList(address);
        return this;
    }

    public User phone(Phone phone) {
        this.phoneList.add(phone);
        return this;
    }

    public User phoneList(List<Phone> phone) {
        setPhoneList(phone);
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
        return id == user.id && Objects.equals(name, user.name)
                && Objects.equals(email, user.email)
                && Objects.equals(password, user.password)
                && Objects.equals(addressList, user.addressList)
                && Objects.equals(phoneList, user.phoneList)
                && Objects.equals(createdAt, user.createdAt)
                && Objects.equals(updatedAt, user.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, addressList, phoneList,
                createdAt, updatedAt);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'"
                + ", email='" + getEmail() + "'" + ", password='"
                + getPassword() + "'" + ", address='" + getAddressList() + "'"
                + ", phone='" + getPhoneList() + "'" + ", createdAt='"
                + sdf.format(createdAt.getTime()) + "'" + ", updatedAt='"
                + sdf.format(updatedAt.getTime()) + "'" + "}";
    }

}
