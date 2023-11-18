package com.adridev.gymex.services;

import com.adridev.gymex.models.Routine;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoutineService {
    Optional<List<Routine>> getAllRoutines(String userId);

    Routine postRoutine(String userId, Routine newRoutine);

    int deleteRoutine(String userId, UUID routineId);

    Optional<Routine> editRoutine(String userId, Routine editedRoutine);
}
