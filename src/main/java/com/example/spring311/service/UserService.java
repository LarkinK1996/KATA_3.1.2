package com.example.spring311.service;


import com.example.spring311.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void delete(int id);

    User getUser(int id);

    void updateUser(int id, User newUser);

    List<User> getAllUsers();
}

