package com.adridev.gymex.repository;

import com.adridev.gymex.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    Optional<User> findByNameAndPassword(String name, String password);
    Optional<User> findByName(String name);
}
