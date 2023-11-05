package com.adridev.gymex.services;

import com.adridev.gymex.models.Week;

import java.util.List;

public interface WeekService {
    public List<Week> getAllWeeks(String userId);
}
