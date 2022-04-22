package com.example.spring311.controller;

import com.example.spring311.model.User;
import com.example.spring311.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping()
public class UserController {

    public final UserService userDao;

    public UserController(UserService userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> users = userDao.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", userDao.getUser(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {
        userDao.add(user);
        return "redirect:/";
    }

    @PatchMapping("/update/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable(name = "id") int id) {
        userDao.updateUser(id, user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") int id) {

        ModelAndView modelAndView = new ModelAndView("edit");
        User user = userDao.getUser(id);

        modelAndView.addObject("user", user);
         return modelAndView;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        userDao.delete(id);
        return "redirect:/";
    }
}

