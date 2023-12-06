package com.adridev.gymex.dao;

import com.adridev.gymex.entity.Day;
import com.adridev.gymex.entity.Routine;
import com.adridev.gymex.entity.Week;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.IntStream;

@Repository
public class WeekDaoImp implements WeekDao{

    Map<String , List<Week>> databaseWeeks = new HashMap<>();
    @Override
    public Optional<List<Week>> getAllDBWeeks(String userId) {
        return Optional.ofNullable(databaseWeeks.get(userId));
    }

    @Override
    public Optional<Week> getWeekById(String userId, UUID weekId) {
        Optional<List<Week>> weeks = this.getAllDBWeeks(userId);
        return weeks.flatMap(weekList -> weekList.stream().filter(week -> week.getId().equals(weekId)).findFirst());
    }

    @Override
    public OptionalInt findWeekIndexById(String userId, Integer weekId) {
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
        //UUID weekId = UUID.randomUUID();
        //newWeek.setId(weekId);
        List<Week> weeks = databaseWeeks.get(userId);
        if (!weeks.isEmpty()) {
            weeks.add(newWeek);
        }
        return weeks;
    }

    @Override
    public int deleteDBWeek(String userId, UUID weekId) {
        Optional<Week> foundWeek = this.getWeekById(userId, weekId);
        if (foundWeek.isPresent()) {
            List<Week> weeks = databaseWeeks.get(userId);
            weeks.removeIf(week -> week.getId().equals(weekId));
            return 0;
        }
        return -1;
    }
}
