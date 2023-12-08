package com.adridev.gymex.dao;

import com.adridev.gymex.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    User registerDBUser(User newUser);
    Optional<User> findUserByNameAndPass(String name, String password);
}
