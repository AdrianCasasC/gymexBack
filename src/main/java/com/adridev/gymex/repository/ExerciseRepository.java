package com.adridev.gymex.repository;

import com.adridev.gymex.entity.Exercise;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Integer> {
}
