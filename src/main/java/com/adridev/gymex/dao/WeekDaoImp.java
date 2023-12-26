package com.adridev.gymex.dao;

import com.adridev.gymex.entity.Day;
import com.adridev.gymex.entity.Routine;
import com.adridev.gymex.entity.Week;
import com.adridev.gymex.repository.DayRepository;
import com.adridev.gymex.repository.WeekRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Repository
public class WeekDaoImp implements WeekDao{

    private final WeekRepository weekRepository;
    private final DayRepository dayRepository;

    public  WeekDaoImp(WeekRepository weekRepository, DayRepository dayRepository) {
        this.weekRepository = weekRepository;
        this.dayRepository = dayRepository;
    }

    @Override
    public Optional<List<Week>> getAllDBWeeks(UUID userId) {
        return Optional.of(weekRepository.findAllByUserId(userId));
    }

    @Override
    public Optional<Week> getWeekById(String userId, UUID weekId) {
        return weekRepository.findById(weekId);
    }

    @Override
    public Week putDBWeek(String userId, Week editedWeek) {
        Optional<Week> databaseWeek = this.getWeekById(userId, editedWeek.getId());
        if (databaseWeek.isPresent()) {
            databaseWeek.get().setName(editedWeek.getName());
            databaseWeek.get().setDays(editedWeek.getDays());
            return weekRepository.save(databaseWeek.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Week not found");
    }

    @Override
    public Day putDBWeekDayRoutine(String userId, Integer dayId, Routine editedRoutine) {
        Optional<Day> foundDay = dayRepository.findById(dayId);
        if (foundDay.isPresent()) {
            foundDay.get().setRoutine(editedRoutine);
            return dayRepository.save(foundDay.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Day not found");
    }

    @Override
    public Day deleteDBWeekDayRoutine(String userId, Integer dayId) {
        Optional<Day> foundDay = dayRepository.findById(dayId);
        if (foundDay.isPresent()) {
            foundDay.get().setRoutine(null);
            return dayRepository.save(foundDay.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Day not found");
    }

    @Override
    public Week postWeekToDB(UUID userId, Week newWeek) {
        return weekRepository.save(newWeek);
    }

    @Override
    public void deleteDBWeek(String userId, UUID weekId) {
        weekRepository.deleteById(weekId);
    }
}
