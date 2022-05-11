package com.example.spring311.dao;

import com.example.spring311.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    public List<Role> getAllRoles();

    Set<Role> getRoleById(Integer[] role_id);
    public void saveRole(Role role);
}
