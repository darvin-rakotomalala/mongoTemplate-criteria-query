package com.poc.service.application;

import com.poc.mapper.UserProfileMapper;
import com.poc.model.dto.UserProfileDTO;
import com.poc.service.business.FindQueryRSM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindQueryRSAImpl implements FindQueryRSA {

    private final FindQueryRSM findQueryRSM;
    private final UserProfileMapper userProfileMapper;

    @Override
    public List<UserProfileDTO> getUserProfileByLastName(String lastName) {
        return userProfileMapper.toDTO(findQueryRSM.getUserProfilesByLastName(lastName));
    }

    @Override
    public List<UserProfileDTO> getUserProfileByFirstName(String firstName) {
        return userProfileMapper.toDTO(findQueryRSM.getUserProfilesByFirstName(firstName));
    }

    @Override
    public UserProfileDTO getUserProfileById(UUID id) {
        return userProfileMapper.toDTO(findQueryRSM.getUserProfilesById(id));
    }

    @Override
    public UserProfileDTO getOneByLastName(String lastName) {
        return userProfileMapper.toDTO(findQueryRSM.getOneByLastName(lastName));
    }

    @Override
    public List<String> getDistinctByPinCode() {
        return findQueryRSM.getDistinctByPinCode();
    }

    @Override
    public List<String> getDistinctByFieldAndQuery1(int age) {
        return findQueryRSM.getDistinctByFieldAndQuery1(age);
    }

    @Override
    public List<String> getDistinctByFieldAndQuery2(int age) {
        return findQueryRSM.getDistinctByFieldAndQuery2(age);
    }

    @Override
    public List<String> getDistinctByFieldAndQuery3(int age) {
        return findQueryRSM.getDistinctByFieldAndQuery3(age);
    }

    @Override
    public List<UserProfileDTO> getAllUserProfiles() {
        return userProfileMapper.toDTO(findQueryRSM.getAllUserProfiles());
    }

    @Override
    public void getAllAndRemoveByLastName(String lastName) {
        findQueryRSM.getAllAndRemoveByLastName(lastName);
    }

    @Override
    public void getAndRemoveByLastName(String lastName) {
        findQueryRSM.getAndRemoveByLastName(lastName);
    }

    @Override
    public void getAndModifyByLastName(UserProfileDTO userProfileDTO) {
        findQueryRSM.getAndModifyByLastName(userProfileMapper.toDO(userProfileDTO));
    }

    @Override
    public UserProfileDTO getAndModifyOptionsByLastName(UserProfileDTO userProfileDTO) {
        return userProfileMapper.toDTO(findQueryRSM.getAndModifyOptionsByLastName(userProfileMapper.toDO(userProfileDTO)));
    }

    @Override
    public UserProfileDTO getAndReplaceByLastName(UserProfileDTO userProfileDTO) {
        return userProfileMapper.toDTO(findQueryRSM.getAndReplaceByLastName(userProfileMapper.toDO(userProfileDTO)));
    }

    @Override
    public UserProfileDTO getAndReplaceOptionsByLastName(UserProfileDTO userProfileDTO) {
        return userProfileMapper.toDTO(findQueryRSM.getAndReplaceOptionsByLastName(userProfileMapper.toDO(userProfileDTO)));
    }

}
