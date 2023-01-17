package com.poc.mapper;

import com.poc.common.mapper.DtoMapper;
import com.poc.model.domain.UserProfile;
import com.poc.model.dto.UserProfileDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserProfileMapper extends DtoMapper<UserProfileDTO, UserProfile> {

}
