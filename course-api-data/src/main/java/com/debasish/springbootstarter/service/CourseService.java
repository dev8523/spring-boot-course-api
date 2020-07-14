package com.debasish.springbootstarter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debasish.springbootstarter.model.Course;
import com.debasish.springbootstarter.repository.CourseRepository;

@Service // Spring Boot knows this is our buiseness service class.
public class CourseService {

	@Autowired // Spring boot knows this need a DI.
	private CourseRepository courseRepository;

	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList();
		courseRepository.findByTopicId(topicId).forEach(courses::add); // it means find all topics from the DB and for each of them i
														// am populating this topic list with that element.
		return courses;
	}

	public Optional<Course> getCourseByID(String id) {
		// // iterate over the array
		return courseRepository.findById(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course); // this will save a topic to the DB.
	}

	public void updateCourse(Course course) {
		courseRepository.save(course); // If the row doesn't exist then it is going to do a insert.
										// If the row does exist then it knows that it need to do an update.
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}

}
