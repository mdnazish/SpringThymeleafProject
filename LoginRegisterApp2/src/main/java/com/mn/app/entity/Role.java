/**
 * 
 */
package com.mn.app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author Md Nazish
 *
 */
@Entity
public class Role {

	// private fields
	@Id
	private String name;
	@ManyToMany(mappedBy = "roles")
	private List<User> users;

	// Constructors
	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public Role(String name, List<User> users) {
		this.name = name;
		this.users = users;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getusers() {
		return users;
	}

	public void setusers(List<User> users) {
		this.users = users;
	}

}
