package com.poc.service.application;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.mapper.UserProfileMapper;
import com.poc.model.domain.UserProfile;
import com.poc.model.dto.UserProfileDTO;
import com.poc.repository.UserProfileCustomRepository;
import com.poc.service.business.UserProfileRSM;
import com.poc.utils.HelpPage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserProfileRSAImpl implements UserProfileRSA {

    private final UserProfileCustomRepository userProfileCustomRepository;
    private final UserProfileRSM userProfileRSM;

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Override
    public UserProfileDTO getUserById(UUID id) {
        try {
            log.info("----- getUserById : {}", id);
            if (id == null) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_ID_EMPTY.getErrorMessage());
            }
            UserProfileDTO userFound = userProfileMapper.toDTO(userProfileCustomRepository.getUserById(id));
            if (userFound == null) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_NOT_FOUND.getErrorMessage());
            }
            return userFound;
        } catch (Exception e) {
            log.error("Error getUserById : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public HelpPage<UserProfileDTO> getAllUsers(Integer page, Integer size) {
        try {
            log.info("----- getAllUsers");
            Pageable pageable = PageRequest.of(page, size);
            return userProfileMapper.toDTO(userProfileCustomRepository.getAllUsers(page, size), pageable);
        } catch (Exception e) {
            log.error("Error getAllUsers : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public HelpPage<UserProfileDTO> getUsersByName(String name, Integer page, Integer size) {
        try {
            log.info("----- getUsersByName : {} ", name);
            if (StringUtils.isBlank(name)) {
                return getAllUsers(page, size);
            } else {
                Pageable pageable = PageRequest.of(page, size);
                return userProfileMapper.toDTO(userProfileCustomRepository.getUsersByName(name, page, size), pageable);
            }
        } catch (Exception e) {
            log.error("Error getUsersByName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public boolean existByName(String name) {
        try {
            log.info("----- Get if name exist : {} ", name);
            return userProfileRSM.existByName(name);
        } catch (Exception e) {
            log.error("Error get if name exist : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public HelpPage<UserProfileDTO> searchUserProfile(List<String> input, Pageable pageable) {
        try {
            log.info("----- searchUserProfile : {} ", input);
            return userProfileMapper.toDTO(userProfileCustomRepository.searchUserProfile(input, pageable), pageable);
        } catch (Exception e) {
            log.error("Error searchUserProfile : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
