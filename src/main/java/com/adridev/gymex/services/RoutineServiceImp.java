package com.adridev.gymex.services;

import com.adridev.gymex.dao.RoutineDao;
import com.adridev.gymex.models.Routine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutineServiceImp implements RoutineService {
    RoutineDao routineDao;

    @Autowired
    public RoutineServiceImp(RoutineDao routineDao) {
        this.routineDao = routineDao;
    }
    @Override
    public List<Routine> getAllRoutines(String userId) {
        return routineDao.getAllDBRoutines(userId);
    }

    @Override
    public Routine postRoutine(String userId, Routine newRoutine) {
        return routineDao.postNewRoutineToDB(userId, newRoutine);
    }

    @Override
    public Routine editRoutine(String userId, Routine editedRoutine) {
        return routineDao.editDBRoutine(userId, editedRoutine);
    }
}
