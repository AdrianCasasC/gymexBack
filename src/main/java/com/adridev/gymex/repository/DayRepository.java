package com.adridev.gymex.repository;

import com.adridev.gymex.entity.Day;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DayRepository extends CrudRepository<Day, Integer> {
    @Override
    Optional<Day> findById(Integer integer);
}
