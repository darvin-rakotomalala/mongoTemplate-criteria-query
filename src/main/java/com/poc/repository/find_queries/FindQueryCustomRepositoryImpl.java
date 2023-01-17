package com.poc.repository.find_queries;

import com.poc.model.domain.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.FindAndReplaceOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FindQueryCustomRepositoryImpl implements FindQueryCustomRepository {

    public static final String USER_PROFILE_COLLECTION = "userProfile";

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<UserProfile> findUserProfilesByLastName(String lastName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("lastName").is(lastName));
        return mongoTemplate.find(query, UserProfile.class);
    }

    @Override
    public List<UserProfile> findUserProfilesByFirstName(String firstName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is(firstName));
        return mongoTemplate.find(query, UserProfile.class, USER_PROFILE_COLLECTION);
    }

    @Override
    public UserProfile findUserProfilesById(UUID id) {
        return mongoTemplate.findById(id, UserProfile.class);
    }

    @Override
    public UserProfile findOneByLastName(String lastName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("lastName").is(lastName));
        return mongoTemplate.findOne(query, UserProfile.class, USER_PROFILE_COLLECTION);
    }

    @Override
    public List<String> findDistinctByPinCode() {
        return mongoTemplate.findDistinct("pinCode", UserProfile.class, String.class);
    }

    @Override
    public List<String> findDistinctByFieldAndQuery1(int age) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gt(age));
        return mongoTemplate.findDistinct(query, "pinCode", UserProfile.class, String.class);
    }

    @Override
    public List<String> findDistinctByFieldAndQuery2(int age) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gt(age));
        return mongoTemplate.findDistinct(query, "pinCode", USER_PROFILE_COLLECTION, String.class);
    }

    @Override
    public List<String> findDistinctByFieldAndQuery3(int age) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gt(age));
        return mongoTemplate.findDistinct(query, "pinCode", USER_PROFILE_COLLECTION, UserProfile.class, String.class);
    }

    @Override
    public List<UserProfile> findAllUserProfiles() {
        return mongoTemplate.findAll(UserProfile.class, USER_PROFILE_COLLECTION);
    }

    @Override
    public void findAllAndRemoveByLastName(String lastName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("lastName").is(lastName));
        mongoTemplate.findAllAndRemove(query, UserProfile.class, USER_PROFILE_COLLECTION);
    }

    @Override
    public void findAndRemoveByLastName(String lastName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("lastName").is(lastName));
        mongoTemplate.findAndRemove(query, UserProfile.class, USER_PROFILE_COLLECTION);
    }

    @Override
    public void findAndModifyByLastName(UserProfile userProfile) {
        Query query = new Query();
        query.addCriteria(Criteria.where("lastName").is(userProfile.getLastName()));

        Update updateDef = new Update();
        updateDef.set("firstName", userProfile.getFirstName());
        mongoTemplate.findAndModify(query, updateDef, UserProfile.class, USER_PROFILE_COLLECTION);
    }

    @Override
    public UserProfile findAndModifyOptionsByLastName(UserProfile userProfile) {
        Query query = new Query();
        query.addCriteria(Criteria.where("lastName").is(userProfile.getLastName()));

        Update updateDef = new Update();
        updateDef.set("firstName", userProfile.getFirstName());

        return mongoTemplate.findAndModify(query, updateDef, new FindAndModifyOptions().returnNew(true), UserProfile.class);
    }

    @Override
    public UserProfile findAndReplaceByLastName(UserProfile userProfile) {
        Query query = new Query();
        query.addCriteria(Criteria.where("lastName").is(userProfile.getLastName()));

        UserProfile replacement = new UserProfile();
        replacement.setFirstName(userProfile.getFirstName());
        return mongoTemplate.findAndReplace(query, replacement);
    }

    @Override
    public UserProfile findAndReplaceOptionsByLastName(UserProfile userProfile) {
        Query query = new Query();
        query.addCriteria(Criteria.where("lastName").is(userProfile.getLastName()));

        UserProfile replacement = new UserProfile();
        replacement.setFirstName(userProfile.getFirstName());
        return mongoTemplate.findAndReplace(query, replacement, new FindAndReplaceOptions().returnNew());
    }

}
