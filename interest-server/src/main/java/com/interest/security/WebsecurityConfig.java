package com.interest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebsecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated();
		http.formLogin().failureUrl("/login?error").permitAll();
		http.logout().permitAll();
		http.csrf().disable();
	}

	// 配置内存模式的用户
	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService(){
	 * InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	 * manager.createUser(User.withUsername("test").password("123").authorities(
	 * "USER").build());
	 * manager.createUser(User.withUsername("test1").password("123").authorities(
	 * "USER").build()); return manager; }
	 */

	/**
	 * 需要配置这个支持password模式 support password grant type
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
