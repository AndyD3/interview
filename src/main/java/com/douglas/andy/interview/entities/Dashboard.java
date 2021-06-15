package com.douglas.andy.interview.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity(name = "Dashboards")
public class Dashboard {

    @Id
    private Integer id;

    ////////////////////////////////////////////////
    // Column names in MySQL are not case sensitive
    // If a camel case name is used here it is translated to an underscore (created_at, updated_at) by hibernate resulting in
    // mismapping problems
    ///////////////////////////////////////////////
    @Column(name = "createdat")
    private Timestamp createdAt;
    @Column(name = "updatedat")
    private Timestamp updatedAt;
    private String title;

    public Dashboard() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dashboard dashboard = (Dashboard) o;
        return Objects.equals(id, dashboard.id) &&
                Objects.equals(createdAt, dashboard.createdAt) &&
                Objects.equals(updatedAt, dashboard.updatedAt) &&
                Objects.equals(title, dashboard.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, title);
    }
}