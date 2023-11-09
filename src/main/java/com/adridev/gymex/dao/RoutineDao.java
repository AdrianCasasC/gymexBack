package com.adridev.gymex.dao;

import com.adridev.gymex.models.Routine;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

public interface RoutineDao {
    Optional<List<Routine>> getAllDBRoutines(String userId);

    Routine postNewRoutineToDB(String userId, Routine newRoutine);
    Optional<Routine> findRoutineIndexById(String userId, UUID routineId);
    Optional<Routine> editDBRoutine(String userId, Routine editedRoutine);
}
