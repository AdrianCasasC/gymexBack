package com.adridev.gymex.services;

import com.adridev.gymex.models.Week;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WeekService {
    public Optional<List<Week>> getAllWeeks(String userId);

    public Optional<Week> getDBWeekById(String userId, UUID weekId);

    public List<Week> editWeek(String userId, Week editedWeek);

    public List<Week> postNewWeek(String userId, Week newWeek);
}
