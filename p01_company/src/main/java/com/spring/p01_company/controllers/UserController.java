package com.spring.p01_company.controllers;

import com.spring.p01_company.entities.User;
import com.spring.p01_company.services.UserNotFoundException;
import com.spring.p01_company.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired private UserService userService;

    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> listUsers = userService.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users/users";
    }

    @GetMapping("/users/new")
    public String showNewUserForm(Model model) {
        model.addAttribute("user", new User()); // "user" match with what declared in html (form)
        model.addAttribute("pageTitle", "Add New User");
        return "users/user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra) {
        userService.save(user);
        // this 'message' needs to match with 'users.html' ->  <div th:if="${message}">
        ra.addFlashAttribute("message", "New user had been added to database");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try{
            User user = userService.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User (ID : " + id + ")");
            return "users/user_form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", "New user had been added to database");
            return "redirect:/users";
        }
    }
}
