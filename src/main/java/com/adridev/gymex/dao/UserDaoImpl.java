package com.adridev.gymex.dao;

import com.adridev.gymex.entity.User;
import com.adridev.gymex.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserDaoImpl implements UserDao{
    private final UserRepository userRepository;

    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerDBUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public Optional<User> findUserByNameAndPass(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return userRepository.findByName(name);
    }
}
