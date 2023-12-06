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
    public Optional<List<Routine>> getAllDBRoutines(String userId) {
        return Optional.ofNullable(routineRepository.findAllBy());
    }

    @Override
    public Routine postNewRoutineToDB(String userId, Routine newRoutine) {
        /*//UUID idRoutine = UUID.randomUUID();
        //newRoutine.setId(idRoutine);
        List<Routine> routines = databaseRoutine.get(userId);
        routines.add(newRoutine);

        //TODO: cuando haya varios usuarios se tendrá que recuperar la rutina correspondiente al id del usuario
        //TODO: de momento como solo hay una, se meten todas las rutinas nuevas en 'databaseRoutine'
        databaseRoutine.put(userId, routines);*/
        routineRepository.save(newRoutine);
        return newRoutine;
    }

    @Override
    public void deleteDBRoutine(String userId, Integer routineId) {
        /*Optional<Routine> foundRoutine = this.getRoutineById(userId, routineId);
        if (foundRoutine.isPresent()) {
            List<Routine> routines = databaseRoutine.get(userId);
            routines.removeIf(routine -> routine.getId().equals(routineId));
            return 0;
        }
        return -1;*/
        routineRepository.deleteById(routineId);
    }

    @Override
    public Optional<Routine> getRoutineById(String userId, Integer routineId) {
        /*Optional<List<Routine>> routines = this.getAllDBRoutines(userId);
        return routines.flatMap(routineList -> routineList.stream().filter(routine -> routine.getId().equals(routineId)).findFirst());*/

        return routineRepository.findById(routineId);
    }

    @Override
    public Optional<Routine> findRoutineIndexById(String userId, Integer routineId) {
        List<Routine> userDatabaseRoutines = databaseRoutine.get(userId);

        return userDatabaseRoutines.stream().filter(routine -> routine.getId().equals(routineId)).findFirst();

    }

    @Override
    public  Optional<Routine> editDBRoutine(String userId, Routine editedRoutine) {
        /*Optional<Routine> foundRoutine = this.findRoutineIndexById(userId, editedRoutine.getId());
        List<Routine> userDatabaseRoutines = databaseRoutine.get(userId);
        if (foundRoutine.isPresent()) {
            userDatabaseRoutines.forEach(routine -> {
                if (routine.getId().equals(editedRoutine.getId())) {
                    routine.setName(editedRoutine.getName());
                    routine.setExercises(editedRoutine.getExercises());
                }
            });
            return Optional.of(editedRoutine);
        }
        return Optional.empty();*/

        return Optional.of(routineRepository.save(editedRoutine));
    }
}
