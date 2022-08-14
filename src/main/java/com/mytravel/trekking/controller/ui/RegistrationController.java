package com.mytravel.trekking.controller.ui;

import com.mytravel.trekking.model.CountryCode;
import com.mytravel.trekking.model.UserProfile;
import com.mytravel.trekking.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/registration")
    public String register(Model model){
        CountryCode[] countryCodes = registrationService.countryCode();
        Arrays.stream(countryCodes).forEach(System.out::println);
        List<CountryCode> countryCodeList = Arrays.stream(countryCodes).collect(Collectors.toList());
        for (CountryCode country:
             countryCodeList) {
            System.out.println(country.getCountry_name());
        };
        model.addAttribute("countryCodes", countryCodeList);
        model.addAttribute("userprofile",new UserProfile());
        return "registration";
    }
    @PostMapping("/registration")
    public String registerSubmit(@Valid @ModelAttribute("userprofile") UserProfile userProfile, BindingResult result){
        System.out.println("====> Inside registerSubmit");
        if (result.hasErrors()){

            System.out.println("error");
            return "registration";
        }
        UserProfile saved = registrationService.save(userProfile);
        if (saved!=null) {

            return "redirect:login";
        } else {
            return "registration";
        }
    }


}
