package com.example.spring311.controller;

import com.example.spring311.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@PreAuthorize("hasAuthority('USER')")
public class UserController {

    private final AdminService adminService;

    @Autowired
    public UserController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/user")
    public String showUserInfo(Principal principal, Model model) {
        // почему-то это не работает
        // все перепробовал, нужна помощь
        model.addAttribute("user", adminService.loadUserByLogin(principal.getName()));
        return "userInfo";
    }
}
