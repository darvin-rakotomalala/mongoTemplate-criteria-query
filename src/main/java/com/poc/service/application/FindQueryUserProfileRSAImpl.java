package com.poc.service.application;

import com.poc.mapper.UserProfileMapper;
import com.poc.model.dto.UserProfileDTO;
import com.poc.repository.UserProfileCustomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class FindQueryUserProfileRSAImpl implements FindQueryUserProfileRSA {

    private final UserProfileCustomRepository userProfileCustomRepository;
    private final UserProfileMapper userProfileMapper;

    @Override
    public List<UserProfileDTO> getUserProfileByLastName(String lastName) {
        try {
            log.info("----- getUserProfileByLastName : {}", lastName);
            return null;
        } catch (Exception e) {
            log.error("Error getUserProfileByLastName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<UserProfileDTO> getUserProfileByFirstName(String firstName) {
        try {
            log.info("----- getUserProfileByFirstName : {}", firstName);
            return null;
        } catch (Exception e) {
            log.error("Error getUserProfileByFirstName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public UserProfileDTO getUserProfileById(UUID id) {
        try {
            log.info("----- getUserProfileById : {}", id);
            return null;
        } catch (Exception e) {
            log.error("Error getUserProfileById : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public UserProfileDTO getOneByLastName(String lastName) {
        try {
            log.info("----- getOneByLastName : {}", lastName);
            return null;
        } catch (Exception e) {
            log.error("Error getOneByLastName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<String> getDistinctByPinCode() {
        try {
            log.info("----- getDistinctByPinCode");
            return null;
        } catch (Exception e) {
            log.error("Error getDistinctByPinCode : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<String> getDistinctByFieldAndQuery1(int age) {
        try {
            log.info("----- getDistinctByFieldAndQuery1 : {}", age);
            return null;
        } catch (Exception e) {
            log.error("Error getDistinctByFieldAndQuery1 : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<String> getDistinctByFieldAndQuery2(int age) {
        try {
            log.info("----- getDistinctByFieldAndQuery2 : {}", age);
            return null;
        } catch (Exception e) {
            log.error("Error getDistinctByFieldAndQuery2 : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<String> getDistinctByFieldAndQuery3(int age) {
        try {
            log.info("----- getDistinctByFieldAndQuery3 : {}", age);
            return null;
        } catch (Exception e) {
            log.error("Error getDistinctByFieldAndQuery3 : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<UserProfileDTO> getAllUserProfiles() {
        try {
            log.info("----- getAllUserProfiles");
            return null;
        } catch (Exception e) {
            log.error("Error getAllUserProfiles : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void getAllAndRemoveByLastName(String lastName) {
        try {
            log.info("----- getAllAndRemoveByLastName : {}", lastName);
        } catch (Exception e) {
            log.error("Error getAllAndRemoveByLastName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void getAndRemoveByLastName(String lastName) {
        try {
            log.info("----- getAndRemoveByLastName : {}", lastName);
        } catch (Exception e) {
            log.error("Error getAndRemoveByLastName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void getAndModifyByLastName(UserProfileDTO userProfileDTO) {
        try {
            log.info("----- getAndModifyByLastName");
        } catch (Exception e) {
            log.error("Error getAndModifyByLastName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public UserProfileDTO getAndModifyOptionsByLastName(UserProfileDTO userProfileDTO) {
        try {
            log.info("----- getAndModifyOptionsByLastName");
            return null;
        } catch (Exception e) {
            log.error("Error getAndModifyOptionsByLastName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public UserProfileDTO getAndReplaceByLastName(UserProfileDTO userProfileDTO) {
        try {
            log.info("----- getAndReplaceByLastName");
            return null;
        } catch (Exception e) {
            log.error("Error getAndReplaceByLastName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public UserProfileDTO getAndReplaceOptionsByLastName(UserProfileDTO userProfileDTO) {
        try {
            log.info("----- getAndReplaceOptionsByLastName");
            return null;
        } catch (Exception e) {
            log.error("Error getAndReplaceOptionsByLastName : {} {}", e.getMessage(), e);
            throw e;
        }
    }
}
