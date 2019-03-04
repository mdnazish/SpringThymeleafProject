/**
 * 
 */
package com.mn.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mn.app.entity.Task;

/**
 * @author Md Nazish
 *
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

}
