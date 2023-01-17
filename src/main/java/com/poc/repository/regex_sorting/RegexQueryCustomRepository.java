package com.poc.repository.regex_sorting;

import com.poc.model.domain.UserProfile;

import java.util.List;

public interface RegexQueryCustomRepository {
    List<UserProfile> regexUserProfilesByName(String name);
    List<UserProfile> regexWithOptionsUserProfilesByName(String name);

    List<UserProfile> sortASCUserProfilesByLastName(String lastName);
}
