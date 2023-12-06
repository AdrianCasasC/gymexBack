package com.adridev.gymex.services;

import com.adridev.gymex.entity.Routine;

import java.util.List;
import java.util.Optional;

public interface RoutineService {
    Optional<List<Routine>> getAllRoutines(String userId);

    Routine postRoutine(String userId, Routine newRoutine);

    void deleteRoutine(String userId, Integer routineId);

    Optional<Routine> editRoutine(String userId, Routine editedRoutine);
}
