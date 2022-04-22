package com.example.spring311.service;

import com.example.spring311.dao.UserDaoImpl;
import com.example.spring311.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDaoImpl userDaoImpl;

    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    @Transactional
    public void add(User user) {
        userDaoImpl.add(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDaoImpl.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(int id) {
        return userDaoImpl.getUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        System.out.println("gsagsa");
        return userDaoImpl.getAllUsers();
    }

    @Override
    @Transactional
    public void updateUser(int id, User newUser) {
        userDaoImpl.updateUser(id, newUser);
    }
}

