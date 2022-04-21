package com.smartguardian.keepsafe.model;

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

    @NotBlank(message = "Address is required!")
    @NotNull(message = "Address may not be null!")
    @NotEmpty(message = "Address may not be empty!")
    @Column(name = "ds_logradouro_endereco", nullable = false, length = 150)
    private String address;

    @NotBlank(message = "Address number is required!")
    @NotNull(message = "Address number may not be null!")
    @NotEmpty(message = "Address number may not be empty!")
    @Column(name = "nr_numero_endereco", nullable = false, length = 10)
    private String addressNumber;

    @NotBlank(message = "District is required!")
    @NotNull(message = "District may not be null!")
    @NotEmpty(message = "District may not be empty!")
    @Column(name = "ds_bairro_endereco", nullable = false, length = 30)
    private String district;

    @NotBlank(message = "City is required!")
    @NotNull(message = "City may not be null!")
    @NotEmpty(message = "City may not be empty!")
    @Column(name = "ds_cidade_endereco", nullable = false, length = 30)
    private String city;

    @NotBlank(message = "State is required!")
    @NotNull(message = "State may not be null!")
    @NotEmpty(message = "State may not be empty!")
    @Column(name = "ds_estado_endereco", nullable = false, length = 30)
    private String state;

    @NotBlank(message = "Complement is required!")
    @NotNull(message = "Complement may not be null!")
    @NotEmpty(message = "Complement may not be empty!")
    @Column(name = "ds_complemento_endereco", nullable = false, length = 150)
    private String complement;

    @NotBlank(message = "Postal code is required!")
    @NotNull(message = "Postal code may not be null!")
    @NotEmpty(message = "Postal code may not be empty!")
    @Column(name = "nr_cep_endereco", nullable = false, length = 8)
    private String postalCode;

    @NotNull(message = "User id may not be null!")
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

    public Address() {}

    public Address(int id, String address, String addressNumber,
            String district, String city, String state, String complement,
            String postalCode, int userId, Calendar createdAt,
            Calendar updatedAt) {
        this.id = id;
        this.address = address;
        this.addressNumber = addressNumber;
        this.district = district;
        this.city = city;
        this.state = state;
        this.complement = complement;
        this.postalCode = postalCode;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result
                + ((addressNumber == null) ? 0 : addressNumber.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result
                + ((complement == null) ? 0 : complement.hashCode());
        result = prime * result
                + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result
                + ((district == null) ? 0 : district.hashCode());
        result = prime * result + id;
        result = prime * result
                + ((postalCode == null) ? 0 : postalCode.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
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
        Address other = (Address) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (addressNumber == null) {
            if (other.addressNumber != null)
                return false;
        } else if (!addressNumber.equals(other.addressNumber))
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (complement == null) {
            if (other.complement != null)
                return false;
        } else if (!complement.equals(other.complement))
            return false;
        if (createdAt == null) {
            if (other.createdAt != null)
                return false;
        } else if (!createdAt.equals(other.createdAt))
            return false;
        if (district == null) {
            if (other.district != null)
                return false;
        } else if (!district.equals(other.district))
            return false;
        if (id != other.id)
            return false;
        if (postalCode == null) {
            if (other.postalCode != null)
                return false;
        } else if (!postalCode.equals(other.postalCode))
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
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
        return "Address [address=" + address + ", addressNumber="
                + addressNumber + ", city=" + city + ", complement="
                + complement + ", createdAt=" + createdAt + ", district="
                + district + ", id=" + id + ", postalCode=" + postalCode
                + ", state=" + state + ", updatedAt=" + updatedAt + ", userId="
                + userId + "]";
    }

}
