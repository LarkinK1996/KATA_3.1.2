package com.example.spring311.service;

import com.example.spring311.dao.RoleDaoImpl;
import com.example.spring311.model.Role;
//import com.example.spring311.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class RoleServiceImpl implements RoleService {

    // private final RoleRepository roleRepository;
//
//
//    public RoleServiceImpl(RoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//    }
//
//    @Transactional(readOnly = true)
//    @Override
//    public Set<Role> getAllRoles() {
//        return roleRepository.findAll().stream().collect(Collectors.toSet());
//    }
//
//    @Transactional
//    @Override
//    public void saveRole(Role role) {
//        roleRepository.save(role);
//    }
//
//    @Transactional
//    @Override
//    public void deleteRoleById(Long id) {
//        roleRepository.deleteById(id);
//    }
//
//    @Transactional(readOnly = true)
//    @Override
//    public Role getRoleById(Long id) {
//        return roleRepository.findById(id).get();
//    }
//
//    @Transactional(readOnly = true)
//    @Override
//    public Role getRole(String role) {
//        return roleRepository.getRoleByName(role);
//    }

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
