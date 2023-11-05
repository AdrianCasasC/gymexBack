package com.adridev.gymex.dao;

import com.adridev.gymex.models.Week;

import java.util.List;

public interface WeekDao {

    public List<Week> getAllDBWeeks(String userId);
}
