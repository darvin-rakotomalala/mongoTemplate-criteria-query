package com.poc.repository.operators;

import com.poc.model.domain.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorsCustomRepositoryImpl implements OperatorsCustomRepository {

    public static final String USER_PROFILE_COLLECTION = "userProfile";

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<UserProfile> findByLastName(String lastName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("lastName").is(lastName));
        return mongoTemplate.find(query, UserProfile.class);
    }

    @Override
    public List<UserProfile> findUsersIsNotEqualOrNotLastName(String lastName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("lastName").ne(lastName));
        return mongoTemplate.find(query, UserProfile.class);
    }

    @Override
    public List<UserProfile> findUsersGreaterThanOrEqualAge(int age) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gte(age));
        return mongoTemplate.find(query, UserProfile.class);
    }

    @Override
    public List<UserProfile> findUsersLessThanOrEqualAge(int age) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").lte(age));
        return mongoTemplate.find(query, UserProfile.class);
    }

    @Override
    public List<UserProfile> findUsersInRoles(List<String> roles) {
        Query query = new Query();
        query.addCriteria(Criteria.where("roles").in(roles));
        return mongoTemplate.find(query, UserProfile.class);
    }

    @Override
    public List<UserProfile> findUsersNotInRoles(List<String> roles) {
        Query query = new Query();
        query.addCriteria(Criteria.where("roles").nin(roles));
        return mongoTemplate.find(query, UserProfile.class);
    }

    @Override
    public List<UserProfile> findByFirstNameAndLastName(String firstName, String lastName) {
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("firstName").is(firstName), Criteria.where("lastName").is(lastName));
        Query query = new Query();
        query.addCriteria(criteria);
        return mongoTemplate.find(query, UserProfile.class);
    }

    @Override
    public List<UserProfile> findByFirstNameOrLastName(String firstName, String lastName) {
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("firstName").is(firstName), Criteria.where("lastName").is(lastName));
        Query query = new Query();
        query.addCriteria(criteria);
        return mongoTemplate.find(query, UserProfile.class);
    }

    @Override
    public List<UserProfile> findUsersNorName(String firstName, String lastName) {
        Criteria criteria = new Criteria();
        criteria.norOperator(Criteria.where("firstName").is(firstName), Criteria.where("lastName").is(lastName));
        Query query = new Query();
        query.addCriteria(criteria);
        return mongoTemplate.find(query, UserProfile.class);
    }

}
