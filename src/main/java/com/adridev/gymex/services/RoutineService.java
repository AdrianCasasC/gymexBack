package com.adridev.gymex.services;

import com.adridev.gymex.entity.Routine;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoutineService {
    Optional<List<Routine>> getAllRoutines(UUID userId);

    Routine postRoutine(UUID userId, Routine newRoutine);

    void deleteRoutine(String userId, UUID routineId);

    Optional<Routine> editRoutine(String userId, Routine editedRoutine);
}
