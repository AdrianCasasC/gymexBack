package com.adridev.gymex.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer exerciseId;
    private String name;
    @OneToMany( cascade = CascadeType.ALL)
    private List<Serie> series;

    public Exercise(String name, List<Serie> series) {
        this.name = name;
        this.series = series;
    }

    public Exercise() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", series=" + series +
                '}';
    }


}
