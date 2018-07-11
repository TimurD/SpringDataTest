package com.spring.data.test.demo.documents;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.List;

@Document
public class Candidate {

	@Id
	private ObjectId id;
	private String firstName;
	private String lastName;
	@DBRef
	@Field("skills_ids")
	private List<Skill> skillsIds;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public List<Skill> getSkillsIds() {
		return skillsIds;
	}

	public void setSkillsIds(List<Skill> skillsIds) {
		this.skillsIds = skillsIds;
	}

	@Override
	public String toString() {
		return "Candidate{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", skills=" + skillsIds +
				'}';
	}
}
