package com.spring.blogspot.Login;

import com.spring.blogspot.User.User;
import com.spring.blogspot.User.UserRepository;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginPageController {
    private final UserRepository userRepository;

    public LoginPageController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }
     @GetMapping("/userinterface")
    public String showUserInterface() {
        return "userinterface";
    }
    @GetMapping("/dashboard")
public String showDashboard() {
    return "dashboard";
}
@GetMapping("/editor")
public String showEditor() {
    return "editor"; 
}
@GetMapping("/edit_profile")
public String showEditProfile(Model model, Principal principal) {
    return "edit_profile";
}
@GetMapping("/my-posts")
public String showMyPosts() {
    return "my-posts"; 
}

@GetMapping("/profile")
public String showProfile(Model model, Principal principal) {
    if (principal == null) {
        model.addAttribute("name", "TestUser");
        model.addAttribute("password", "password");
        model.addAttribute("age", 0);
        model.addAttribute("gender", "Unknown");
        model.addAttribute("specialization", "None");
        model.addAttribute("email", "test@example.com");
        return "profile";
    }
    User user = userRepository.findByName(principal.getName());
    if (user != null) {
        model.addAttribute("name", user.getName());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("age", user.getAge());
        model.addAttribute("gender", user.getGender());
        model.addAttribute("specialization", user.getSpecialization());
        model.addAttribute("email", user.getEmail());
    }
    return "profile";
}

@PostMapping("/edit_profile")
public String processEditProfile(@ModelAttribute("user") User user, Model model) {
    userRepository.updateUser(user); // You need to implement this method in UserRepository
    return "redirect:/profile";
}
    @PostMapping("/login")
    public String processLogin(@ModelAttribute("login") Login login, Model model) {
        User found = userRepository.findByNameAndPassword(login.getName(), login.getPassword());
        if (found != null) {
            
            return "redirect:/userinterface";
        } else {
            model.addAttribute("message", "Invalid username or password.");
            return "login";
        }
    }

   
}