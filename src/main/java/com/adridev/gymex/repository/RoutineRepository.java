package com.adridev.gymex.repository;

import com.adridev.gymex.entity.Routine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoutineRepository extends CrudRepository<Routine, UUID> {
    List<Routine> findAllBy();

    List<Routine> findAllByGeneral(Boolean general);
    @Override
    void deleteById(UUID routineId);

    @Override
    Optional<Routine> findById(UUID uuid);
}
