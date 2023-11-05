package com.adridev.gymex.dao;

import com.adridev.gymex.models.Day;
import com.adridev.gymex.models.Routine;
import com.adridev.gymex.models.Week;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class WeekDaoImp implements WeekDao{
    RoutineDao routineDao;
    Map<String , Week> databaseWeeks = new HashMap<>();

    @Autowired
    public WeekDaoImp(RoutineDao routineDao) {
        this.routineDao = routineDao;

        String userId = "id1";

        UUID idWeek1 = UUID.randomUUID();

        UUID idDay1 = UUID.randomUUID();
        UUID idDay2 = UUID.randomUUID();
        UUID idDay3 = UUID.randomUUID();
        UUID idDay4 = UUID.randomUUID();
        UUID idDay5 = UUID.randomUUID();
        UUID idDay6 = UUID.randomUUID();
        UUID idDay7 = UUID.randomUUID();

        List<Routine> routines = routineDao.getAllDBRoutines(userId);

        List<Day> days = new ArrayList<>();
        days.add(new Day(idDay1, "monday", routines.get(0)));
        days.add(new Day(idDay2, "tuesday", routines.get(0)));
        days.add(new Day(idDay3, "wednesday", routines.get(0)));
        days.add(new Day(idDay4, "thursday", routines.get(0)));
        days.add(new Day(idDay5, "friday", routines.get(0)));
        days.add(new Day(idDay6, "saturday", routines.get(0)));
        days.add(new Day(idDay7, "sunday", routines.get(0)));


        databaseWeeks.put(userId, new Week(idWeek1, "Semana 1", days));
    }
    @Override
    public List<Week> getAllDBWeeks(String userId) {
        return new ArrayList<>(databaseWeeks.values());
    }
}
