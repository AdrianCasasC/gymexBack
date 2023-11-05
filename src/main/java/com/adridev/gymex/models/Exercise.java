package com.adridev.gymex.models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Exercise {

    private String name;
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
