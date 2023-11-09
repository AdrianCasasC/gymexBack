package com.adridev.gymex.dao;

import com.adridev.gymex.models.Week;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

public interface WeekDao {

    public Optional<List<Week>> getAllDBWeeks(String userId);

    public Optional<Week> getWeekById(String userId, UUID weekId);

    public OptionalInt findWeekIndexById(String userId, UUID weekId);

    public List<Week> putDBWeek(String userId, Week editedWeek);

    public List<Week> postWeekToDB(String userId, Week newWeek);
}
