package com.poc.service.business;

import com.poc.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileRSMImpl implements UserProfileRSM {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public boolean existByName(String name) {
        return userProfileRepository.existsUserProfileByLastName(name);
    }

}
