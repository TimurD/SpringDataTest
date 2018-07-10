package com.spring.data.test.demo.dao;

import com.spring.data.test.demo.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillDAO extends CrudRepository<Skill, Long> {
}
