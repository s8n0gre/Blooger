package com.spring.blogspot.Register;

import com.spring.blogspot.User.User;
import com.spring.blogspot.User.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RegisterController {
    private final UserRepository userRepository;

    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Example registration controller method
    
@PostMapping("/register")
public String processRegister(@ModelAttribute User user, Model model) {
    int rows = userRepository.insertUser(user);
    if (rows > 0) {
        model.addAttribute("message", "Registration successful! You can now log in.");
    } else {
        model.addAttribute("message", "Registration failed. Try again.");
    }
    return "register";
}
// ...existing code...
}