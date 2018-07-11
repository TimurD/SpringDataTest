package com.spring.data.test.demo;

import com.spring.data.test.demo.dao.CandidateDAO;
import com.spring.data.test.demo.dao.CandidateMongoDAO;
import com.spring.data.test.demo.dao.SkillDAO;
import com.spring.data.test.demo.dao.SkillMongoDAO;
import com.spring.data.test.demo.models.Candidate;
import com.spring.data.test.demo.models.Skill;
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
public class JpaRepositoryTest {

	@Autowired
	private CandidateDAO candidateDAO;
	@Autowired
	private SkillDAO skillDAO;
	@Test
	public void selectCandidateByIdTest() {
		Candidate candidate = candidateDAO.findById(1L).get();
		System.out.println(candidate);
	}

	@Test
	public void selectCandidatesByFirstNameTest() {
		candidateDAO.findByFirstName("Vlad").forEach(System.out::println);
	}

	@Test
	public void selectCandidatesBySkillTest() {
		Skill skill = skillDAO.findById(1L).get();
		skill.getCandidates().forEach(System.out::println);
	}

	@Test
	public void selectSkillCountTest() {
		System.out.println(skillDAO.count());
	}

	@Test
	public void addCandidateWithSkillTest() {
		Skill skill = new Skill();
		skill.setName("Test");
		Candidate candidate = new Candidate();
		candidate.setSkills(Collections.singletonList(skill));
		candidate.setFirstName("TestFN");
		candidate.setLastName("TestLN");
		System.out.println(candidateDAO.save(candidate));
	}

	@Test
	public void findTop2ByOrderByLastNameDescTest() {
		candidateDAO.findTop2ByOrderByLastNameDesc().forEach(System.out::println);
	}
}