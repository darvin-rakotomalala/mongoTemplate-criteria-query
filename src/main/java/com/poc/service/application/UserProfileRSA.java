package com.poc.service.application;

import com.poc.model.dto.UserProfileDTO;
import com.poc.utils.HelpPage;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserProfileRSA {
    UserProfileDTO getUserById(UUID id);
    HelpPage<UserProfileDTO> getAllUsers(Integer page, Integer size);
    HelpPage<UserProfileDTO> getUsersByName(String name, Integer page, Integer size);
    public boolean existByName(String name);
    HelpPage<UserProfileDTO> searchUserProfile(List<String> input, Pageable pageable);
}
