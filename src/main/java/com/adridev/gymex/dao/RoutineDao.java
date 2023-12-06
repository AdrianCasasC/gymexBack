package com.adridev.gymex.dao;

import com.adridev.gymex.entity.Routine;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoutineDao {
    Optional<List<Routine>> getAllDBRoutines(String userId);
    Optional<Routine> getRoutineById(String userId, Integer routineId);
    Routine postNewRoutineToDB(String userId, Routine newRoutine);
    void deleteDBRoutine(String userId, Integer routineId);
    Optional<Routine> findRoutineIndexById(String userId, Integer routineId);
    Optional<Routine> editDBRoutine(String userId, Routine editedRoutine);
}
