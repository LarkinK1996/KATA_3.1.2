package com.example.spring311.service;

import com.example.spring311.model.User;
import com.example.spring311.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void add(User user) {
        adminRepository.save(user);
    }

    @Override
    public void delete(int id) {
        adminRepository.deleteById(id);
    }

    @Override
    // @Transactional(readOnly = true)
    public User getUser(int id) {
        return adminRepository.getById(id);
    }

    @Override
    // @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return adminRepository.findAll();
    }

    @Override
    public void updateUser(int id, User newUser) {
        adminRepository.saveAndFlush(newUser);
    }

    @Override
    public UserDetails loadUserByLogin(String username) {
        User user = adminRepository.findByUsername(username);
        return user;
    }
}

