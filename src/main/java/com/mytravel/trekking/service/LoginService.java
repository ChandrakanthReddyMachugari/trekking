package com.mytravel.trekking.service;

import com.mytravel.trekking.model.Creds;
import com.mytravel.trekking.model.UserProfile;

public interface LoginService {
    public UserProfile login(Creds creds);
}
