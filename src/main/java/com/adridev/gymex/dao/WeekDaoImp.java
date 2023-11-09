package com.adridev.gymex.dao;

import com.adridev.gymex.models.Day;
import com.adridev.gymex.models.Routine;
import com.adridev.gymex.models.Week;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.IntStream;

@Repository
public class WeekDaoImp implements WeekDao{
    RoutineDao routineDao;
    Map<String , List<Week>> databaseWeeks = new HashMap<>();

    @Autowired
    public WeekDaoImp(RoutineDao routineDao) {
        this.routineDao = routineDao;

        String userId = "id1";

        UUID idWeek1 = UUID.randomUUID();

        Optional<List<Routine>> routines = routineDao.getAllDBRoutines(userId);

        if (routines.isPresent()) {
            List<Day> days = new ArrayList<>();
            days.add(new Day("monday", routines.get().get(0)));
            days.add(new Day("tuesday", routines.get().get(0)));
            days.add(new Day("wednesday", routines.get().get(0)));
            days.add(new Day("thursday", routines.get().get(0)));
            days.add(new Day("friday", routines.get().get(0)));
            days.add(new Day("saturday", routines.get().get(0)));
            days.add(new Day("sunday", routines.get().get(0)));

            List<Week> weeks = new ArrayList<>();
            weeks.add(new Week(idWeek1, "Semana 1", days));

            databaseWeeks.put(userId, weeks);
        }
    }
    @Override
    public Optional<List<Week>> getAllDBWeeks(String userId) {
        return Optional.ofNullable(databaseWeeks.get(userId));
    }

    @Override
    public OptionalInt findWeekIndexById(String userId, UUID weekId) {
        List<Week> userDatabaseWeeks = databaseWeeks.get(userId);

        return IntStream.range(0, userDatabaseWeeks.size())
                .filter(i -> userDatabaseWeeks.get(i).getId().equals(weekId))
                .findFirst();
    }

    @Override
    public List<Week> putDBWeek(String userId, Week editedWeek) {
        List<Week> userDatabaseWeeks = databaseWeeks.get(userId);
        OptionalInt weekIndexToEdit = this.findWeekIndexById(userId, editedWeek.getId());

        if (weekIndexToEdit.isPresent()) {
            userDatabaseWeeks.set(weekIndexToEdit.getAsInt(), editedWeek);
            return userDatabaseWeeks;
        }
        return null;
    }

    @Override
    public List<Week> postWeekToDB(String userId, Week newWeek) {
        UUID weekId = UUID.randomUUID();
        newWeek.setId(weekId);
        List<Week> weeks = databaseWeeks.get(userId);
        if (!weeks.isEmpty()) {
            weeks.add(newWeek);
        }
        return weeks;
    }
}
