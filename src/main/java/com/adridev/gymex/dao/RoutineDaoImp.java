package com.adridev.gymex.dao;

import com.adridev.gymex.models.Exercise;
import com.adridev.gymex.models.Routine;
import com.adridev.gymex.models.Serie;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RoutineDaoImp implements RoutineDao {

    Map<String, Routine> databaseRoutine = new HashMap<>();
    Random random = new Random();

    public RoutineDaoImp() {
        UUID idRoutine1 = UUID.randomUUID();
        UUID idExercise1 = UUID.randomUUID();
        UUID idSerie1 = UUID.randomUUID();

        List<Serie> series = new ArrayList<>();
        series.add(new Serie(idSerie1, 200, 8));

        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new Exercise(idExercise1, "inclineBarBenchPress", series));

        databaseRoutine.put("id1", new Routine(idRoutine1, "Pecho", exercises));
    }
    @Override
    public List<Routine> getAllDBRoutines(String userId) {
        return new ArrayList<>(databaseRoutine.values());
    }
}
