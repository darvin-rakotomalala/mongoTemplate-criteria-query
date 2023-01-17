package com.poc.repository.find_queries;

import com.poc.model.domain.UserProfile;

import java.util.List;
import java.util.UUID;

public interface FindQueryCustomRepository {
    List<UserProfile> findUserProfilesByLastName(String lastName);
    List<UserProfile> findUserProfilesByFirstName(String firstName);
    UserProfile findUserProfilesById(UUID id);
    UserProfile findOneByLastName(String lastName);
    List<String> findDistinctByPinCode();
    List<String> findDistinctByFieldAndQuery1(int age);
    List<String> findDistinctByFieldAndQuery2(int age);
    List<String> findDistinctByFieldAndQuery3(int age);

    List<UserProfile> findAllUserProfiles();
    void findAllAndRemoveByLastName(String lastName);
    void findAndRemoveByLastName(String lastName);
    void findAndModifyByLastName(UserProfile userProfile);
    UserProfile findAndModifyOptionsByLastName(UserProfile userProfile);
    UserProfile findAndReplaceByLastName(UserProfile userProfile);
    UserProfile findAndReplaceOptionsByLastName(UserProfile userProfile);
}
