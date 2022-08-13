package com.mytravel.trekking.controller.ui;

import com.mytravel.trekking.model.Creds;
import com.mytravel.trekking.model.Login;
import com.mytravel.trekking.model.UserProfile;
import com.mytravel.trekking.service.LoginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final LoginServiceImpl loginService;

    public LoginController(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("login",new Login());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute Login login, BindingResult result, Model model){
        Creds creds = new Creds();
        creds.setUsername(login.getUsername());
        creds.setPassword(login.getPassword());
        UserProfile userProfile =loginService.login(creds);
        if(userProfile!=null)
            model.addAttribute("welcome","Hello welcome");
        else
            model.addAttribute("welcome","Failed to Login");
        return "home";

    }

}
