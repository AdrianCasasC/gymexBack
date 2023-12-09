package com.adridev.gymex.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Week {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID userId;
    private String name;
    @OneToMany( cascade = CascadeType.ALL)
    private List<Day> days;

    public Week(UUID userId, String name, List<Day> days) {
        this.userId = userId;
        this.name = name;
        this.days = days;
    }

    public Week() {}
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Week{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", days=" + days +
                '}';
    }
}
