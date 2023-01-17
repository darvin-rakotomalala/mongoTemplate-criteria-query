package com.poc.service.application;

import com.poc.model.dto.UserProfileDTO;

import java.util.List;
import java.util.UUID;

public interface UserProfileCUDSA {
    UserProfileDTO saveUser(UserProfileDTO userProfile);
    List<UserProfileDTO> saveAllUsers(List<UserProfileDTO> userProfiles);
    UserProfileDTO updateUser(UserProfileDTO userProfile);
    void deleteUserById(UUID id);
}
