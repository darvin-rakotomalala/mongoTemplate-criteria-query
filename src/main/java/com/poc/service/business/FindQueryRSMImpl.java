package com.poc.service.business;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.domain.UserProfile;
import com.poc.repository.find_queries.FindQueryCustomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class FindQueryRSMImpl implements FindQueryRSM {

    private final FindQueryCustomRepository findQueryCustomRepository;

    @Override
    public List<UserProfile> getUserProfilesByLastName(String lastName) {
        try {
            log.info("----- getUserProfilesByLastName : {}", lastName);
            if (StringUtils.isBlank(lastName)) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_LASTNAME_EMPTY.getErrorMessage());
            }
            return findQueryCustomRepository.findUserProfilesByLastName(lastName);
        } catch (Exception e) {
            log.error("Error getUserProfilesByLastName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<UserProfile> getUserProfilesByFirstName(String firstName) {
        try {
            log.info("----- getUserProfilesByFirstName : {}", firstName);
            if (StringUtils.isBlank(firstName)) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_FIRSTNAME_EMPTY.getErrorMessage());
            }
            return findQueryCustomRepository.findUserProfilesByFirstName(firstName);
        } catch (Exception e) {
            log.error("Error getUserProfilesByFirstName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public UserProfile getUserProfilesById(UUID id) {
        try {
            log.info("----- getUserProfilesById : {}", id);
            if (id == null) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_ID_EMPTY.getErrorMessage());
            }
            Optional<UserProfile> userFound = Optional.ofNullable(findQueryCustomRepository.findUserProfilesById(id));
            if (userFound.isEmpty()) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_NOT_FOUND.getErrorMessage());
            }
            return userFound.get();
        } catch (Exception e) {
            log.error("Error getUserProfilesById : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public UserProfile getOneByLastName(String lastName) {
        try {
            log.info("----- getOneByLastName : {}", lastName);
            if (StringUtils.isBlank(lastName)) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_FIRSTNAME_EMPTY.getErrorMessage());
            }
            return findQueryCustomRepository.findOneByLastName(lastName);
        } catch (Exception e) {
            log.error("Error getOneByLastName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<String> getDistinctByPinCode() {
        try {
            log.info("----- getDistinctByPinCode");
            return findQueryCustomRepository.findDistinctByPinCode();
        } catch (Exception e) {
            log.error("Error getDistinctByPinCode : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<String> getDistinctByFieldAndQuery1(int age) {
        try {
            log.info("----- getDistinctByFieldAndQuery1 : {}", age);
            if (age < 0) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_AGE_NOT_VALID.getErrorMessage());
            }
            return findQueryCustomRepository.findDistinctByFieldAndQuery1(age);
        } catch (Exception e) {
            log.error("Error getDistinctByFieldAndQuery1 : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<String> getDistinctByFieldAndQuery2(int age) {
        try {
            log.info("----- getDistinctByFieldAndQuery2 : {}", age);
            if (age < 0) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_AGE_NOT_VALID.getErrorMessage());
            }
            return findQueryCustomRepository.findDistinctByFieldAndQuery2(age);
        } catch (Exception e) {
            log.error("Error getDistinctByFieldAndQuery2 : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<String> getDistinctByFieldAndQuery3(int age) {
        try {
            log.info("----- getDistinctByFieldAndQuery3 : {}", age);
            if (age < 0) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_AGE_NOT_VALID.getErrorMessage());
            }
            return findQueryCustomRepository.findDistinctByFieldAndQuery3(age);
        } catch (Exception e) {
            log.error("Error getDistinctByFieldAndQuery3 : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<UserProfile> getAllUserProfiles() {
        try {
            log.info("----- getAllUserProfiles");
            return findQueryCustomRepository.findAllUserProfiles();
        } catch (Exception e) {
            log.error("Error getAllUserProfiles : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void getAllAndRemoveByLastName(String lastName) {
        try {
            log.info("----- getAllAndRemoveByLastName : {}", lastName);
            if (StringUtils.isBlank(lastName)) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_LASTNAME_EMPTY.getErrorMessage());
            }
            findQueryCustomRepository.findAllAndRemoveByLastName(lastName);
        } catch (Exception e) {
            log.error("Error getAllAndRemoveByLastName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void getAndRemoveByLastName(String lastName) {
        try {
            log.info("----- getAndRemoveByLastName : {}", lastName);
            if (StringUtils.isBlank(lastName)) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_LASTNAME_EMPTY.getErrorMessage());
            }
            findQueryCustomRepository.findAndRemoveByLastName(lastName);
        } catch (Exception e) {
            log.error("Error getAndRemoveByLastName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void getAndModifyByLastName(UserProfile userProfile) {
        try {
            log.info("----- getAndModifyByLastName");
            if (StringUtils.isBlank(userProfile.getLastName()) && StringUtils.isBlank(userProfile.getFirstName())) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_NAME_EMPTY.getErrorMessage());
            }
            findQueryCustomRepository.findAndModifyByLastName(userProfile);
        } catch (Exception e) {
            log.error("Error getAndModifyByLastName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public UserProfile getAndModifyOptionsByLastName(UserProfile userProfile) {
        try {
            log.info("----- getAndModifyOptionsByLastName");
            if (StringUtils.isBlank(userProfile.getLastName()) && StringUtils.isBlank(userProfile.getFirstName())) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_NAME_EMPTY.getErrorMessage());
            }
            return findQueryCustomRepository.findAndModifyOptionsByLastName(userProfile);
        } catch (Exception e) {
            log.error("Error getAndModifyOptionsByLastName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public UserProfile getAndReplaceByLastName(UserProfile userProfile) {
        try {
            log.info("----- getAndReplaceByLastName");
            if (StringUtils.isBlank(userProfile.getLastName()) && StringUtils.isBlank(userProfile.getFirstName())) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_NAME_EMPTY.getErrorMessage());
            }
            return findQueryCustomRepository.findAndReplaceByLastName(userProfile);
        } catch (Exception e) {
            log.error("Error getAndReplaceByLastName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public UserProfile getAndReplaceOptionsByLastName(UserProfile userProfile) {
        try {
            log.info("----- getAndReplaceOptionsByLastName");
            if (StringUtils.isBlank(userProfile.getLastName()) && StringUtils.isBlank(userProfile.getFirstName())) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_NAME_EMPTY.getErrorMessage());
            }
            return findQueryCustomRepository.findAndReplaceOptionsByLastName(userProfile);
        } catch (Exception e) {
            log.error("Error getAndReplaceOptionsByLastName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
