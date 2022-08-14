package com.mytravel.trekking.service;

import com.mytravel.trekking.model.CountryCode;
import com.mytravel.trekking.model.UserProfile;

public interface RegistrationService {
    public UserProfile save(UserProfile userProfile);
    public CountryCode[] countryCode();
}
