package com.adridev.gymex.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private Boolean general;
    private UUID userId;
    @OneToMany( cascade = CascadeType.ALL)
    private List<Exercise> exercises;
    private ZonedDateTime createdDate;

    public Routine(String name, Boolean general, UUID userId, List<Exercise> exercises, ZonedDateTime createdDate) {
        this.userId = userId;
        this.name = name;
        this.general = general;
        this.exercises = exercises;
        this.createdDate = createdDate;
    }

    public Routine() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGeneral() {
        return general;
    }

    public void setGeneral(Boolean general) {
        this.general = general;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Routine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", general='" + general + '\'' +
                ", userId='" + userId + '\'' +
                ", exercises=" + exercises +
                ", createdDate=" + createdDate +
                '}';
    }
}
