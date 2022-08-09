package com.mytravel.trekking.repository;

import com.mytravel.trekking.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    UserProfile findByUsernameAndPassword(String userName, String password);

    UserProfile findByUsername(String username);
}
