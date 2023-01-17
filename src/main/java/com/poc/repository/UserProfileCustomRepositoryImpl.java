package com.poc.repository;

import com.poc.model.domain.UserProfile;
import com.poc.repository.utils.MongoRepositoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserProfileCustomRepositoryImpl implements UserProfileCustomRepository {

    public static final String USER_PROFILE_COLLECTION = "userProfile";

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public UserProfile saveUser(UserProfile userProfile) {
        userProfile.setId(UUID.randomUUID());
        userProfile.setCreateDate(Instant.now());
        userProfile.setUpdateDate(Instant.now());
        return mongoTemplate.save(userProfile);
    }

    @Override
    public List<UserProfile> saveAllUsers(List<UserProfile> userProfiles) {
        List<UserProfile> newUsers = new ArrayList<>();
        userProfiles.forEach(userProfile -> {
            newUsers.add(saveUser(userProfile));
        });
        return newUsers;
    }

    @Override
    public UserProfile getUserById(UUID id) {
        return mongoTemplate.findById(id, UserProfile.class);
    }

    @Override
    public UserProfile updateUser(UserProfile userProfile) {
        return mongoTemplate.save(userProfile);
    }

    @Override
    public void deleteUserById(UserProfile userProfile) {
        mongoTemplate.remove(userProfile);
    }

    @Override
    public Page<UserProfile> getAllUsers(Integer page, Integer size) {

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "lastName");
        Query query = new Query();
        query.with(pageable);

        return PageableExecutionUtils.getPage(
                mongoTemplate.find(query, UserProfile.class),
                pageable,
                () -> mongoTemplate.count(query.skip(0).limit(0), UserProfile.class)
        );
    }

    @Override
    public Page<UserProfile> getUsersByName(String name, Integer page, Integer size) {

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "lastName");

        Query query = new Query();

        Criteria criteria = new Criteria().
                orOperator(
                        Criteria.where("firstName").is(name),
                        Criteria.where("lastName").is(name));

        query.addCriteria(criteria).with(pageable);

        return PageableExecutionUtils.getPage(
                mongoTemplate.find(query, UserProfile.class),
                pageable,
                () -> mongoTemplate.count(query.skip(0).limit(0), UserProfile.class)
        );
    }

    @Override
    public Page<UserProfile> searchUserProfile(List<String> input, Pageable pageable) {
        Criteria criteria = new Criteria().orOperator(
                Criteria.where("firstName").in(input),
                Criteria.where("mobile").in(input),
                Criteria.where("lastName").in(input));
        return MongoRepositoryUtils.search(criteria, USER_PROFILE_COLLECTION, UserProfile.class, pageable, mongoTemplate);
    }

}
