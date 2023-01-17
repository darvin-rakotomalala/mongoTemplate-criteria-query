package com.poc.repository.operators;

import com.mongodb.client.result.UpdateResult;
import com.poc.model.domain.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorsCudCustomRepositoryImpl implements OperatorsCudCustomRepository {

    public static final String USER_PROFILE_COLLECTION = "userProfile";

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public UserProfile saveUserProfile(UserProfile userProfile) {
        return mongoTemplate.save(userProfile);
    }

    @Override
    public UserProfile insertUserProfile(UserProfile userProfile) {
        return mongoTemplate.insert(userProfile);
    }

    @Override
    public List<UserProfile> insertAllUsers(List<UserProfile> userProfiles) {
        return (List<UserProfile>) mongoTemplate.insertAll(userProfiles);
    }

    @Override
    public UpdateResult upsertUserProfile(UserProfile userProfile) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(userProfile.getId()));
        // update definition
        Update updateDef = new Update();
        updateDef.set("firstName", userProfile.getFirstName());
        updateDef.set("lastName", userProfile.getLastName());
        return mongoTemplate.upsert(query, updateDef, UserProfile.class);
    }

    /*
    @Override
    public String upsertCity(City city) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(city.getId()));
        Update updateDefinition = new Update().set("cityName", city.getCityName());

        UpdateResult updateResult = mongoTemplate.upsert(query, updateDefinition, City.class);
        return updateResult.getUpsertedId().toString();
    } */

    @Override
    public Long updateFirstUserProfile(UserProfile userProfile) {
        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is(userProfile.getFirstName()));
        // update definition
        Update updateDef = new Update();
        updateDef.set("lastName", userProfile.getLastName());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, updateDef, UserProfile.class);
        return updateResult.getModifiedCount();
    }

    @Override
    public UpdateResult updateMultiUserProfile(UserProfile userProfile) {
        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is(userProfile.getFirstName()));
        // update definition
        Update updateDef = new Update();
        updateDef.set("lastName", userProfile.getLastName());
        return mongoTemplate.updateMulti(query, updateDef, UserProfile.class);
    }

    @Override
    public List<UserProfile> countSkipLimitUsersByAge(int age) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gt(age));
        query.skip(1);
        query.limit(1);
        return mongoTemplate.find(query, UserProfile.class);
    }

}
