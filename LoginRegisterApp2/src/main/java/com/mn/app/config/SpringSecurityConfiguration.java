/**
 * 
 */
package com.mn.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Md Nazish
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT email as principal, password as credentials, true FROM user WHERE email=?")
					.authoritiesByUsernameQuery("SELECT user_email as principal, role_name as role FROM user_roles WHERE user_email=?")
						.passwordEncoder(passwordEncoder())
							.rolePrefix("ROLE_");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/home", "/index", "/login", "/register", "/about", "/css/**", "/webjars/**").permitAll() // any one can access these URLs
			.antMatchers("/profile").hasAnyRole("ADMIN,USER") // Either USER or ADMIN can access.
			.antMatchers("/users","/add-task").hasRole("ADMIN") // only ADMIN can access
				.and()
					.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/profile") // Set Default Page after Login
				.and()
					.logout().logoutSuccessUrl("/login"); // After Logout redirect to Login page
	}
}
