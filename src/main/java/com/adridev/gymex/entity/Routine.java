package com.adridev.gymex.entity;

import jakarta.persistence.*;
//import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Entity
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany( cascade = CascadeType.ALL)
    private List<Exercise> exercises;

    public Routine(String name, List<Exercise> exercises) {
        this.name = name;
        this.exercises = exercises;
    }

    public Routine() {}

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

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "Routine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", exercises=" + exercises +
                '}';
    }
}
