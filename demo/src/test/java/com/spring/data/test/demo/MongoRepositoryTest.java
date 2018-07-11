package com.spring.data.test.demo;

import com.spring.data.test.demo.dao.CandidateMongoDAO;
import com.spring.data.test.demo.dao.SkillMongoDAO;
import com.spring.data.test.demo.documents.Candidate;
import com.spring.data.test.demo.documents.Skill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MongoRepositoryTest {

	@Autowired
	private CandidateMongoDAO candidateMongoDAO;
	@Autowired
	private SkillMongoDAO skillMongoDAO;

	@Test
	public void selectCandidatesByFirstNameMongoTest() {
		candidateMongoDAO.findByFirstName("Tymur").forEach(System.out::println);
	}

	@Test
	public void selectSkillByNameTest() {
		skillMongoDAO.findByName("java").forEach(System.out::println);
	}

	@Test
	public void addCandidateWithSkillTest() {
		Skill skill = new Skill();
		skill.setName("Test");
		Candidate candidate = new Candidate();
		candidate.setSkillsIds(Collections.singletonList(skillMongoDAO.save(skill)));
		candidate.setFirstName("TestFN");
		candidate.setLastName("TestLN");
		System.out.println(candidateMongoDAO.save(candidate));
	}

	@Test
	public void findTop2ByOrderByLastNameDescTest() {
		candidateMongoDAO.findTop2ByOrderByLastNameDesc().forEach(System.out::println);
	}
}
