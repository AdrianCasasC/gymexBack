package com.adridev.gymex.dao;

import com.adridev.gymex.models.Routine;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoutineDao {
    Optional<List<Routine>> getAllDBRoutines(String userId);
    Optional<Routine> getRoutineById(String userId, UUID routineId);
    Routine postNewRoutineToDB(String userId, Routine newRoutine);
    int deleteDBRoutine(String userId, UUID routineId);
    Optional<Routine> findRoutineIndexById(String userId, UUID routineId);
    Optional<Routine> editDBRoutine(String userId, Routine editedRoutine);
}
