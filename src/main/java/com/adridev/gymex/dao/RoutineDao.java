package com.adridev.gymex.dao;

import com.adridev.gymex.entity.Routine;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoutineDao {
    Optional<List<Routine>> getAllDBRoutines(UUID userId);
    Optional<Routine> getRoutineById(String userId, UUID routineId);
    Routine postNewRoutineToDB(UUID userId, Routine newRoutine);
    void deleteDBRoutine(String userId, UUID routineId);
    Optional<Routine> findRoutineIndexById(String userId, Integer routineId);
    Optional<Routine> editDBRoutine(String userId, Routine editedRoutine);
}
