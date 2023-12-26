package com.adridev.gymex.services;

import com.adridev.gymex.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    User register(User newUser);
    Optional<User> getUserByNamePass(String name, String password);
    Optional<User> getUserByName(String name);
}
