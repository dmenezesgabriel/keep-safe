package com.smartguardian.keepsafe.model;

/**
 * Issue entity
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Objects;

@Entity
@Table(name = "tbl_ocorrencia")
public class Issue implements Serializable {
    protected static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "tbl_ocorrencia_cd_ocorrencia_seq",
            sequenceName = "tbl_ocorrencia_cd_ocorrencia_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "tbl_ocorrencia_cd_ocorrencia_seq")
    @Column(name = "cd_ocorrencia", updatable = false)
    private int id;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Name may not be null")
    @NotEmpty(message = "Name may not be empty")
    @Column(name = "ds_ocorrencia", nullable = false, length = 300)
    private String description;

    @NotBlank(message = "Latitude is required")
    @NotNull(message = "Latitude may not be null")
    @NotEmpty(message = "Latitude may not be empty")
    @Column(name = "vl_latitude_ocorrencia", nullable = false, length = 50)
    private String latitude;

    @NotBlank(message = "Longitude is required")
    @NotNull(message = "Longitude may not be null")
    @NotEmpty(message = "Longitude may not be empty")
    @Column(name = "vl_longitude_ocorrencia", nullable = false, length = 50)
    private String longitude;

    @NotNull(message = "Issue type may not be null")
    @Column(name = "cd_tipo_ocorrencia")
    private int issueTypeId;

    @NotNull(message = "Issue status may not be null")
    @Column(name = "cd_status_ocorrencia")
    private int issueStatusId;

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

    public Issue() {}

    public Issue(int id, String description, String latitude, String longitude,
            int issueTypeId, int issueStatusId, int userId, Calendar createdAt,
            Calendar updatedAt) {
        this.id = id;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.issueTypeId = issueTypeId;
        this.issueStatusId = issueStatusId;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getIssueTypeId() {
        return this.issueTypeId;
    }

    public void setIssueTypeId(int issueTypeId) {
        this.issueTypeId = issueTypeId;
    }

    public int getIssueStatusId() {
        return this.issueStatusId;
    }

    public void setIssueStatusId(int issueStatusId) {
        this.issueStatusId = issueStatusId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Issue id(int id) {
        setId(id);
        return this;
    }

    public Issue description(String description) {
        setDescription(description);
        return this;
    }

    public Issue latitude(String latitude) {
        setLatitude(latitude);
        return this;
    }

    public Issue longitude(String longitude) {
        setLongitude(longitude);
        return this;
    }

    public Issue issueTypeId(int issueTypeId) {
        setIssueTypeId(issueTypeId);
        return this;
    }

    public Issue issueStatusId(int issueStatusId) {
        setIssueStatusId(issueStatusId);
        return this;
    }

    public Issue userId(int userId) {
        setUserId(userId);
        return this;
    }

    public Issue createdAt(Calendar createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    public Issue updatedAt(Calendar updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Issue)) {
            return false;
        }
        Issue issue = (Issue) o;
        return id == issue.id && Objects.equals(description, issue.description)
                && Objects.equals(latitude, issue.latitude)
                && Objects.equals(longitude, issue.longitude)
                && issueTypeId == issue.issueTypeId
                && issueStatusId == issue.issueStatusId
                && userId == issue.userId
                && Objects.equals(createdAt, issue.createdAt)
                && Objects.equals(updatedAt, issue.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, latitude, longitude, issueTypeId,
                issueStatusId, userId, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return "{" + " id='" + getId() + "'" + ", description='"
                + getDescription() + "'" + ", latitude='" + getLatitude() + "'"
                + ", longitude='" + getLongitude() + "'" + ", issueTypeId='"
                + getIssueTypeId() + "'" + ", issueStatusId='"
                + getIssueStatusId() + "'" + ", userId='" + getUserId() + "'"
                + ", createdAt='" + sdf.format(createdAt.getTime()) + "'"
                + ", updatedAt='" + sdf.format(updatedAt.getTime()) + "'" + "}";
    }

}
