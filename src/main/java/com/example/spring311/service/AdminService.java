package com.example.spring311.service;


import com.example.spring311.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface AdminService {

    void add(User user);

    void delete(int id);

    User getUser(int id);

    void updateUser(int id, User newUser);

    List<User> getAllUsers();

    UserDetails loadUserByLogin(String username);

}

