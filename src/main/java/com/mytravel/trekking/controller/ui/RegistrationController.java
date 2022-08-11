package com.mytravel.trekking.controller.ui;

import com.mytravel.trekking.model.UserProfile;
import com.mytravel.trekking.repository.UserProfileRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final UserProfileRepository repository;

    public RegistrationController(UserProfileRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/registration")
    public String register(Model model){
        model.addAttribute("userprofile",new UserProfile());
        return "registration";
    }
    @PostMapping("/registration")
    public String registerSubmit(@ModelAttribute UserProfile userProfile, Model model){
        UserProfile saved = repository.save(userProfile);
        if (saved!=null) {
            return "redirect:login";
        } else {
            return "registration";
        }
    }


}
