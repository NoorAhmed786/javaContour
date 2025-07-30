package com.noor.the_noor_residency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // ✅ Correct import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.noor.the_noor_residency.entity.User;
import com.noor.the_noor_residency.service.UserService;



@Controller
public class AuthController {
	

	

    @Autowired
    private UserService userService;
    
    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // refers to login.html in /templates
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // refers to register.html in /templates
    }

  


}
