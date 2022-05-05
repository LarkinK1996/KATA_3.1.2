package com.example.spring311.repository;

import com.example.spring311.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
