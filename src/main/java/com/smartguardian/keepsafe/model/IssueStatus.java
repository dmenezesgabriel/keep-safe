package com.smartguardian.keepsafe.model;

/**
 * Issue Status entity
 *
 * @author Smart Guardian Group
 * @version 1.0
 */
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
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
@Table(name = "tbl_status_ocorrencia")
public class IssueStatus implements Serializable {
    protected static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "tbl_status_ocorrencia_cd_status_ocorrencia_seq",
            sequenceName = "tbl_status_ocorrencia_cd_status_ocorrencia_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "tbl_status_ocorrencia_cd_status_ocorrencia_seq")
    @Column(name = "cd_status_ocorrencia", updatable = false)
    private int id;

    @NotBlank(message = "Name is required")
    @NotNull(message = "Name may not be null")
    @Column(name = "nm_status_ocorrencia", nullable = false, length = 50)
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cd_status_ocorrencia",
            referencedColumnName = "cd_status_ocorrencia")
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


    public IssueStatus() {}

    public IssueStatus(int id, String name, List<Issue> issueList,
            Calendar createdAt, Calendar updatedAt) {
        this.id = id;
        this.name = name;
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

    public IssueStatus id(int id) {
        setId(id);
        return this;
    }

    public IssueStatus name(String name) {
        setName(name);
        return this;
    }

    public IssueStatus issueList(List<Issue> issueList) {
        setIssueList(issueList);
        return this;
    }

    public IssueStatus createdAt(Calendar createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    public IssueStatus updatedAt(Calendar updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof IssueStatus)) {
            return false;
        }
        IssueStatus issueStatus = (IssueStatus) o;
        return id == issueStatus.id && Objects.equals(name, issueStatus.name)
                && Objects.equals(issueList, issueStatus.issueList)
                && Objects.equals(createdAt, issueStatus.createdAt)
                && Objects.equals(updatedAt, issueStatus.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, issueList, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'"
                + ", issueList='" + getIssueList() + "'" + ", createdAt='"
                + sdf.format(createdAt.getTime()) + "'" + ", updatedAt='"
                + sdf.format(updatedAt.getTime()) + "'" + "}";
    }



}
