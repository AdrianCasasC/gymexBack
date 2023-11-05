package com.adridev.gymex.services;

import com.adridev.gymex.models.Routine;

import java.util.List;

public interface RoutineService {
    List<Routine> getAllRoutines(String userId);
}
