package com.poc.repository.operators;

import com.poc.model.domain.UserProfile;

import java.util.List;

public interface OperatorsCustomRepository {
    List<UserProfile> findByLastName(String lastName);
    List<UserProfile> findUsersIsNotEqualOrNotLastName(String lastName);
    List<UserProfile> findUsersGreaterThanOrEqualAge(int age);
    List<UserProfile> findUsersLessThanOrEqualAge(int age);
    List<UserProfile> findUsersInRoles(List<String> roles);
    List<UserProfile> findUsersNotInRoles(List<String> roles);
    List<UserProfile> findByFirstNameAndLastName(String firstName, String lastName);
    List<UserProfile> findByFirstNameOrLastName(String firstName, String lastName);
    List<UserProfile> findUsersNorName(String firstName, String lastName);
}
