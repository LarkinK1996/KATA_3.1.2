package com.example.spring311.service;

import com.example.spring311.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> getAllRoles();

    Set getRoleById(Integer[] role_id);

    void saveRole(Role role);



//    void deleteRoleById(Long id);

//    Role getRole(String role);
}
