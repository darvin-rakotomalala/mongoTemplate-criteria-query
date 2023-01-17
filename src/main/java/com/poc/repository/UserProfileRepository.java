package com.poc.repository;

import com.poc.model.domain.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserProfileRepository extends MongoRepository<UserProfile, UUID> {
    boolean existsUserProfileByLastName(String name);
}
