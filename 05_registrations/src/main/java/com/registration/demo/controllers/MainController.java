package com.registration.demo.controllers;

import com.registration.demo.models.User;
import com.registration.demo.repositories.UserRepository;
import com.registration.demo.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired private UserService userService;

    @GetMapping("/")
    public String r_regPage(Model model) {
        model.addAttribute("user", new User());
        return "log_reg/register";
    }

    @GetMapping("/login")
    public String r_loginPage() {
        return "log_reg/login";
    }

    @GetMapping("/dashboard")
    public String r_dashboard(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "dashboard/dashboard";
    }

//    REGISTERING
    @PostMapping("/registering")
    public String p_registering(@Valid @ModelAttribute("user") User newUser, BindingResult result, HttpSession session) {
        User changedUser = userService.register(newUser, result);
        if (result.hasErrors()) {
            return "log_reg/register";
        }
        session.setAttribute("id", changedUser);
//        System.out.println("user : " + newUser);
//        System.out.println("changedUser : " + changedUser);
//        System.out.println("result : " + result);
//        System.out.println("session : " + session);
//        System.out.println("username : " + changedUser.getFirstName());
        return "redirect:/dashboard";
    }

//    LOGGING IN
    @PostMapping("/logging_in")
    public String p_loggingIn() {
        return "";
    }

    @GetMapping("/logout")
    public String p_loggingOut() {
        return "";
    }

}
