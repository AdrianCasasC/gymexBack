package com.adridev.gymex.services;

import com.adridev.gymex.entity.Day;
import com.adridev.gymex.entity.Routine;
import com.adridev.gymex.entity.Week;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WeekService {
    Optional<List<Week>> getAllWeeks(String userId);

    Optional<Week> getDBWeekById(String userId, UUID weekId);

    Week editWeek(String userId, Week editedWeek);

    Day editWeekDayRoutine(String userId, Integer dayId, Routine editedRoutine);

    Week postNewWeek(String userId, Week newWeek);

    void deleteWeek(String userId, UUID weekId);
}
