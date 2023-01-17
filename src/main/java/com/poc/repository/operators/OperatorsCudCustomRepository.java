package com.poc.repository.operators;

import com.mongodb.client.result.UpdateResult;
import com.poc.model.domain.UserProfile;

import java.util.List;

public interface OperatorsCudCustomRepository {
    UserProfile saveUserProfile(UserProfile userProfile);
    UserProfile insertUserProfile(UserProfile userProfile);
    List<UserProfile> insertAllUsers(List<UserProfile> userProfiles);
    UpdateResult upsertUserProfile(UserProfile userProfile);
    Long updateFirstUserProfile(UserProfile userProfile);
    UpdateResult updateMultiUserProfile(UserProfile userProfile);

    List<UserProfile> countSkipLimitUsersByAge(int age);
}
