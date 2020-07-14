/**
 *  
 */
package com.debasish.springbootstarter.repository;

import org.springframework.data.repository.CrudRepository;

import com.debasish.springbootstarter.model.Topic;

/**
 * @author desahoo
 *
 */
public interface TopicRepository extends CrudRepository<Topic, String> { // 1st Generice type is what is the entity you
																			// are working on. 2nd is what data type the
																			// @ID (primary key) in the Entity class has.

}
