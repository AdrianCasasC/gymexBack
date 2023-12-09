package com.adridev.gymex.dao;

import com.adridev.gymex.entity.Exercise;
import com.adridev.gymex.entity.Routine;
import com.adridev.gymex.entity.Serie;
import com.adridev.gymex.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        //TODO: cuando haya varios usuarios se tendrá que recuperar la rutina correspondiente al id del usuario
        //TODO: de momento como solo hay una, se meten todas las rutinas nuevas en 'databaseRoutine'
        System.out.println("Ruitna que llega al DAO: " + newRoutine);
        routineRepository.save(newRoutine);
        return newRoutine;
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
        return Optional.of(routineRepository.save(editedRoutine));
    }
}
