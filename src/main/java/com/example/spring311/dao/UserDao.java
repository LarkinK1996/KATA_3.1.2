package com.example.spring311.dao;


import com.example.spring311.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void delete(int id);

    User getUser(int id);

    List<User> getAllUsers();

    void updateUser(int id, User newUser);

}
