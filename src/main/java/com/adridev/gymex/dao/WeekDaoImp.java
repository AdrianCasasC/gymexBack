package com.adridev.gymex.dao;

import com.adridev.gymex.entity.Day;
import com.adridev.gymex.entity.Routine;
import com.adridev.gymex.entity.Week;
import com.adridev.gymex.repository.DayRepository;
import com.adridev.gymex.repository.RoutineRepository;
import com.adridev.gymex.repository.WeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.IntStream;

@Repository
public class WeekDaoImp implements WeekDao{

    private final WeekRepository weekRepository;
    private final RoutineRepository routineRepository;
    private final DayRepository dayRepository;

    public  WeekDaoImp(WeekRepository weekRepository, RoutineRepository routineRepository, DayRepository dayRepository) {
        this.weekRepository = weekRepository;
        this.routineRepository = routineRepository;
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
        return weekRepository.save(editedWeek);
    }

    @Override
    public Day putDBWeekDayRoutine(String userId, Integer dayId, Routine editedRoutine) {
        Optional<Day> foundDay = dayRepository.findById(dayId);
        if (foundDay.isPresent()) {
            foundDay.get().setRoutine(editedRoutine);
            return dayRepository.save(foundDay.get());
        }
        return new Day();
    }

    @Override
    public Day deleteDBWeekDayRoutine(String userId, Integer dayId) {
        Optional<Day> foundDay = dayRepository.findById(dayId);
        if (foundDay.isPresent()) {
            foundDay.get().setRoutine(null);
            return dayRepository.save(foundDay.get());
        }
        return new Day();
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
