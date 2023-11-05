package com.adridev.gymex.dao;

import com.adridev.gymex.models.Routine;

import java.util.List;
import java.util.OptionalInt;
import java.util.UUID;

public interface RoutineDao {
    List<Routine> getAllDBRoutines(String userId);

    Routine postNewRoutineToDB(String userId, Routine newRoutine);
    OptionalInt findRoutineIndexById(String userId, UUID routineId);
    Routine editDBRoutine(String userId, Routine editedRoutine);
}
