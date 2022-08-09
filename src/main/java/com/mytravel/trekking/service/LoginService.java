package com.mytravel.trekking.service;

import com.mytravel.trekking.model.Creds;
import com.mytravel.trekking.model.UserProfile;
import com.mytravel.trekking.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserProfileRepository userRepository;

    public LoginService(UserProfileRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserProfile login(Creds creds){
       return userRepository.findByUsername(creds.getUsername());

    }


}
