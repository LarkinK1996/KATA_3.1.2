package com.example.spring311.util;

import com.example.spring311.model.Role;
import com.example.spring311.model.User;
import com.example.spring311.service.AdminService;
import com.example.spring311.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitializationUserDB {

    private final AdminService adminService;
    private final RoleService roleService;

    @Autowired
    public InitializationUserDB(AdminService adminService, RoleService roleService) {
        this.adminService = adminService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void createUsersWithRoles() {
        Role admin = new Role("ADMIN");
        Role user = new Role("USER");

        roleService.saveRole(admin);
        roleService.saveRole(user);

        Set<Role> adminRole = new HashSet<>();
        adminRole.add(admin);
        adminRole.add(user);

        Set<Role> userRole = new HashSet<>();
        userRole.add(user);

        User adminUser = new User("Костя", "Ларькин", "123", new BCryptPasswordEncoder(8).encode("123"), adminRole);
        User userUser = new User("Артем", "Соколов", "1234", new BCryptPasswordEncoder(8).encode("1234"), userRole);

        adminService.add(adminUser);
        adminService.add(userUser);

    }
}
