package com.assignment.Book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user")
			.password("password")
			.roles("USER")
			.and()
			.withUser("admin")
			.password("password")
			.roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/books/showFormForAdd").hasRole("ADMIN")
			.antMatchers("/books/showFormForUpdate").hasRole("ADMIN")
			.antMatchers("/books/save").hasRole("ADMIN")
			.antMatchers("/books/delete").hasRole("ADMIN")
			.antMatchers("/books/list").hasAnyRole("USER","ADMIN")
			.and()
			.formLogin().and()
			.logout();
	}
	
	

}
