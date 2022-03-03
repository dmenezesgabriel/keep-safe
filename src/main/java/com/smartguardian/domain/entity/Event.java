package com.smartguardian.domain.entity;

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
import java.io.Serializable;
import java.text.SimpleDateFormat;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Objects;

@Entity
@Table(name = "t_evento")
public class Event implements Serializable {
    @Id
    @SequenceGenerator(name = "t_evento_cd_evento_seq", sequenceName = "t_evento_cd_evento_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_evento_cd_evento_seq")
    @Column(name = "cd_evento", updatable = false)
    // The naming tablename_columname_seq is the PostgreSQL default sequence naming
    // for SERIAL
    // The allocationSize=1 is important if you need Hibernate to co-operate with
    // other clients
    // Note that this sequence will have "gaps" in it if transactions roll back.
    // Never assume that for any id n there is an id n-1 or n+1.
    private int id;

    @Column(name = "nm_evento", nullable = false, length = 60)
    private String name;

    @Column(name = "des_model", nullable = false, length = 60)
    private String model;

    @Column(name = "cd_model", nullable = false, length = 60)
    private String model_id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_criacao", columnDefinition = "TIMESTAMP WITH TIME ZONE", updatable = false)
    private Calendar createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_atualizacao", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Calendar updatedAt;

    public Event() {
    }

    public Event(int id, String name, String model, String model_id, Calendar createdAt, Calendar updatedAt) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.model_id = model_id;
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

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel_id() {
        return this.model_id;
    }

    public void setModel_id(String model_id) {
        this.model_id = model_id;
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

    public Event id(int id) {
        setId(id);
        return this;
    }

    public Event name(String name) {
        setName(name);
        return this;
    }

    public Event model(String model) {
        setModel(model);
        return this;
    }

    public Event model_id(String model_id) {
        setModel_id(model_id);
        return this;
    }

    public Event createdAt(Calendar createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    public Event updatedAt(Calendar updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Event)) {
            return false;
        }
        Event event = (Event) o;
        return id == event.id && Objects.equals(name, event.name) && Objects.equals(model, event.model)
                && Objects.equals(model_id, event.model_id) && Objects.equals(createdAt, event.createdAt)
                && Objects.equals(updatedAt, event.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, model, model_id, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", model='" + getModel() + "'" +
                ", model_id='" + getModel_id() + "'" +
                ", createdAt='" + sdf.format(createdAt.getTime()) + "'" +
                ", updatedAt='" + sdf.format(updatedAt.getTime()) + "'" +
                "}";
    }

}