package com.adridev.gymex.services;

import com.adridev.gymex.dao.UserDao;
import com.adridev.gymex.entity.User;
import org.springframework.stereotype.Service;

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
        return userDao.registerDBUser(newUser);
    }

    @Override
    public Optional<User> getUserByNamePass(String name, String password) {
        return userDao.findUserByNameAndPass(name, password);
    }
}
