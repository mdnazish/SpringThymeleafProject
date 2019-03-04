/**
 * 
 */
package com.mn.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mn.app.entity.Task;
import com.mn.app.entity.User;

/**
 * @author Md Nazish
 *
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByUser(User user);

}
