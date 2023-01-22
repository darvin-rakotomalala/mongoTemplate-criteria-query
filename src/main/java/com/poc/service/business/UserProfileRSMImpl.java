package com.poc.service.business;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserProfileRSMImpl implements UserProfileRSM {

    private final UserProfileRepository userProfileRepository;

    @Override
    public boolean existByName(String name) {
        try {
            log.info("----- existByName : {}", name);
            if (StringUtils.isBlank(name)) {
                throw new FunctionalException(ErrorsEnum.ERR_MCS_USER_LASTNAME_EMPTY.getErrorMessage());
            }
            return userProfileRepository.existsUserProfileByLastName(name);
        } catch (Exception e) {
            log.error("Error existByName : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
