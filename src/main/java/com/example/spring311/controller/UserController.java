package com.example.spring311.controller;

import com.example.spring311.model.User;
import com.example.spring311.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final AdminService adminService;

    @Autowired
    public UserController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public String showUserInfo(Principal principal, Model model) {
        User user = (User) adminService.loadUserByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());

        return "userInfo";
    }
}
