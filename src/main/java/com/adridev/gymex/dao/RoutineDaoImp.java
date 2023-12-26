package com.adridev.gymex.dao;

import com.adridev.gymex.entity.Exercise;
import com.adridev.gymex.entity.Routine;
import com.adridev.gymex.entity.Serie;
import com.adridev.gymex.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Repository
public class RoutineDaoImp implements RoutineDao {

    @Autowired
    private RoutineRepository routineRepository;
    Map<String, List<Routine>> databaseRoutine = new HashMap<>();
    @Override
    public Optional<List<Routine>> getAllDBRoutines(UUID userId) {
        return Optional.ofNullable(routineRepository.findAllByGeneralAndUserId(true,userId));
    }

    @Override
    public Routine postNewRoutineToDB(UUID userId, Routine newRoutine) {
        return routineRepository.save(newRoutine);
    }

    @Override
    public void deleteDBRoutine(String userId, UUID routineId) {
        routineRepository.deleteById(routineId);
    }

    @Override
    public Optional<Routine> getRoutineById(String userId, UUID routineId) {
        return routineRepository.findById(routineId);
    }

    @Override
    public Optional<Routine> findRoutineIndexById(String userId, Integer routineId) {
        List<Routine> userDatabaseRoutines = databaseRoutine.get(userId);
        return userDatabaseRoutines.stream().filter(routine -> routine.getId().equals(routineId)).findFirst();
    }

    @Override
    public  Optional<Routine> editDBRoutine(String userId, Routine editedRoutine) {
        Optional<Routine> databaseRoutine = routineRepository.findById(editedRoutine.getId());
        if (databaseRoutine.isPresent()) {
            databaseRoutine.get().setExercises(editedRoutine.getExercises());
            databaseRoutine.get().setName(editedRoutine.getName());
            return Optional.of(routineRepository.save(databaseRoutine.get()));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Routine not found");
    }
}
