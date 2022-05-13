package com.example.spring311.service;

import com.example.spring311.dao.RoleDaoImpl;
import com.example.spring311.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleDaoImpl roleDao;

    @Autowired
    public RoleServiceImpl(RoleDaoImpl roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Set<Role> getRoleById(Integer[] role_id) {
        return roleDao.getRoleById(role_id);
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }
}
