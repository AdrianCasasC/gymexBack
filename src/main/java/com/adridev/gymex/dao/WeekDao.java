package com.adridev.gymex.dao;

import com.adridev.gymex.models.Week;

import java.util.List;
import java.util.OptionalInt;
import java.util.UUID;

public interface WeekDao {

    public List<Week> getAllDBWeeks(String userId);

    public OptionalInt findWeekIndexById(String userId, UUID weekId);

    public List<Week> putDBWeek(String userId, Week editedWeek);

    public List<Week> postWeekToDB(String userId, Week newWeek);
}
