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

import com.debasish.springbootstarter.model.Course;
import com.debasish.springbootstarter.model.Topic;
import com.debasish.springbootstarter.service.CourseService;
import com.debasish.springbootstarter.service.TopicService;

@RestController // Spring boot knows this is a REST API controller
public class CourseController {

	@Autowired // This means this needs a dependency injection.
	private CourseService courseService; // instance

	@RequestMapping("/topics/{id}/courses") // by deafult it takes GET method
	public List<Course> getAllCourses(@PathVariable String id) { // It automatically takes the response as in the JSON format as it is a REST
											// controller.

		// Spring MVC is going to take the effort to convert the list of topics into a
		// JSON and that JSON is going to be return.
		return courseService.getAllCourses(id);
	}

	@GetMapping("/topics/{topicId}/courses/{id}") // here {} is the syntax for passing variable.
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourseByID(id);
	}

	// @RequestMapping(method = RequestMethod.POST, value = "/topics") // OR
	@PostMapping("/topics/{topicId}/courses")
	public void addCourse(@Validated @RequestBody Course course, @PathVariable String topicId) { // @RequestBody tells Spring MVC that our req payload is
																// gonna contain a JSON representation of this topic
																// instance and we are asking it to take that requet
																// body and convert into a topic instance and pass it to
																// the addTopic() when this URL is mapped

		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}

	@PutMapping("/topics/{topicId}/courses/{id}")
	public void updateCourse(@PathVariable String id, @PathVariable String topicId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	} 

	@DeleteMapping("/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
