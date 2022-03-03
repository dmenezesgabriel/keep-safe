package com.smartguardian.domain.entity;

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
@Table(name = "t_ocorrencia")
public class Issue implements Serializable {
    @Id
    @SequenceGenerator(name = "t_ocorrencia_cd_ocorrencia_seq", sequenceName = "t_ocorrencia_cd_ocorrencia_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_ocorrencia_cd_ocorrencia_seq")
    @Column(name = "cd_ocorrencia", updatable = false)
    // The naming tablename_columname_seq is the PostgreSQL default sequence naming
    // for SERIAL
    // The allocationSize=1 is important if you need Hibernate to co-operate with
    // other clients
    // Note that this sequence will have "gaps" in it if transactions roll back.
    // Never assume that for any id n there is an id n-1 or n+1.
    private int id;

    @Column(name = "nm_ocorrencia", nullable = false, length = 60)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "des_tipo_ocorrencia")
    private IssueType issueType;

    @Enumerated(EnumType.STRING)
    @Column(name = "des_status_ocorrencia")
    private Status status;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_criacao", columnDefinition = "TIMESTAMP WITH TIME ZONE", updatable = false)
    private Calendar createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_atualizacao", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Calendar updatedAt;

    public Issue() {
    }

    public Issue(int id, String name, IssueType issueType, Status status, Calendar createdAt, Calendar updatedAt) {
        this.id = id;
        this.name = name;
        this.issueType = issueType;
        this.status = status;
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

    public IssueType getIssueType() {
        return this.issueType;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public Issue name(String name) {
        setName(name);
        return this;
    }

    public Issue issueType(IssueType issueType) {
        setIssueType(issueType);
        return this;
    }

    public Issue status(Status status) {
        setStatus(status);
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
        return id == issue.id && Objects.equals(name, issue.name) && Objects.equals(issueType, issue.issueType)
                && Objects.equals(status, issue.status) && Objects.equals(createdAt, issue.createdAt)
                && Objects.equals(updatedAt, issue.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, issueType, status, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", issueType='" + getIssueType() + "'" +
                ", status='" + getStatus() + "'" +
                ", createdAt='" + sdf.format(createdAt.getTime()) + "'" +
                ", updatedAt='" + sdf.format(updatedAt.getTime()) + "'" +
                "}";
    }

}
