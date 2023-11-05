package com.adridev.gymex.services;

import com.adridev.gymex.dao.WeekDao;
import com.adridev.gymex.models.Week;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeekServiceImpl implements WeekService{
    WeekDao weekDao;

    @Autowired
    public WeekServiceImpl(WeekDao weekDao) {
        this.weekDao = weekDao;
    }

    @Override
    public List<Week> getAllWeeks(String userId) {
        return weekDao.getAllDBWeeks(userId);
    }
}
