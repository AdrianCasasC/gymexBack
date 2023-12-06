package com.adridev.gymex.services;

import com.adridev.gymex.dao.RoutineDao;
import com.adridev.gymex.entity.Routine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoutineServiceImp implements RoutineService {
    RoutineDao routineDao;

    @Autowired
    public RoutineServiceImp(RoutineDao routineDao) {
        this.routineDao = routineDao;
    }
    @Override
    public Optional<List<Routine>> getAllRoutines(String userId) {
        return routineDao.getAllDBRoutines(userId);
    }

    @Override
    public Routine postRoutine(String userId, Routine newRoutine) {
        return routineDao.postNewRoutineToDB(userId, newRoutine);
    }

    @Override
    public void deleteRoutine(String userId, Integer routineId) {
        routineDao.deleteDBRoutine(userId, routineId);
    }

    @Override
    public Optional<Routine> editRoutine(String userId, Routine editedRoutine) {
        return routineDao.editDBRoutine(userId, editedRoutine);
    }
}
