package com.Web.BookExchange.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.usersByUsernameQuery("select user_name,password,enabled from Normal_User where user_name = ?")
		.authoritiesByUsernameQuery("select user_name, role from Normal_User where user_name = ?")
		.dataSource(dataSource).passwordEncoder(pwEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		//.antMatchers("/user/**").permitAll()
		.antMatchers("/user/addbooks/**").permitAll()
		.antMatchers("/user/browsebooks/**").permitAll()
		.antMatchers("/user/yourbooks/**").permitAll()
		.antMatchers("/user/borrowedbooks/**").permitAll()
		.antMatchers("/user/notifications/**").permitAll()
		.antMatchers("/user/wallet/**").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/adminservice/**").hasRole("ADMIN")
		.antMatchers("/login/**").permitAll()
		.antMatchers("/register/**").permitAll()
		.antMatchers("/logout/**").permitAll()
		.antMatchers("/**").authenticated().and().formLogin().loginPage("/login");
	}
}