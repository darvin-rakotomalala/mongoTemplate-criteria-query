package com.poc.repository;

import com.poc.model.domain.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserProfileCustomRepository {
    UserProfile saveUser(UserProfile userProfile);
    List<UserProfile> saveAllUsers(List<UserProfile> userProfiles);
    UserProfile getUserById(UUID id);
    UserProfile updateUser(UserProfile userProfile);
    void deleteUserById(UserProfile userProfile);
    Page<UserProfile> getAllUsers(Integer page, Integer size);
    Page<UserProfile> getUsersByName(String name, Integer page, Integer size);
    Page<UserProfile> searchUserProfile(List<String> input, Pageable pageable);
}
