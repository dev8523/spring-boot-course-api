package com.debasish.springbootstarter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debasish.springbootstarter.model.Topic;
import com.debasish.springbootstarter.repository.TopicRepository;

@Service // Spring Boot knows this is our buiseness service class.
public class TopicService {

	@Autowired // Spring boot knows this need a DI.
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add); // it means find all topics from the DB and for each of them i
														// am populating this topic list with that element.
		return topics;
	}

	public Optional<Topic> getTopicByID(String id) {
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		// // iterate over the array
		return topicRepository.findById(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic); // this will save a topic to the DB.
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic); // If the row doesn't exist then it is going to do a insert.
										// If the row does exist then it knows that it need to do an update.
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}

}
