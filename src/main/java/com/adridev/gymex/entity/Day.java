package com.adridev.gymex.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToOne
    private Routine routine;

    public Day(String name, Routine routine) {
        this.name = name;
        this.routine = routine;
    }

    public Day() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", routine=" + routine +
                '}';
    }
}
