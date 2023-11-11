package com.adridev.gymex.models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Serie {

    private Integer weight;
    private Integer reps;
    private Boolean showLastWeek;
    private List<Coincidence> lastWeekCoincidences;

    public Serie(Integer weight, Integer reps, Boolean showLastWeek, List<Coincidence> lastWeekCoincidences) {
        this.weight = weight;
        this.reps = reps;
        this.showLastWeek = showLastWeek;
        this.lastWeekCoincidences = lastWeekCoincidences;
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
    public Boolean getShowLastWeek() {
        return showLastWeek;
    }

    public void setShowLastWeek(Boolean showLastWeek) {
        this.showLastWeek = showLastWeek;
    }

    public List<Coincidence> getLastWeekCoincidences() {
        return lastWeekCoincidences;
    }

    public void setLastWeekCoincidences(List<Coincidence> lastWeekCoincidences) {
        this.lastWeekCoincidences = lastWeekCoincidences;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "weight=" + weight +
                ", reps=" + reps +
                '}';
    }


}
