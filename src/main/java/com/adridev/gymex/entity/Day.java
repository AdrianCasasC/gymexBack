package com.adridev.gymex.entity;

import jakarta.persistence.*;

@Entity
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Routine routine;

    public Day(String name, Routine routine) {
        this.name = name;
        this.routine = routine;
    }

    public Day() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
