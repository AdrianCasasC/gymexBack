package com.adridev.gymex.models;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Day {
    private UUID id;
    private String name;
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
