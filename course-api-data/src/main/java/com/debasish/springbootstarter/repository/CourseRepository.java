/**
 *  
 */
package com.debasish.springbootstarter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.debasish.springbootstarter.model.Course;

/**
 * @author desahoo
 *
 */
public interface CourseRepository extends CrudRepository<Course, String> { // 1st Generice type is what is the entity
																			// you
																			// are working on. 2nd is what data type the
																			// @ID (primary key) in the Entity class
																			// has.

	public List<Course> findByTopicId(String topicId); // You don't have to implement the method. Just declare the method
													// with the findByProperty name format and Spring Data JPA will
													// implement it for you.

}
