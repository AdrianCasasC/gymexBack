package com.adridev.gymex.services;

import com.adridev.gymex.models.Week;

import java.util.List;
import java.util.Optional;

public interface WeekService {
    public Optional<List<Week>> getAllWeeks(String userId);

    public List<Week> editWeek(String userId, Week editedWeek);

    public List<Week> postNewWeek(String userId, Week newWeek);
}
