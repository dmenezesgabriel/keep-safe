package com.smartguardian.keepsafe.model;

/**
 * Issue Type entity
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
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_tipo_ocorrencia")
public class IssueType implements Serializable {
    protected static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "tbl_tipo_ocorrencia_cd_tipo_ocorrencia_seq",
            sequenceName = "tbl_tipo_ocorrencia_cd_tipo_ocorrencia_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "tbl_tipo_ocorrencia_cd_tipo_ocorrencia_seq")
    @Column(name = "cd_tipo_ocorrencia", updatable = false)
    private int id;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Name may not be null")
    @Column(name = "nm_tipo_ocorrencia", nullable = false, length = 50)
    private String name;

    @NotNull(message = "User Id may not be null!")
    @Column(name = "cd_usuario", nullable = false)
    private int userId;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cd_tipo_ocorrencia",
            referencedColumnName = "cd_tipo_ocorrencia")
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


    public IssueType() {}

    public IssueType(int id, String name, int userId, List<Issue> issueList,
            Calendar createdAt, Calendar updatedAt) {
        this.id = id;
        this.name = name;
        this.userId = userId;
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

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public IssueType id(int id) {
        setId(id);
        return this;
    }

    public IssueType name(String name) {
        setName(name);
        return this;
    }

    public IssueType userId(int userId) {
        setUserId(userId);
        return this;
    }

    public IssueType issueList(List<Issue> issueList) {
        setIssueList(issueList);
        return this;
    }

    public IssueType createdAt(Calendar createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    public IssueType updatedAt(Calendar updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof IssueType)) {
            return false;
        }
        IssueType issueType = (IssueType) o;
        return id == issueType.id && Objects.equals(name, issueType.name)
                && userId == issueType.userId
                && Objects.equals(issueList, issueType.issueList)
                && Objects.equals(createdAt, issueType.createdAt)
                && Objects.equals(updatedAt, issueType.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userId, issueList, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'"
                + ", userId='" + getUserId() + "'" + ", issueList='"
                + getIssueList() + "'" + ", createdAt='"
                + sdf.format(createdAt.getTime()) + "'" + ", updatedAt='"
                + sdf.format(updatedAt.getTime()) + "'" + "}";
    }

}
