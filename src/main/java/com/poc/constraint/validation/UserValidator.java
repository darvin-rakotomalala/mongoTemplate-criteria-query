package com.poc.constraint.validation;

import com.poc.exception.ErrorsEnum;
import com.poc.model.dto.UserProfileDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserProfileDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserProfileDTO userProfileDTO = (UserProfileDTO) target;
        if (StringUtils.isEmpty(userProfileDTO.getLastName())) {
            errors.rejectValue("lastName", "lastName.value.empty", ErrorsEnum.ERR_MCS_USER_LASTNAME_EMPTY.getErrorMessage());
        }
    }

}
