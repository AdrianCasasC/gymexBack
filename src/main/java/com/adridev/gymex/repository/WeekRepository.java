package com.adridev.gymex.repository;

import com.adridev.gymex.entity.Week;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface WeekRepository extends CrudRepository<Week, UUID> {
}
