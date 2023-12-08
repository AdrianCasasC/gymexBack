package com.adridev.gymex.dao;

import com.adridev.gymex.entity.Day;
import com.adridev.gymex.entity.Routine;
import com.adridev.gymex.entity.Week;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

public interface WeekDao {

    Optional<List<Week>> getAllDBWeeks(UUID userId);

    Optional<Week> getWeekById(String userId, UUID weekId);

    //OptionalInt findWeekIndexById(String userId, Integer weekId);

    Week putDBWeek(String userId, Week editedWeek);

    Day putDBWeekDayRoutine(String userId, Integer dayId, Routine editedRoutine);

    Week postWeekToDB(UUID userId, Week newWeek);
    void deleteDBWeek(String userId, UUID weekId);
}
