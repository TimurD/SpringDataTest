package com.spring.data.test.demo.dao;

import com.spring.data.test.demo.documents.Candidate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CandidateMongoDAO extends MongoRepository<Candidate, ObjectId> {

	List<Candidate> findByFirstName(String firstName);

	List<Candidate> findTop2ByOrderByLastNameDesc();
}
