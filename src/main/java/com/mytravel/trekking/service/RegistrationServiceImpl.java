package com.mytravel.trekking.service;

import com.mytravel.trekking.model.UserProfile;
import com.mytravel.trekking.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService{
    private final UserProfileRepository userProfileRepository;

    public RegistrationServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile save(UserProfile userProfile){
        return userProfileRepository.save(userProfile);
    }
}
