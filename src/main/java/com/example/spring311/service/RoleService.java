package com.example.spring311.service;

import com.example.spring311.model.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAllRoles();

    void saveRole(Role role);

    Role getRoleById(Long id);

    void deleteRoleById(Long id);

    Role getRole(String role);
}
