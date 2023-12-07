package com.adridev.gymex.repository;

import com.adridev.gymex.entity.Week;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WeekRepository extends CrudRepository<Week, UUID> {
    List<Week> findAllBy();

    @Override
    Optional<Week> findById(UUID uuid);

    @Override
    void deleteById(UUID uuid);
}
