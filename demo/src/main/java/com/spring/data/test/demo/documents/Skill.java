package com.spring.data.test.demo.documents;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
public class Skill {

	@Id
	private ObjectId id;
	private String name;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Skill{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
