package com.mytravel.trekking.controller;

import com.mytravel.trekking.model.UserProfile;
import com.mytravel.trekking.repository.UserProfileRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Register {

    private final UserProfileRepository userProfileRepository;

    public Register(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @PostMapping({"/register","register"})
    public ResponseEntity<Object> register(@RequestBody UserProfile userProfile){
        UserProfile savedProfile = userProfileRepository.save(userProfile);
        Optional<UserProfile> userProfileOptional = Optional.ofNullable(savedProfile);
        if (userProfileOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Bad Request from client",HttpStatus.BAD_REQUEST);
        }


    }



}
