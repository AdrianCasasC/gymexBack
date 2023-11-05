package com.adridev.gymex.dao;

import com.adridev.gymex.models.Exercise;
import com.adridev.gymex.models.Routine;
import com.adridev.gymex.models.Serie;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.IntStream;

@Repository
public class RoutineDaoImp implements RoutineDao {

    Map<String, List<Routine>> databaseRoutine = new HashMap<>();

    public RoutineDaoImp() {
        UUID idRoutine1 = UUID.randomUUID();

        List<Serie> series = new ArrayList<>();
        series.add(new Serie(200, 8));

        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new Exercise("inclineBarBenchPress", series));

        List<Routine> routines = new ArrayList<>();
        routines.add(new Routine(idRoutine1, "Pecho", exercises));

        databaseRoutine.put("id1", routines);
    }
    @Override
    public List<Routine> getAllDBRoutines(String userId) {
        return databaseRoutine.get(userId);
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
    public OptionalInt findRoutineIndexById(String userId, UUID routineId) {
        List<Routine> userDatabaseRoutines = databaseRoutine.get(userId);

        return IntStream.range(0, userDatabaseRoutines.size())
                .filter(i -> userDatabaseRoutines.get(i).getId().equals(routineId))
                .findFirst();
    }

    @Override
    public Routine editDBRoutine(String userId, Routine editedRoutine) {
        OptionalInt foundRoutineIndex = this.findRoutineIndexById(userId, editedRoutine.getId());
        List<Routine> userDatabaseRoutines = databaseRoutine.get(userId);
        if (foundRoutineIndex.isPresent()) {
            userDatabaseRoutines.set(foundRoutineIndex.getAsInt(), editedRoutine);
            return editedRoutine;
        }
        return null;
    }
}
