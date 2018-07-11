package com.spring.data.test.demo.dao;

import com.spring.data.test.demo.documents.Skill;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SkillMongoDAO extends MongoRepository<Skill,ObjectId> {

	List<Skill> findByName(String name);
}
