package com.spring.data.test.demo.dao;

import com.spring.data.test.demo.models.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateDAO extends CrudRepository<Candidate, Long> {

	List<Candidate> findByFirstName(String firstName);

	List<Candidate> findTop2ByOrderByLastNameDesc();
}