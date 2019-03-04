/**
 * 
 */
package com.mn.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mn.app.entity.Task;
import com.mn.app.entity.User;
import com.mn.app.repository.TaskRepository;

/**
 * @author Md Nazish
 *
 */
@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	// assign task to user
	public void addTask(Task task, User user) {
		task.setUser(user);
		taskRepository.save(task);
	}
	
	public List<Task> findUserTask(User user) {
		
		return taskRepository.findByUser(user);
	}
}
