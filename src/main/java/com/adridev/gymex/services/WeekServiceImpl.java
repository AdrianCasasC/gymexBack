package com.adridev.gymex.services;

import com.adridev.gymex.dao.WeekDao;
import com.adridev.gymex.entity.Day;
import com.adridev.gymex.entity.Routine;
import com.adridev.gymex.entity.Week;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WeekServiceImpl implements WeekService{
    WeekDao weekDao;

    @Autowired
    public WeekServiceImpl(WeekDao weekDao) {
        this.weekDao = weekDao;
    }

    @Override
    public Optional<List<Week>> getAllWeeks(String userId) {
        return weekDao.getAllDBWeeks(userId);
    }

    @Override
    public Optional<Week> getDBWeekById(String userId, UUID weekId) {
        return weekDao.getWeekById(userId, weekId);
    }

    @Override
    public Week editWeek(String userId, Week editedWeek) {
        return weekDao.putDBWeek(userId, editedWeek);
    }

    @Override
    public Day editWeekDayRoutine(String userId, Integer dayId, Routine editedRoutine) {
        return weekDao.putDBWeekDayRoutine(userId, dayId, editedRoutine);
    }

    @Override
    public Week postNewWeek(String userId, Week newWeek) {
        return weekDao.postWeekToDB(userId, newWeek);
    }

    @Override
    public void deleteWeek(String userId, UUID weekId) {
        weekDao.deleteDBWeek(userId, weekId);
    }
}
