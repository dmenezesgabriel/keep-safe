package com.smartguardian.domain.entity;

/**
 * Address entity
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
@Table(name = "tbl_endereco")
public class Address implements Serializable {
    protected static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "tbl_endereco_cd_endereco_seq",
            sequenceName = "tbl_endereco_cd_endereco_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "tbl_endereco_cd_endereco_seq")
    @Column(name = "cd_endereco", updatable = false)
    private int id;

    @Column(name = "ds_logradouro_endereco", nullable = false, length = 150)
    private String address;

    @Column(name = "nr_numero_endereco", nullable = false, length = 10)
    private String addressNumber;

    @Column(name = "ds_bairro_endereco", nullable = false, length = 30)
    private String district;

    @Column(name = "ds_cidade_endereco", nullable = false, length = 30)
    private String city;

    @Column(name = "ds_estado_endereco", nullable = false, length = 30)
    private String state;

    @Column(name = "ds_complemento_endereco", nullable = false, length = 150)
    private String complement;

    @Column(name = "nr_cep_endereco", nullable = false, length = 8)
    private String postalCode;

    @JoinColumn(name = "cd_usuario")
    @ManyToOne
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

    public Address() {}

    public Address(int id, String address, String addressNumber,
            String district, String city, String state, String complement,
            String postalCode, User user, Calendar createdAt,
            Calendar updatedAt) {
        this.id = id;
        this.address = address;
        this.addressNumber = addressNumber;
        this.district = district;
        this.city = city;
        this.state = state;
        this.complement = complement;
        this.postalCode = postalCode;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressNumber() {
        return this.addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComplement() {
        return this.complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public Address id(int id) {
        setId(id);
        return this;
    }

    public Address address(String address) {
        setAddress(address);
        return this;
    }

    public Address addressNumber(String addressNumber) {
        setAddressNumber(addressNumber);
        return this;
    }

    public Address district(String district) {
        setDistrict(district);
        return this;
    }

    public Address city(String city) {
        setCity(city);
        return this;
    }

    public Address state(String state) {
        setState(state);
        return this;
    }

    public Address complement(String complement) {
        setComplement(complement);
        return this;
    }

    public Address postalCode(String postalCode) {
        setPostalCode(postalCode);
        return this;
    }

    public Address user(User user) {
        setUser(user);
        return this;
    }

    public Address createdAt(Calendar createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    public Address updatedAt(Calendar updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Address)) {
            return false;
        }
        Address address = (Address) o;
        return id == address.id && Objects.equals(address, address.address)
                && Objects.equals(addressNumber, address.addressNumber)
                && Objects.equals(district, address.district)
                && Objects.equals(city, address.city)
                && Objects.equals(state, address.state)
                && Objects.equals(complement, address.complement)
                && Objects.equals(postalCode, address.postalCode)
                && Objects.equals(user, address.user)
                && Objects.equals(createdAt, address.createdAt)
                && Objects.equals(updatedAt, address.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, addressNumber, district, city, state,
                complement, postalCode, user, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return "{" + " id='" + getId() + "'" + ", address='" + getAddress()
                + "'" + ", addressNumber='" + getAddressNumber() + "'"
                + ", district='" + getDistrict() + "'" + ", city='" + getCity()
                + "'" + ", state='" + getState() + "'" + ", complement='"
                + getComplement() + "'" + ", postalCode='" + getPostalCode()
                + "'" + ", user='" + getUser() + "'" + ", createdAt='"
                + sdf.format(createdAt.getTime()) + "'" + ", updatedAt='"
                + sdf.format(updatedAt.getTime()) + "'" + "}";
    }

}
