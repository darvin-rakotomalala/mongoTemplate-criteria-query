package com.poc.repository.regex_sorting;

import com.poc.model.domain.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegexQueryCustomRepositoryImpl implements RegexQueryCustomRepository {

    public static final String USER_PROFILE_COLLECTION = "userProfile";

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<UserProfile> regexUserProfilesByName(String name) {
        Query query = new Query();
        Criteria criteria = new Criteria().
                orOperator(
                        Criteria.where("firstName").regex(name),
                        Criteria.where("lastName").regex(name));

        query.addCriteria(criteria);
        return mongoTemplate.find(query, UserProfile.class, USER_PROFILE_COLLECTION);
    }

    @Override
    public List<UserProfile> regexWithOptionsUserProfilesByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("lastName").regex("^" + name, "i"));
        return mongoTemplate.find(query, UserProfile.class);
    }

    @Override
    public List<UserProfile> sortASCUserProfilesByLastName(String lastName) {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.ASC, "lastName"));
        return mongoTemplate.find(query, UserProfile.class);
    }

}
