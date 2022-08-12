package com.mytravel.trekking.controller;

import com.mytravel.trekking.model.Creds;
import com.mytravel.trekking.model.UserProfile;
import com.mytravel.trekking.service.LoginServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Login {

    private final LoginServiceImpl loginService;

    public Login(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    @PostMapping("v1/login")
    public ResponseEntity<UserProfile> login(@RequestBody Creds creds){
        UserProfile isLogin=loginService.login(creds);
        Optional<UserProfile> value = Optional.ofNullable(isLogin);

        if (value.isPresent())
            return new ResponseEntity<>(isLogin,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
