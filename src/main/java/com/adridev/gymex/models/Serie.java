package com.adridev.gymex.models;

import org.springframework.stereotype.Component;

@Component
public class Serie {

    private Integer weight;
    private Integer reps;

    public Serie(Integer weight, Integer reps) {
        this.weight = weight;
        this.reps = reps;
    }

    public Serie() {}

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "weight=" + weight +
                ", reps=" + reps +
                '}';
    }


}
