/**
 * 
 */
package com.mn.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mn.app.entity.User;

/**
 * @author Md Nazish
 *
 */
public interface UserRepository extends JpaRepository<User, String> {

	List<User> findByNameLike(String string);

}
