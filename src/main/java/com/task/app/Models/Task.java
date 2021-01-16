package com.task.app.Models;

import org.springframework.validation.annotation.Validated;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.DateTimeException;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int Id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "category")
    private String category;

    @NotNull
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_due")
    private Date dateDue;

    public Task(String name, String description, String category, Date dateCreated, Date dateDue) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.dateCreated = dateCreated;
        this.dateDue = dateDue;
    }

    public Task() {
    }
}
