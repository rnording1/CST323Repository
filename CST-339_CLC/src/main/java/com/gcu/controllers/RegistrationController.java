package com.gcu.controllers;

import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;

@Controller
public class RegistrationController {
	
	@Autowired
	private UsersDataService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid UserEntity user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        
        userService.create(user);
        model.addAttribute("message", "User registered successfully!");
        return "registrationSuccess";
    }
}
