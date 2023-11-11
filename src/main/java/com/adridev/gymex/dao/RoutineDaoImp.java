package com.adridev.gymex.dao;

import com.adridev.gymex.models.Exercise;
import com.adridev.gymex.models.Routine;
import com.adridev.gymex.models.Serie;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RoutineDaoImp implements RoutineDao {

    Map<String, List<Routine>> databaseRoutine = new HashMap<>();

    public RoutineDaoImp() {
        UUID idRoutine1 = UUID.randomUUID();

        List<Serie> series = new ArrayList<>();
        series.add(new Serie(200, 8, false, new ArrayList<>()));

        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new Exercise("inclineBarBenchPress", series));

        List<Routine> routines = new ArrayList<>();
        routines.add(new Routine(idRoutine1, "Pecho", exercises));

        databaseRoutine.put("id1", routines);
    }
    @Override
    public Optional<List<Routine>> getAllDBRoutines(String userId) {
        return Optional.ofNullable(databaseRoutine.get(userId));
    }

    @Override
    public Routine postNewRoutineToDB(String userId, Routine newRoutine) {
        UUID idRoutine = UUID.randomUUID();
        newRoutine.setId(idRoutine);
        List<Routine> routines = databaseRoutine.get(userId);
        routines.add(newRoutine);

        //TODO: cuando haya varios usuarios se tendrá que recuperar la rutina correspondiente al id del usuario
        //TODO: de momento como solo hay una, se meten todas las rutinas nuevas en 'databaseRoutine'
        databaseRoutine.put(userId, routines);
        return newRoutine;
    }

    @Override
    public Optional<Routine> findRoutineIndexById(String userId, UUID routineId) {
        List<Routine> userDatabaseRoutines = databaseRoutine.get(userId);

        return userDatabaseRoutines.stream().filter(routine -> routine.getId().equals(routineId)).findFirst();

    }

    @Override
    public  Optional<Routine> editDBRoutine(String userId, Routine editedRoutine) {
        Optional<Routine> foundRoutine = this.findRoutineIndexById(userId, editedRoutine.getId());
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
        return Optional.empty();
    }
}
