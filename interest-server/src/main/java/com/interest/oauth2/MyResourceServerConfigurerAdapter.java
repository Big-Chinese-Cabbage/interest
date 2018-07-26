package com.interest.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class MyResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.
		authorizeRequests()
		.antMatchers("/public/**").permitAll()
		.antMatchers("/authentication/github").permitAll()
		.antMatchers("/register").permitAll()
		.antMatchers("/**/*.jpg","/**/*.png","/**/*.jpeg").permitAll()
		.antMatchers("/users/**","/menus/**","/roles/**","/admin/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated();
	}

}
