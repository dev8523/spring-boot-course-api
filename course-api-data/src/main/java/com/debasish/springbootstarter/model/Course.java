package com.debasish.springbootstarter.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity // for table name
public class Course {

	@Id // tells that id is the primary key here in DB.
	private String id;
	private String name;
	private String description;

	@ManyToOne // We can map many topics to one course.
	private Topic topic;
	
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Course() {

	}

	public Course(String id, String name, String description, String topicId) {
		//super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "", "");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
