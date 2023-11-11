package com.adridev.gymex.models;

public class Coincidence {
    private String weekDay;
    private Integer reps;
    private Integer weight;

    public Coincidence() {}

    public Coincidence(String weekDay, Integer reps, Integer weight) {
        this.weekDay = weekDay;
        this.reps = reps;
        this.weight = weight;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Coincidence{" +
                "weekDay='" + weekDay + '\'' +
                ", reps=" + reps +
                ", weight=" + weight +
                '}';
    }
}
