package com.smartguardian.keepsafe.model;

/**
 * User entity
 *
 * @author Smart Guardian Group
 * @version 1.0
 */
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import java.text.SimpleDateFormat;

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

    @NotBlank(message = "Name is required!")
    @NotNull(message = "Name may not be null!")
    @NotEmpty(message = "Name may not be empty!")
    @Size(min = 5, max = 50,
            message = "Name must be between 5 and 50 characters long")
    @Column(name = "nm_usuario", nullable = false, length = 50)
    private String name;

    @NotBlank(message = "Email is required!")
    @NotNull(message = "Email may not be null!")
    @NotEmpty(message = "Email may not be empty!")
    @Size(max = 150, message = "Email must have max 150 characters long")
    @Email(message = "Email is not valid",
            regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @Column(name = "des_email", nullable = false, length = 150, unique = true)
    private String email;

    @NotBlank(message = "Password is required!")
    @NotNull(message = "Password may not be null!")
    @NotEmpty(message = "Password may not be empty!")
    @Size(min = 6, max = 50,
            message = "Password must be between 6 and 50 characters long")
    @Column(name = "des_senha", nullable = false, length = 50)
    private String password;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cd_usuario", referencedColumnName = "cd_usuario")
    private List<Address> addressList;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cd_usuario", referencedColumnName = "cd_usuario")
    private List<Phone> phoneList;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cd_usuario", referencedColumnName = "cd_usuario")
    private List<Issue> issueList;

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
            List<Issue> issueList, Calendar createdAt, Calendar updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.addressList = addressList;
        this.phoneList = phoneList;
        this.issueList = issueList;
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

    public List<Address> getAddressList() {
        return this.addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Phone> getPhoneList() {
        return this.phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public List<Issue> getIssueList() {
        return this.issueList;
    }

    public void setIssueList(List<Issue> issueList) {
        this.issueList = issueList;
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

    public User addressList(List<Address> addressList) {
        setAddressList(addressList);
        return this;
    }

    public User phoneList(List<Phone> phoneList) {
        setPhoneList(phoneList);
        return this;
    }

    public User issueList(List<Issue> issueList) {
        setIssueList(issueList);
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
                && Objects.equals(issueList, user.issueList)
                && Objects.equals(createdAt, user.createdAt)
                && Objects.equals(updatedAt, user.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, addressList, phoneList,
                issueList, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return "User [createdAt=" + sdf.format(createdAt.getTime()) + ", email="
                + email + ", id=" + id + ", name=" + name + ", password="
                + password + ", phoneList=" + phoneList + ", updatedAt="
                + sdf.format(updatedAt.getTime()) + "]";
    }

}
