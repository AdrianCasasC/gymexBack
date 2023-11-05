package com.adridev.gymex.dao;

import com.adridev.gymex.models.Routine;

import java.util.List;

public interface RoutineDao {
    List<Routine> getAllDBRoutines(String userId);
}
