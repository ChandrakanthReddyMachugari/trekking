package com.mytravel.trekking.service;

import com.mytravel.trekking.model.CountryCode;
import com.mytravel.trekking.model.UserProfile;
import com.mytravel.trekking.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    private static final String COUNTRY_PHONE_CODE_URI = "https://countrycode.dev/api/calls";

    @Autowired
    private RestTemplate restTemplate;
    private final UserProfileRepository userProfileRepository;

    public RegistrationServiceImpl(UserProfileRepository userProfileRepository) {
//        this.restTemplate = restTemplate;
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile save(UserProfile userProfile){
        return userProfileRepository.save(userProfile);
    }

    @Override
    public CountryCode[] countryCode() {
        CountryCode[] countryCodes = restTemplate.getForObject(COUNTRY_PHONE_CODE_URI,CountryCode[].class);
        return countryCodes;
    }
}
