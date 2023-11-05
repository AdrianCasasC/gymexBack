package com.adridev.gymex.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private Integer weight;
    private Integer reps;

    public Serie(UUID id, Integer weight, Integer reps) {
        this.id = id;
        this.weight = weight;
        this.reps = reps;
    }

    public Serie() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
