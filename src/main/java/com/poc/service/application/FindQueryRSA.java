package com.poc.service.application;

import com.poc.model.dto.UserProfileDTO;

import java.util.List;
import java.util.UUID;

public interface FindQueryRSA {
    List<UserProfileDTO> getUserProfileByLastName(String lastName);
    List<UserProfileDTO> getUserProfileByFirstName(String firstName);
    UserProfileDTO getUserProfileById(UUID id);
    UserProfileDTO getOneByLastName(String lastName);
    List<String> getDistinctByPinCode();
    List<String> getDistinctByFieldAndQuery1(int age);
    List<String> getDistinctByFieldAndQuery2(int age);
    List<String> getDistinctByFieldAndQuery3(int age);
    List<UserProfileDTO> getAllUserProfiles();
    void getAllAndRemoveByLastName(String lastName);
    void getAndRemoveByLastName(String lastName);
    void getAndModifyByLastName(UserProfileDTO userProfileDTO);
    UserProfileDTO getAndModifyOptionsByLastName(UserProfileDTO userProfileDTO);
    UserProfileDTO getAndReplaceByLastName(UserProfileDTO userProfileDTO);
    UserProfileDTO getAndReplaceOptionsByLastName(UserProfileDTO userProfileDTO);
}
