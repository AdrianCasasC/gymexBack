package com.adridev.gymex.repository;

import com.adridev.gymex.entity.Routine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoutineRepository extends CrudRepository<Routine, Integer> {
    List<Routine> findAllBy();

    @Override
    void deleteById(Integer routineId);

    @Override
    Optional<Routine> findById(Integer uuid);
}
