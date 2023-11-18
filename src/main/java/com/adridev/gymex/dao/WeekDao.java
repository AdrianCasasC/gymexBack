package com.adridev.gymex.dao;

import com.adridev.gymex.models.Week;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

public interface WeekDao {

    Optional<List<Week>> getAllDBWeeks(String userId);

    Optional<Week> getWeekById(String userId, UUID weekId);

    OptionalInt findWeekIndexById(String userId, UUID weekId);

    List<Week> putDBWeek(String userId, Week editedWeek);

    List<Week> postWeekToDB(String userId, Week newWeek);
    int deleteDBWeek(String userId, UUID weekId);
}
