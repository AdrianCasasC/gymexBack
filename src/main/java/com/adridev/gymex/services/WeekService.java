package com.adridev.gymex.services;

import com.adridev.gymex.models.Week;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WeekService {
    Optional<List<Week>> getAllWeeks(String userId);

    Optional<Week> getDBWeekById(String userId, UUID weekId);

    List<Week> editWeek(String userId, Week editedWeek);

    List<Week> postNewWeek(String userId, Week newWeek);

    int deleteWeek(String userId, UUID weekId);
}
