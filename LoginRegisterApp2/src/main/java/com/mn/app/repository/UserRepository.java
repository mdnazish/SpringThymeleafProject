/**
 * 
 */
package com.mn.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mn.app.entity.User;

/**
 * @author Md Nazish
 *
 */
public interface UserRepository extends JpaRepository<User, String> {

}
