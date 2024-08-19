package com.gcu.controllers;


import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UserEntity;
import com.gcu.models.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@Autowired
	private UsersDataService userService;
	
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") UserEntity user, Model model) {
        System.out.println("Attempting to login user: " + user.getUsername());
        UserEntity foundUser = userService.findByUsername(user.getUsername());
        if (foundUser != null) {
            System.out.println("Found user: " + foundUser.getUsername());
            if (passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
                System.out.println("Password matches for user: " + foundUser.getUsername());
                return "redirect:/";
            } else {
                System.out.println("Password does not match for user: " + foundUser.getUsername());
            }
        } else {
            System.out.println("User not found: " + user.getUsername());
        }
        model.addAttribute("error", "Invalid username or password.");
        model.addAttribute("user", user);
        return "login";
    }
}
