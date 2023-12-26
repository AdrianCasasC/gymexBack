package com.adridev.gymex.services;

import com.adridev.gymex.dao.UserDao;
import com.adridev.gymex.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User register(User newUser) {
        Optional<User> databaseUser = this.getUserByName(newUser.getName());
        if (databaseUser.isEmpty()) {
            return userDao.registerDBUser(newUser);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT, "El nombre de usuario ya existe");

    }

    @Override
    public Optional<User> getUserByNamePass(String name, String password) {
        return userDao.findUserByNameAndPass(name, password);
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return  userDao.findUserByName(name);
    }
}
