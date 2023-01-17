package com.poc.service.application;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.mapper.UserProfileMapper;
import com.poc.model.dto.UserProfileDTO;
import com.poc.repository.UserProfileCustomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserProfileCUDSAImpl implements UserProfileCUDSA {

    private final UserProfileCustomRepository userProfileCustomRepository;
    private final UserProfileMapper userProfileMapper;

    @Override
    public UserProfileDTO saveUser(UserProfileDTO userProfile) {
        try {
            log.info("----- saveUser");
            if (userProfile == null) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_EMPTY.getErrorMessage());
            }
            return userProfileMapper.toDTO(userProfileCustomRepository.saveUser(userProfileMapper.toDO(userProfile)));
        } catch (Exception e) {
            log.error("Error saveUser : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<UserProfileDTO> saveAllUsers(List<UserProfileDTO> userProfiles) {
        try {
            log.info("----- saveAllUsers");
            return userProfileMapper.toDTO(
                    userProfileCustomRepository.saveAllUsers(userProfileMapper.toDO(userProfiles)));
        } catch (Exception e) {
            log.error("Error saveAllUsers : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public UserProfileDTO updateUser(UserProfileDTO userProfile) {
        try {
            log.info("----- updateUser");
            if (userProfile == null || userProfile.getId() == null) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_EMPTY.getErrorMessage());
            }
            UserProfileDTO userFound = userProfileMapper.toDTO(userProfileCustomRepository.getUserById(userProfile.getId()));
            if (userFound == null) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_NOT_FOUND.getErrorMessage());
            }
            userFound.setFirstName(userProfile.getFirstName());
            userFound.setLastName(userProfile.getLastName());
            userFound.setAge(userProfile.getAge());
            userFound.setGender(userProfile.getGender());
            userFound.setMobile(userProfile.getMobile());
            userFound.setEmailId(userProfile.getEmailId());
            userFound.setProfession(userProfile.getProfession());
            userFound.setPinCode(userProfile.getPinCode());
            userFound.setRoles(userProfile.getRoles());
            userFound.setUpdateDate(Instant.now());

            return userProfileMapper.toDTO(userProfileCustomRepository.updateUser(userProfileMapper.toDO(userFound)));
        } catch (Exception e) {
            log.error("Error updateUser : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteUserById(UUID id) {
        try {
            log.info("----- deleteUserById {}", id);
            if (id == null) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_ID_EMPTY.getErrorMessage());
            }
            UserProfileDTO userFound = userProfileMapper.toDTO(userProfileCustomRepository.getUserById(id));
            if (userFound == null) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_NOT_FOUND.getErrorMessage());
            }
            userProfileCustomRepository.deleteUserById(userProfileMapper.toDO(userFound));
        } catch (Exception e) {
            log.error("Error deleteUserById : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
