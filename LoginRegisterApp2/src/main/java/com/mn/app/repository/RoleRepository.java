/**
 * 
 */
package com.mn.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mn.app.entity.Role;

/**
 * @author Md Nazish
 *
 */
public interface RoleRepository extends JpaRepository<Role, String> {

}
