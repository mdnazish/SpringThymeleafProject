package com.mn.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mn.app.entity.Task;
import com.mn.app.entity.User;
import com.mn.app.service.TaskService;
import com.mn.app.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginRegisterApp2ApplicationTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@Before
	public void initializeDB() {
		{
			User newUser = new User("testUser@gmail.com", "TeskUser1", "user123");
			userService.createUser(newUser);
		}
		{
			User newUser = new User("testAdmin@gmail.com", "TeskAdmin1", "admin123");
			userService.createUser(newUser);
		}
		Task userTask = new Task("04/03/2019", "10:00", "12:00", "You need to work today.");
		User user = userService.findByEmail("testUser@gmail.com").get();
		taskService.addTask(userTask, user);
	}
	
	@Test
	public void testUser() {
		User user = userService.findByEmail("testUser@gmail.com").get();
		assertNotNull(user);
		
		User admin = userService.findByEmail("testAdmin@gmail.com").get();
		assertEquals(admin.getEmail(), "testAdmin@gmail.com");
	}
	
	@Test
	public void testTask() {
		User user = userService.findByEmail("testUser@gmail.com").get();
		List<Task> task = taskService.findUserTask(user);
		assertNotNull(task);
	}

}
