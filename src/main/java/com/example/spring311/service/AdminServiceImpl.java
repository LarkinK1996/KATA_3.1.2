package com.example.spring311.service;

import com.example.spring311.dao.AdminDao;
import com.example.spring311.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    //private final AdminRepository adminRepository;
    private final AdminDao adminDao;

    @Autowired
    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

//
//    @Autowired
//    public AdminServiceImpl(AdminRepository adminRepository, AdminDao adminDao) {
//        this.adminDao = adminDao;
//        this.adminRepository = adminRepository;
//    }


    @Transactional
    @Override
    public void add(User user) {
        adminDao.add(user);
        //     adminRepository.save(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        //adminRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(int id) {
        return adminDao.getUser(id);
        // return adminRepository.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return adminDao.getAllUsers();
        //return adminRepository.findAll();
    }

    @Transactional
    @Override
    public void updateUser(int id, User newUser) {
        adminDao.updateUser(id, newUser);
        // adminRepository.saveAndFlush(newUser);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) {
        return adminDao.findByUsername(username);
//        return adminRepository.findByUsername(username);
    }
}

