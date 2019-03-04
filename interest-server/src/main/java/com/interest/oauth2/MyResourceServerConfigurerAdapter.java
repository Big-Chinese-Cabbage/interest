package com.interest.oauth2;

import com.interest.exception.InterestAuthenticationEntryPoint;
import com.interest.exception.handler.InterestAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class MyResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {

	@Autowired
	private InterestAccessDeniedHandler interestAccessDeniedHandler;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.authenticationEntryPoint(new InterestAuthenticationEntryPoint()).accessDeniedHandler(interestAccessDeniedHandler);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.
		authorizeRequests()
		.antMatchers("/public/**").permitAll()
		.antMatchers("/authentication/github","/authentication/qq").permitAll()
		.antMatchers("/register").permitAll()
		.antMatchers("/**/*.jpg","/**/*.png","/**/*.jpeg").permitAll()
		.antMatchers("/interest/**").permitAll()
		.antMatchers("/users/**","/menus/**","/roles/**","/admin/**").hasRole("ADMIN")
		.antMatchers("/**/*.html","/**/*.css","/**/*.js","/**/swagger-resources/**","/**/*.woff2","/**/v2/**").permitAll()
		.anyRequest()
		.authenticated();

		http.cors()
			.and()
			.csrf().disable();

	}

}
