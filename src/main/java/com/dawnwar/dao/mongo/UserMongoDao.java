package com.dawnwar.dao.mongo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dawnwar.entity.UserModel;


@Repository
public class UserMongoDao{
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	public void test(){
		
		mongoTemplate.insert(new UserModel("zzz", 10), "user");
		Query query = new Query(Criteria.where("name").is("zzz"));
		UserModel userModel = mongoTemplate.findOne(query, UserModel.class, "user");
		userModel.toString();
		
	}
}
