package com.mytravel.trekking.service;

import com.mytravel.trekking.model.Creds;
import com.mytravel.trekking.model.UserProfile;
import com.mytravel.trekking.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserProfileRepository userRepository;

    public LoginServiceImpl(UserProfileRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserProfile login(Creds creds){
        System.out.println(creds);
       return userRepository.findByUsernameAndPassword(creds.getUsername(), creds.getPassword());

    }


}
