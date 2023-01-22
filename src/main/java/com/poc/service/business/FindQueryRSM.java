package com.poc.service.business;

import com.poc.model.domain.UserProfile;

import java.util.List;
import java.util.UUID;

public interface FindQueryRSM {
    List<UserProfile> getUserProfilesByLastName(String lastName);
    List<UserProfile> getUserProfilesByFirstName(String firstName);
    UserProfile getUserProfilesById(UUID id);
    UserProfile getOneByLastName(String lastName);
    List<String> getDistinctByPinCode();
    List<String> getDistinctByFieldAndQuery1(int age);
    List<String> getDistinctByFieldAndQuery2(int age);
    List<String> getDistinctByFieldAndQuery3(int age);

    List<UserProfile> getAllUserProfiles();
    void getAllAndRemoveByLastName(String lastName);
    void getAndRemoveByLastName(String lastName);
    void getAndModifyByLastName(UserProfile userProfile);
    UserProfile getAndModifyOptionsByLastName(UserProfile userProfile);
    UserProfile getAndReplaceByLastName(UserProfile userProfile);
    UserProfile getAndReplaceOptionsByLastName(UserProfile userProfile);
}
