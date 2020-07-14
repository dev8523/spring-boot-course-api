package com.debasish.springbootstarter.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.debasish.springbootstarter.model.Topic;
import com.debasish.springbootstarter.service.TopicService;

@RestController // Spring boot knows this is a REST API controller
public class TopicController {

	@Autowired // This means this needs a dependency injection.
	private TopicService topicService; // instance

	@RequestMapping("/topics") // by deafult it takes GET method
	public List<Topic> getAllTopiccs() { // It automatically takes the response as in the JSON format as it is a REST
											// controller.

		// Spring MVC is going to take the effort to convert the list of topics into a
		// JSON and that JSON is going to be return.
		return topicService.getAllTopics();
	}

	@GetMapping("/topics/{id}") // here {} is the syntax for passing variable.
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopicByID(id);
	}

	// @RequestMapping(method = RequestMethod.POST, value = "/topics") // OR
	@PostMapping("/topics")
	public void addTopic(@Validated @RequestBody Topic topic) { // @RequestBody tells Spring MVC that our req payload is
																// gonna contain a JSON representation of this topic
																// instance and we are asking it to take that requet
																// body and convert into a topic instance and pass it to
																// the addTopic() when this URL is mapped

		topicService.addTopic(topic);
	}

	@PutMapping("/topics/{id}")
	public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
		topicService.updateTopic(id, topic);
	}

	@DeleteMapping("/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
